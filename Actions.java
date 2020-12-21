import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.io.File;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Actions extends ListenerAdapter {
    //Stores at most one query per user if the user searches for a spell/feat that had multiple possible results
    static Hashtable<User, userQuery<?>> storedUserQueries = new Hashtable<>();

    @Override   //This method is triggered everytime a message is sent in the discord server
    public void onGuildMessageReceived(final GuildMessageReceivedEvent event)
    {
        if (!event.getChannel().canTalk() || event.getAuthor().isBot() || !Main.guildWhitelist.contains(event.getChannel().getGuild().getIdLong()))   //If the message was sent in a channel our bot can't respond in, by a bot, or isn't on the whitelist then ignore it
            return;
        topLevelHandler(new MessageEvent(event));

    }

    @Override   //This method is triggered by private messages to the bot
    public void onPrivateMessageReceived(final PrivateMessageReceivedEvent event)
    {
        if(event.getAuthor().isBot())   //If the message sent is from a bot, then ignore it
            return;
        topLevelHandler(new MessageEvent(event));
    }

    //This method separates the first string separated by " " and uses a switch on that term to determine what to do
    private void topLevelHandler(final MessageEvent messageEvent)
    {
        final String message = messageEvent.getMessage();
        if(message.length() < 2 || message.charAt(0) != Main.triggerCharacter)
            return; //If message doesn't begin with ; or is just one character then invalid so exit

        addAndUpdateUsageStats(messageEvent);   //Log this message activity
        final String[] parsedMessage = separateFirstTerm(message.substring(1));
        switch(parsedMessage[0].toUpperCase())
        {
            case "SPELL":
            case "SPELLS":
                String returnVal = spellCommandHandler(parsedMessage[1].toUpperCase(), messageEvent.getChannel(), messageEvent.getAuthor());

                //If an error occurred while executing that can't be attributed to user error, send report to admin
                if(returnVal == null)
                    return;
                reportError(messageEvent, returnVal);
                break;
            case "FEAT":
            case "FEATS":
            case "FEATURE":
            case "FEATURES":
                featCommandHandler(parsedMessage[1].toUpperCase(), messageEvent.getChannel(), messageEvent.getAuthor());
                break;
            case "COND":
            case "CONDS":
            case "CONDITION":
            case "CONDITIONS":
                condCommandHandler(parsedMessage[1].toUpperCase(), messageEvent.getChannel(), messageEvent.getAuthor());
                break;
            case "RE":

                responseCommandHandler(messageEvent.getAuthor(), parsedMessage[1], messageEvent.getChannel());
                break;
            case "SPELLLIST":
                spellListCommandHandler(parsedMessage[1].toUpperCase(), messageEvent.getChannel(), messageEvent.getAuthor());
                break;
            case "CLASS":
                classCommandHandler(parsedMessage[1].toUpperCase(), messageEvent.getChannel(), messageEvent.getAuthor());
                break;
            case "BOT":
                adminCommandHandler(parsedMessage[1], messageEvent.getChannel(), messageEvent.getAuthor());
                break;
            case "INFO":
            case "HELP":
                String helpText = "This is a bot for 5e dnd that hopefully speeds up some parts of online dnd.\n" +
                        "Commands:\n" +
                        ";spell help\n" +
                        ";feat help\n" +
                        ";class help\n" +
                        ";spellList help\n" +
                        ";changelog\n" +
                        "It responds to private messages as well.";
                if(messageEvent.getType() == MessageEvent.eventType.GUILD && !parsedMessage[1].equals("-pm"))
                    messageEvent.getChannel().sendMessage(helpText).queue();
                else
                    messageEvent.getAuthor().openPrivateChannel().complete().sendMessage(helpText).queue();
                break;
            case "CHANGELOG":
                String changelogText = "Changelog:\n" +
                        "Made ;spellList more flexible to formatting\n" +
                        "`;spellList c:wiz lvl:cantrip sch:evoc` is now valid for instance.\n" +
                        "You can now use partial names for `class:` `school:` `level:` as well as the actual class and school of the spell. `level:cantrip` is now accepted for `level:0`";
                if(messageEvent.getType() == MessageEvent.eventType.GUILD && !parsedMessage[1].equals("-pm"))
                    messageEvent.getChannel().sendMessage(changelogText).queue();
                else
                    messageEvent.getAuthor().openPrivateChannel().complete().sendMessage(changelogText).queue();
                break;

            default:
                messageEvent.getChannel().sendMessage("Unrecognized command.").queue();
                break;
        }
    }

    //;spell command. Returns an image of the spell or a list of similar spells. Note: images of the PHB are not included in this repository
    //Format: ;spell [string here]. ex. ";spell fire bolt"
    private String spellCommandHandler(String searchTerm, final MessageChannel channel, final User author)    //searchTerm is all uppercase
    {
        if(searchTerm.equals("HELP"))
        {
            author.openPrivateChannel().complete().sendMessage("Spell Command - Returns an image of the spell or a list of similar spells.\nFormat: ;spell [string here]\nEx. \";spell Aid\"").queue();
            return null;
        }

        final String searchSpell = searchTerm.replaceAll("[^A-Z]",""); //searchSpell is all caps letters only
        if(searchSpell.length() == 0)
        {   //If the searchTerm is symbols return because it is invalid
            channel.sendMessage("I'm sorry but I'm not a symbologist. How about adding some letters in there?").queue();
            return null;
        }

        /*  Search through spells   */
        final ArrayList<dndSpells> matches = new ArrayList<>();   //This ArrayList stores every spell that has the searchTerm as a substring. Essentially it holds a list of spells that might be the one the user is searching for
        dndSpells exactMatch = null;                                //This dndSpells is null by default but is assigned a dndSpells enum if the searchTerm exactly matches a spell. Essentially if this isn't null an exact match for the search term was found.

        if(dndSpells.isValid(searchSpell))  //Check if there is a valid spell that exactly matches the searchTerm.
        {
            exactMatch = dndSpells.valueOf(searchSpell);
        }
        else
        {
            //Iterate through all spells in dndSpells and add any spell that searchTerm is a substring of
            for(dndSpells searchAgainstSpell : EnumSet.allOf(dndSpells.class))                              //Go through the list of spells
                if (searchAgainstSpell.name().contains(searchSpell))     //If the spell we are currently comparing against contains the term we are searching for
                    matches.add(searchAgainstSpell);
        }

        /*  Handle results  */
        if(exactMatch != null || matches.size() == 1) //If an exact match to searchSpell or only one spell in dndSpells contained searchSpell, then retrieve file and respond to message
        {
            final dndSpells imageName = (exactMatch != null ? exactMatch : matches.remove(0));
            return spellResultSender(channel, imageName);
        }
        else if(matches.size() != 0) //Multiple spells were found that contained searchSpell. ex. searchSpell = "FIRE" would return "FIREBOLT", "FIREBALL", etc...
        {
            String response = "Hmm... I found a couple of spells that remind me of that one:\n";

            Collections.sort(matches, new dndSpells.spellSorter());  //Sort the list. Enum is ordered by declaration order by default.
            storedUserQueries.put(author, new userQuery(author, new ArrayList<>(matches), userQuery.queryType.SPELL));

            int i = 0;
            while(matches.size() != 0) //Go through all the spells that contained the searchSpell and print them out
            {
                response += String.format("%d. %s\n",i++, matches.remove(0).toString());
            }
            largeMessageSender(response, channel);
            return null;
        }
        else //No spell contained the searchSpell
        {
            channel.sendMessage("I'm sorry, but I couldn't find that spell.").queue();
            return null;
        }
    }

    //;feat command, mechanically identical to ;spell
    private String featCommandHandler(String searchTerm, final MessageChannel channel, final User author)    //searchTerm is all uppercase
    {
        if(searchTerm.equals("HELP"))
        {
            author.openPrivateChannel().complete().sendMessage("Feat Command - Returns an image of the feat or a list of similar feats.\nFormat: ;feat [string here]\nEx. \";feat Aid\"").queue();
            return null;
        }

        final String searchFeat = searchTerm.replaceAll("[^A-Z]",""); //searchFeat is all caps letters only
        if(searchFeat.length() == 0)
        {   //If the searchTerm is symbols return because it is invalid
            channel.sendMessage("I'm sorry but I'm not a symbologist. How about adding some letters in there?").queue();
            return null;
        }

        /*  Search through feats   */
        final ArrayList<dndFeats> matches = new ArrayList<>();   //This ArrayList stores every feat that has the searchTerm as a substring. Essentially it holds a list of feats that might be the one the user is searching for
        dndFeats exactMatch = null;                                //This dndFeats is null by default but is assigned a dndFeats enum if the searchTerm exactly matches a feat. Essentially if this isn't null an exact match for the search term was found.

        if(dndFeats.isValid(searchFeat))  //Check if there is a valid feat that exactly matches the searchTerm.
        {
            exactMatch = dndFeats.valueOf(searchFeat);
        }
        else
        {
            //Iterate through all feats in dndFeats and add any feat that searchTerm is a substring of
            for(dndFeats searchAgainstFeat : EnumSet.allOf(dndFeats.class))                              //Go through the list of feats
                if (searchAgainstFeat.name().contains(searchFeat))     //If the feat we are currently comparing against contains the term we are searching for
                    matches.add(searchAgainstFeat);
        }

        /*  Handle results  */
        if(exactMatch != null || matches.size() == 1) //If an exact match to searchFeat or only one feat in dndFeats contained searchFeat, then retrieve file and respond to message
        {
            final dndFeats imageName = (exactMatch != null ? exactMatch : matches.remove(0));
            return featResultSender(channel, imageName);
        }
        else if(matches.size() != 0) //Multiple feats were found that contained searchFeat. ex. searchFeat = "FIRE" would return "FIREBOLT", "FIREBALL", etc...
        {
            String response = "Hmm... I found a couple of feats that remind me of that one:\n";

            Collections.sort(matches, new dndFeats.featSorter());  //Sort the list. Enum is ordered by declaration order by default.
            storedUserQueries.put(author, new userQuery(author, new ArrayList<>(matches), userQuery.queryType.FEAT));

            int i = 0;
            while(matches.size() != 0) //Go through all the feats that contained the searchFeat and print them out
            {
                response += String.format("%d. %s\n",i++, matches.remove(0).toString());
            }
            largeMessageSender(response, channel);
            return null;
        }
        else //No feat contained the searchFeat
        {
            channel.sendMessage("I'm sorry, but I couldn't find that feat.").queue();
            return null;
        }
    }

    private String condCommandHandler(String searchTerm, final MessageChannel channel, final User author)    //searchTerm is all uppercase
    {
        if(searchTerm.equals("HELP"))
        {
            author.openPrivateChannel().complete().sendMessage("Cond Command - Returns an image of the cond or a list of similar conds.\nFormat: ;cond [string here]\nEx. \";cond Aid\"").queue();
            return null;
        }

        final String searchCond = searchTerm.replaceAll("[^A-Z]",""); //searchCond is all caps letters only
        if(searchCond.length() == 0)
        {   //If the searchTerm is symbols return because it is invalid
            channel.sendMessage("I'm sorry but I'm not a symbologist. How about adding some letters in there?").queue();
            return null;
        }

        /*  Search through conds   */
        final ArrayList<dndConditions> matches = new ArrayList<>();   //This ArrayList stores every cond that has the searchTerm as a substring. Essentially it holds a list of conds that might be the one the user is searching for
        dndConditions exactMatch = null;                                //This dndConditions is null by default but is assigned a dndConditions enum if the searchTerm exactly matches a cond. Essentially if this isn't null an exact match for the search term was found.

        if(dndConditions.isValid(searchCond))  //Check if there is a valid cond that exactly matches the searchTerm.
        {
            exactMatch = dndConditions.valueOf(searchCond);
        }
        else
        {
            //Iterate through all conds in dndConditions and add any cond that searchTerm is a substring of
            for(dndConditions searchAgainstCond : EnumSet.allOf(dndConditions.class))                              //Go through the list of conds
                if (searchAgainstCond.name().contains(searchCond))     //If the cond we are currently comparing against contains the term we are searching for
                    matches.add(searchAgainstCond);
        }

        /*  Handle results  */
        if(exactMatch != null || matches.size() == 1) //If an exact match to searchCond or only one cond in dndConditions contained searchCond, then retrieve file and respond to message
        {
            final dndConditions imageName = (exactMatch != null ? exactMatch : matches.remove(0));
            return condResultSender(channel, imageName);
        }
        else if(matches.size() != 0) //Multiple conds were found that contained searchCond. ex. searchCond = "FIRE" would return "FIREBOLT", "FIREBALL", etc...
        {
            String response = "Hmm... I found a couple of conds that remind me of that one:\n";

            Collections.sort(matches, new dndConditions.condSorter());  //Sort the list. Enum is ordered by declaration order by default.
            storedUserQueries.put(author, new userQuery(author, new ArrayList<>(matches), userQuery.queryType.FEAT));

            int i = 0;
            while(matches.size() != 0) //Go through all the conds that contained the searchCond and print them out
            {
                response += String.format("%d. %s\n",i++, matches.remove(0).toString());
            }
            largeMessageSender(response, channel);
            return null;
        }
        else //No cond contained the searchCond
        {
            channel.sendMessage("I'm sorry, but I couldn't find that cond.").queue();
            return null;
        }
    }

    //Responds to ;re by sending the image that corresponds to the item at index 'selection' in that user's latest stored query
    private void responseCommandHandler(final User author, String selection, final MessageChannel channel)
    {
        if(!storedUserQueries.containsKey(author))
        {
            channel.sendMessage("I don't have any stored responses for you.").queue();
            return;
        }


        int sel;
        try{
            sel = Integer.parseInt(selection.replaceAll("[^0-9]",""));
        }
        catch(Exception e)
        {
            channel.sendMessage("I'm not entirely sure that is a number.").queue();
            return;
        }

        if(sel < 0 || sel > storedUserQueries.get(author).getResults().size() - 1)
        {
            channel.sendMessage(String.format("Please enter a number between 0 and %d", storedUserQueries.get(author).getResults().size() - 1)).queue();
            return;
        }

        if(storedUserQueries.get(author).getType() == userQuery.queryType.SPELL)
        {
            spellResultSender(channel, (dndSpells) storedUserQueries.get(author).getResults().get(sel));
            storedUserQueries.remove(author);
        }
        else if(storedUserQueries.get(author).getType() == userQuery.queryType.FEAT)
        {
            featResultSender(channel, (dndFeats) storedUserQueries.get(author).getResults().get(sel));
            storedUserQueries.remove(author);
        }
    }

    //;spellList command. Searches through the dndSpells enum and responds with a list of all spells matching the query
    //Format: ;spellList class:[class] level:[level] school:[school]. ex. ";spellList class:Bard level:0 school:evocation"
    //You can include multiple of a single argument (ie "class:Bard class:Wizard") and it will be treated as OR
    private void spellListCommandHandler(String searchTerm, final MessageChannel channel, final User author)
    {
        if(searchTerm.equals("HELP"))
        {
            author.openPrivateChannel().complete().sendMessage("SpellList Command - Searches spells with criteria and returns a list of matching spells.\n" +
                                                                    "Format: ;spellList [series of arguments]. \n" +
                                                                    "Possible arguments:\n" +
                                                                    "`Class:` options - Barbarian, Bard, Cleric, Druid, Fighter, Monk, Paladin, Ranger, Rogue, Sorcerer, Warlock, Wizard. Ex. `Class:Wizard`\n" +
                                                                    "`Level:` options - 0-9 Ex. `Level:3`\n" +
                                                                    "`School:` options - Abjuration, Conjuration, Divination, Enchantment, Evocation, Illusion, Necromancy, Transmutation Ex. `School:Illusion`\n" +
                                                                    "Using multiple of the same type of argument ['class:wizard class:bard'] will retrieve spells that pertain to any of the filters. In the example to the left, it would return all spells that are used by wizards OR bards.\n" +
                                                                    "Using different types of arguments ['class:wizard level:0'] will retrieve spells that pertain to all of those filters. In the example to the left, it would return all spells that are used by wizards AND are level 0.\n" +
                                                                    "Ex. `;spellList class:wizard school:evocation school:abjuration level:0 level:1` would return all spells used by wizards that are from either the evocation or abjuration schools and are level 0 or 1.").queue();
            return;
        }

        final String[] terms = searchTerm.split(" ");
        if(terms.length == 0)
        {   //If ";spellList" is called alone
            channel.sendMessage("Please add some filters to that or try ;spellList help").queue();
            return;
        }

        /*  Parse Command   */
        final ArrayList<dndClasses> classFilter = new ArrayList<>();      //Holds every class to look for
        final ArrayList<Byte> levelFilter = new ArrayList<>();            //Holds every level to look for
        final ArrayList<dndSpellSchool> schoolFilter = new ArrayList<>(); //Holds every school to look for
        for(String arg : terms)
        {//Iterate through every space separated string and parse it
            String[] argParts = arg.split(":");
            if(argParts.length != 2)
            {
                channel.sendMessage("It looks like one of your terms doesn't have a \':\' or has too many").queue();
                return;
            }

            if (argParts[0].startsWith("C"))    //Class filter
            {   //Parse class: argument
                String argClass = argParts[1];

                final dndClasses filterClass = dndClasses.findClosestClass(argClass);
                if (filterClass != null)
                {   //Class: represents a valid class name, add it to filter list
                    classFilter.add(filterClass);
                }
                else
                {   //Invalid class name, exit
                    channel.sendMessage(String.format("Hmm... I've never heard of that class before. What is a `%s`?", argClass)).queue();
                    return;
                }
            }
            else if (argParts[0].startsWith("L"))   //Level filter
            {   //Parse level: argument
                byte argLevel = -1;
                try
                {
                    argLevel = (argParts[1].equals("CANTRIP") ? 0 : Byte.parseByte(argParts[1]));
                    if(argLevel < 0 || 9 < argLevel)
                        throw new NumberFormatException();
                }
                catch(NumberFormatException e)
                {
                    channel.sendMessage(String.format("I've never heard of a spell level being `%s` before. Usually they are between 0 and 9.", argParts[1])).queue();
                    return;
                }
                //Not ideal, but the above try-catch ensures argLevel is a) numerical b) within byte range and c) within our spellLevel range.
                //a) and c) were fairly easily solved, but I couldn't solve b) without try-catch so I use it to test all three conditions.
                levelFilter.add(argLevel);
            }
            else if(argParts[0].startsWith("S"))    //School filter
            {   //Parse level: school
                final String argSchool = argParts[1];

                final dndSpellSchool filterSchool = dndSpellSchool.findClosestSchool(argSchool);
                if(filterSchool != null)
                {   //If school: is valid, add it to the filter
                    schoolFilter.add(filterSchool);
                }
                else
                {   //Invalid school name
                    channel.sendMessage(String.format("I've never heard of the `%s` school of magic before, where are they from?", argSchool)).queue();
                    return;
                }
            }
            else
            {   //Argument is not class: c: level: lvl: l: school: or s:
                channel.sendMessage(String.format("I can only search by class, level, and school, not by `%s`. Try \";spellList help\"", arg)).queue();
                return;
            }
        }

        /*  Search through spell enum for spell that matches filters   */
        final ArrayDeque<String> spellList = new ArrayDeque<>();
        for(dndSpells spell : EnumSet.allOf(dndSpells.class))
        {
            boolean classPass = false, levelPass = false, schoolPass = false;   //Default to fail

            if(classFilter.size() == 0)
                classPass = true;   //If no class filter is specified, then set to true. We don't need to search
            else
            {   //Go through the classes 'spell' is used by, and if any class on the filter matches then set to true
                Set<dndClasses> spellClasses = spell.getSpellClasses();
                for(dndClasses cl : spellClasses)
                {
                    if(classFilter.contains(cl))
                    {
                        classPass = true;
                        break;
                    }
                }
            }

            if(levelFilter.size() == 0)
                levelPass = true;   //If no level filter is specified, then set to true. We don't need to search
            else
            {   //If the level of 'spell' is the same as any on the levelFilter list then set to true
                byte spellLevel = spell.getLevel();
                if(levelFilter.contains(spellLevel))
                    levelPass = true;
            }

            if(schoolFilter.size() == 0)    //If no school filter is specified, then set to true. We don't need to search
                schoolPass = true;
            else
            {   //If the school of 'spell' is the same as any on the schoolFilter list then set to true
                dndSpellSchool spellSchool = spell.getSchool();
                if(schoolFilter.contains(spellSchool))
                    schoolPass = true;
            }

            if(classPass && levelPass && schoolPass)    //If class, level, and school are true then add to list.
                spellList.addLast(spell.toString());
        }

        //Results
        if(spellList.size() == 0)
        {   //Zero spells matched the filters
            channel.sendMessage("I didn't find any spell that matched those characteristics").queue();
            return;
        }
        else
        {   //Output response

            //List filters used to verify the interpreted query was correct
            String response = "The spells that match ";
            for(dndClasses cl : classFilter)
                response += String.format("`CLASS:%s` ", cl.name());
            for(dndSpellSchool sc : schoolFilter)
                response += String.format("`SCHOOL:%s` ", sc.name());
            for(byte lvl : levelFilter)
                response += String.format("`LEVEL:%d` ", lvl);
            response += "are:\n";
            //List all the spells that matched the filters
            while(spellList.size() != 0) //Go through all the spells that contained the searchTerm and print them out
                response += spellList.removeFirst().toString() + '\n';
            largeMessageSender(response, channel);
            return;
        }
    }

    //Used to send information about a dnd class
    private void classCommandHandler(String searchTerm, final MessageChannel channel, final User author)
    {
        if(searchTerm.equals("HELP"))
        {
            author.openPrivateChannel().complete().sendMessage("Class Command - Returns an image of class info.\n" +
                                                                    "Format: ;spell [class name] [optional specifier]\n" +
                                                                    "Arguments: \n" +
                                                                    "Class name is class name (Bard, Cleric, etc). Spelling matters but not capitalization.\n" +
                                                                    "Class information is divided into three parts: the level up table, class features, and 'paths/archetypes/way/tradition/etc' which is the class branch options.\n" +
                                                                    "Optional specifier can be `table`, `class`, `path` and will only send the relevant part of the class info. Without specifiers this command will send all three.\n" +
                                                                    "Fair Warning: Some of the images are large and will take a while to send.").queue();
            return;
        }

        final String[] parsedMessage = searchTerm.split(" ");
        if(parsedMessage.length == 0 || parsedMessage.length > 2)
        {   //User input checking
            channel.sendMessage("Too many or too few arguments. Use 1 or 2.").queue();
            return;
        }

        if(!dndClasses.isValid(parsedMessage[0]))
        {   //If the class isn't a valid class then error message and exit
            channel.sendMessage("Invalid class name").queue();
            return;
        }

        final String className = parsedMessage[0];
        if(parsedMessage.length == 1)
        {   //If only the class name is used, send all images

            imageSender(Paths.get(Main.executionDirLocation, "IMAGES", "CLASSES", className, "Table.png").toString(), "", channel);
            imageSender(Paths.get(Main.executionDirLocation, "IMAGES", "CLASSES", className, "Class.png").toString(), "", channel);
            imageSender(Paths.get(Main.executionDirLocation, "IMAGES", "CLASSES", className, "Paths.png").toString(), "", channel);
            return;
        }
        else
        {   //If a specifier is used, check against a series of possible inputs to determine what to do
            final String specifier = parsedMessage[1];
            if(("TABLESLEVELUP").contains(specifier))
                imageSender(Paths.get(Main.executionDirLocation, "IMAGES", "CLASSES", className, "Table.png").toString(), "", channel);
            else if(("CLASSESFEATURESFEATS").contains(specifier))
                imageSender(Paths.get(Main.executionDirLocation, "IMAGES", "CLASSES", className, "Class.png").toString(), "", channel);
            else if(("PATHSCOLLEGESDOMAINSCIRCLESARCHETYPESWAYSTRADITIONSOATHSORIGINSPATRONSSCHOOLS").contains(specifier))
                imageSender(Paths.get(Main.executionDirLocation, "IMAGES", "CLASSES", className, "Paths.png").toString(), "", channel);
            else
            {   //Specifier is not a valid input
                channel.sendMessage("I don't get that").queue();
            }
        }
    }

    //Handles commands that only the admin should have access too
    private void adminCommandHandler(String term, final MessageChannel channel, final User author)
    {
        if(author.getIdLong() != PersonalData.ADMIN_ID) { //Only allow ADMIN to use these commands
            channel.sendMessage("Unrecognized command.").queue();
            return;
        }

        final String[] parsedMessage = separateFirstTerm(term);
        switch(parsedMessage[0].toUpperCase())
        {
            case "SHUTDOWN":    //Stop execution of bot
                channel.sendMessage("Shutting down...").queue();
                System.out.println("[SHUTDOWN COMMAND RECEIVED]");
                try{ TimeUnit.SECONDS.sleep(1);}    //Delay is necessary to properly display shutdown message
                catch(Exception e){}
                Main.bot.getPresence().setStatus(OnlineStatus.OFFLINE);
                Main.bot.shutdown();    //Shutdown JDA
                System.exit(0); //Exit execution
                break;

            case "UPTIME":  //Print out uptime of the bot formatted legibly
                long diff = System.currentTimeMillis() - Main.startEpoch;
                channel.sendMessage("Start Time: " + new Date(Main.startEpoch) + "\nTime Elapsed: " + String.format("%d days, %d hrs, %d mins, %d secs, %d ms", TimeUnit.MILLISECONDS.toDays(diff), TimeUnit.MILLISECONDS.toHours(diff) % 24, TimeUnit.MILLISECONDS.toMinutes(diff) % 60, TimeUnit.MILLISECONDS.toSeconds(diff) % 60, diff % 1000)).queue();
                break;

            case "GUILD":   //Get a list of guilds the bot is in
                guildCommandHandler(parsedMessage[1].toUpperCase(), channel);
                break;

            case "USAGE":   //Get readouts of how much the bot has been used
                usageCommandHandler(channel);
                break;

            case "VERSION":
                channel.sendMessage("https://github.com/kkwik/Discord-DND-Bot/commit/80e48f548610eccdccaede0b59711f14a5c25e5d").queue();
                break;

            case "TEXT":
                if(parsedMessage[1].length() != 0)
                    Main.bot.getPresence().setActivity(Activity.listening(parsedMessage[1]));
                else
                    Main.bot.getPresence().setActivity(null);
                break;

            default:
                break;
        }
    }

    //Admin command used to printout interesting bot usage statistics
    private void usageCommandHandler(final MessageChannel channel) {
        long currTime = System.currentTimeMillis();
        String response = String.format("Total calls: %d\n", Main.usageStat);               //Print out amount of times the bot was called since uptime
        response += String.format("Calls in last hour: %d\n\n", Main.usageStatQueue.size());  //Print out amount of times the bot was called in the past hour

        final List<Guild> guildList = Main.bot.getGuilds();
        final ArrayList<Long> ids = new ArrayList<>();
        for(int i = 0; i < guildList.size(); i++)
            ids.add(guildList.get(i).getIdLong());
        final ArrayList<Long> usage = new ArrayList<Long>();    //Tracks how many times the bot was called from each server
        for(int i = 0; i < guildList.size(); i++)
            usage.add(0L);
        final ArrayList<Long> lastCall = new ArrayList<Long>(guildList.size()); //Tracks the last time the bot was called from each server
        for(int i = 0; i < guildList.size(); i++)
            lastCall.add(0L);
        for (usageStat stat : Main.usageStatQueue) //Go through the usageStatQueue and tally how many messages came from each server
        {
            if(stat.isPM() && !ids.contains(stat.getId()))
            {
                ids.add(stat.getId());
                usage.add(0L);
                lastCall.add(0L);
            }
            int pos = ids.indexOf(stat.getId());
            usage.set(pos, usage.get(pos)+1);
            lastCall.set(pos, stat.getTime());
        }

        int i;
        response += "Guilds:\n";
        for (i = 0; i < guildList.size(); i++)   //Print out the calls per server
        {
            long diff = currTime - (lastCall.get(i) == 0 ? System.currentTimeMillis() : lastCall.get(i));
            response += String.format("\t`%s`\n" +
                                        "\tCalls in past hour: %d\n" +
                                        "\tLast one was %d mins, %d secs, %d ms ago\n", Main.bot.getGuildById(ids.get(i)).getName(), usage.get(i), TimeUnit.MILLISECONDS.toMinutes(diff) % 60, TimeUnit.MILLISECONDS.toSeconds(diff) % 60, diff % 1000);
        }
        response += "Private Messages:\n";
        for( ; i < ids.size(); i++)
        {
            long diff = currTime - (lastCall.get(i) == 0 ? System.currentTimeMillis() : lastCall.get(i));
            response += String.format("\t`%s`\n" +
                    "\tCalls in past hour: %d\n" +
                    "\tLast one was %d mins, %d secs, %d ms ago\n", Main.bot.retrieveUserById(ids.get(i)).complete().getAsTag(), usage.get(i), TimeUnit.MILLISECONDS.toMinutes(diff) % 60, TimeUnit.MILLISECONDS.toSeconds(diff) % 60, diff % 1000);
        }
        largeMessageSender(response, channel);  //Send message
    }

    //Increments usageStat which represents total calls, adds a usageStat to the queue, and calls updateUsageStats()
    private void addAndUpdateUsageStats(final MessageEvent messageEvent)
    {
        Main.usageStat++;
        boolean pm = messageEvent.getType() == MessageEvent.eventType.PRIVATE;
        Main.usageStatQueue.addLast(new usageStat(pm ? messageEvent.getAuthor().getIdLong(): messageEvent.getGuildId(), pm));
        updateUsageStats();
    }

    //Prunes usageStatQueue of all entries older than an hour
    private void updateUsageStats()
    {
        final long hrPast = System.currentTimeMillis() - 3600000;
        while(Main.usageStatQueue.getFirst().getTime() < hrPast)
            Main.usageStatQueue.removeFirst();
    }

    //Admin command that handles guild related stuff
    private void guildCommandHandler(final String term, final MessageChannel channel)
    {
        final String[] parsedMessage = separateFirstTerm(term);
        switch(parsedMessage[0])
        {
            case "LIST":    //Prints out a list of guilds the bot is in
                List<Guild> guildList = Main.bot.getGuilds();
                String message = "";
                for(Guild serv : guildList)
                    message += "Guild Name: " + serv.getName() + '\n' + "Guild ID: " + serv.getIdLong() + "\n\n";
                largeMessageSender(message, channel);
                break;
        }
    }

    //Report errors to administrator
    private void reportError(final MessageEvent messageEvent, final String errorMsg)
    {

        String errorReport = String.format("Error Report: \n" +
                                            "UserName: %25s | UserID: %25d\n" +
                                            "Message Text: ```%s```\n" +
                                            "Error Message: ```%s```", messageEvent.getAuthor().getName(), messageEvent.getAuthor().getIdLong(), messageEvent.getMessage(), errorMsg);
        Main.bot.getUserById(PersonalData.ADMIN_ID).openPrivateChannel().complete().sendMessage(errorReport).queue();
    }


    //Turns "spell Hello World" into {"spell", "Hello World"} or "help" into {"help", ""}
    private String[] separateFirstTerm(final String term)
    {
        if(term.contains(" ")) {
            int spaceIndex = term.indexOf(' ');
            return new String[]{term.substring(0, spaceIndex), term.substring(spaceIndex+1, term.length())};
        }
        return new String[]{term, ""};
    }

    //used to send text messages that might be very large. Breaks the message down into smaller chunks
    private void largeMessageSender(final String inputMessage, final MessageChannel channel)
    {
        String message = inputMessage;
        while(message.length() > 1999)
        {
            int messageEndPoint = message.substring(0, 1999).lastIndexOf('\n');
            channel.sendMessage(message.substring(0, messageEndPoint)).queue();
            message = message.substring(messageEndPoint);
        }
        if(message.length() > 0)
            channel.sendMessage(message).queue();
    }

    private String spellResultSender(final MessageChannel channel, dndSpells spell)
    {
        final String classesUsedBy = spell.getSpellClasses().toString();
        final String formattedClassesUsedBy = classesUsedBy.substring(1, classesUsedBy.length() - 1).toLowerCase();
        String returnVal = imageSender(Paths.get(Main.executionDirLocation,"IMAGES", "SPELLS", spell.name() + ".PNG").toString(), String.format("Used by %s", formattedClassesUsedBy), channel);

        if(returnVal == null)
            return null;
        else    //Error occured, append
        {
            return returnVal.concat(String.format("\nExpected file path: %s", Paths.get(Main.executionDirLocation,"IMAGES", "SPELLS", spell.name() + ".PNG").toString()));
        }
    }

    private String featResultSender(final MessageChannel channel, dndFeats feat)
    {
        String returnVal = imageSender(Paths.get(Main.executionDirLocation,"IMAGES", "FEATS", feat.name() + ".PNG").toString(), null, channel);

        if(returnVal == null)
            return null;
        else    //Error occured, append
        {
            return returnVal.concat(String.format("\nExpected file path: %s", Paths.get(Main.executionDirLocation,"IMAGES", "FEATS", feat.name() + ".PNG").toString()));
        }
    }

    private String condResultSender(final MessageChannel channel, dndConditions cond)
    {
        String returnVal = imageSender(Paths.get(Main.executionDirLocation,"IMAGES", "CONDS", cond.name() + ".PNG").toString(), null, channel);

        if(returnVal == null)
            return null;
        else    //Error occured, append
        {
            return returnVal.concat(String.format("\nExpected file path: %s", Paths.get(Main.executionDirLocation,"IMAGES", "CONDS", cond.name() + ".PNG").toString()));
        }
    }

    //Generic image sender that checks for valid file and sends image to channel
    private String imageSender(final String path, final String optionalMessage, final MessageChannel channel)
    {
        File imageFile = new File(path);    //Used for IDE testing
        if(imageFile.exists()) {
            channel.sendFile(imageFile, "image.png").embed(new EmbedBuilder().setImage("attachment://image.png").setDescription(optionalMessage).build()).queue();
        }
        else {
            channel.sendMessage("Curious... I know of that file but cannot find it in my library!\naka File not Found").queue();
            return "File not found.";
        }

        return null;
    }

}
