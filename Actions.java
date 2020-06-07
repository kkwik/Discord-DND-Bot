import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Actions extends ListenerAdapter {

    @Override   //This method is triggered everytime a message is sent in the discord server
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        if(event.getAuthor().isBot() || !Main.guildWhitelist.contains(event.getChannel().getGuild().getIdLong()))   //If the message sent is from a bot, then ignore it
            return;
        long start = System.currentTimeMillis();
        topLevelHandler(new MessageEvent(event));
        System.out.println(System.currentTimeMillis()-start);
    }

    @Override   //This method is triggered by private messages to the bot
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event)
    {
        if(event.getAuthor().isBot())   //If the message sent is from a bot, then ignore it
            return;
        topLevelHandler(new MessageEvent(event));
    }

    //This method separates the first string separated by " " and uses a switch on that term to determine what to do
    private void topLevelHandler(MessageEvent messageEvent)
    {
        String message = messageEvent.getMessage().toUpperCase();
        if(message.length() < 2 || message.charAt(0) != ';')
            return;

        String[] parsedMessage = separateFirstTerm(message.substring(1));
        switch(parsedMessage[0])
        {
            case "SPELL":
                spellCommandHandler(parsedMessage[1], messageEvent.getChannel());
                break;
            case "SPELLLIST":
                spellListCommandHandler(parsedMessage[1], messageEvent.getChannel());
                break;
            case "CLASS":
                classCommandHandler(parsedMessage[1], messageEvent.getChannel());
                break;
            case "BOT":
                adminCommandHandler(parsedMessage[1], messageEvent.getAuthor(), messageEvent.getChannel());
                break;
            case "HELP":
                helpCommandHandler(parsedMessage[1], messageEvent.getAuthor());
                break;
            default:
                messageEvent.getChannel().sendMessage("Unrecognized command.").queue();
                break;
        }
    }

    //;spell command. Returns an image of the spell or a list of similar spells. Note: images of the PHB are not included in this repository
    //Format: ;spell [string here]. ex. ";spell fire bolt"
    private void spellCommandHandler(String searchTerm, MessageChannel channel)
    {
        if(searchTerm.equals("HELP") || searchTerm.equals("H"))
        {
            channel.sendMessage(Character.toString((char)32)).embed(new EmbedBuilder().setDescription("Spell Command - Returns an image of the spell or a list of similar spells.\nFormat: ;spell [string here]\nEx. \";spell Aid\"").build()).queue();
            return;
        }

        String searchSpell = searchTerm.replaceAll("[^A-Z]",""); //searchSpell is all caps letters only
        if(searchSpell.length() == 0)
        {   //If the searchTerm is symbols return because it is invalid
            channel.sendMessage("I'm sorry but I'm not a symbologist. How about adding some letters in there?").queue();
            return;
        }

        /*  Search through spells   */
        ArrayDeque<dndSpells> matches = new ArrayDeque<>();
        dndSpells exactMatch = null;
        if(dndSpells.isValid(searchSpell))
        {//The searchSpell is the exact name of a spell
            exactMatch = dndSpells.valueOf(searchSpell);
        }
        else
        {//Iterate through all spells in dndSpells create a list of spells who contain a substring of searchSpell
            for(dndSpells searchAgainstSpell : EnumSet.allOf(dndSpells.class))                              //Go through the list of spells in reverse order.
                if (searchAgainstSpell.name().contains(searchSpell))     //If the spell we are currently comparing against contains the term we are searching for
                    matches.add(searchAgainstSpell);
        }

        /*  Handle results  */
        if(exactMatch != null || matches.size() == 1)
        {//If and exact match to searchSpell or only one spell in dndSpells contained searchSpell, then retrieve file and respond to message
            dndSpells imageName = (exactMatch != null ? exactMatch : matches.pop());

            imageSender("PHB\\Spells\\" + imageName + ".png", "Ah... here it is:", channel);
            return;
        }
        else if(matches.size() != 0)
        {//Multiple spells were found that contained searchSpell. ex. searchSpell = "FIRE" would return "FIREBOLT", "FIREBALL", etc...
            String response = "Hmm... I found a couple of spells that remind me of that one:\n";
            while(matches.size() != 0) //Go through all the spells that contained the searchSpell and print them out
                response += matches.removeFirst().toString() + '\n';
            largeMessageSender(response, channel);
            return;
        }
        else
        {   //No spell contained the searchSpell
            channel.sendMessage("I'm sorry, but I couldn't find that spell.").queue();
            return;
        }
    }

    //;spellList command. Searches through the dndSpells enum and responds with a list of all spells matching the query
    //Format: ;spellList class:[class] level:[level] school:[school]. ex. ";spellList class:Bard level:0 school:evocation"
    //You can include multiple of a single argument (ie "class:Bard class:Wizard") and it will be treated as OR
    private void spellListCommandHandler(String searchTerm, MessageChannel channel)
    {
        if(searchTerm.equals("HELP") || searchTerm.equals("H"))
        {
            channel.sendMessage(Character.toString((char)32)).embed(new EmbedBuilder().setDescription("SpellList Command - Searches spells with criteria and returns a list of matching spells.\nFormat: ;spellList [series of arguments]. \nPotential arguments are Class:, Level:, and School:\nEx. \";spellList class:Bard class:Wizard level:0 school:evocation\"\nNotably using multiple arguments of the same type (class:wizard class:bard) will return a list of spells which have any of the characteristics.\nUsing different types of arguments (class:wizard level:0) will return a list of spells that fit both of those characteristics.").build()).queue();
            return;
        }

        String[] terms = searchTerm.split(" ");
        if(terms.length == 0)
        {   //If ";spellList" is called alone
            channel.sendMessage("Please add some filters to that").queue();
            return;
        }

        /*  Parse Command   */
        ArrayList<dndClasses> classFilter = new ArrayList<>();      //Holds every class to look for
        ArrayList<Byte> levelFilter = new ArrayList<>();            //Holds every level to look for
        ArrayList<dndSpellSchool> schoolFilter = new ArrayList<>(); //Holds every school to look for
        for(String arg : terms)
        {//Iterate through every space separated string and parse it
            if (arg.startsWith("CLASS:") || arg.startsWith("C:"))
            {   //Parse class: argument
                String argClass = arg.split(":")[1];
                if (dndClasses.isValid(argClass))
                {   //Class: represents a valid class name, add it to filter list
                    classFilter.add(dndClasses.valueOf(argClass));
                }
                else
                {   //Invalid class name, exit
                    channel.sendMessage(String.format("Hmm... I've never heard of that class before. What is a `%s`?", argClass)).queue();
                    return;
                }
            }
            else if (arg.startsWith("LEVEL:") || arg.startsWith("LVL:") || arg.startsWith("L:"))
            {   //Parse level: argument
                byte argLevel = -1;
                String sArgLevel = arg.split(":")[1];
                try
                {
                    argLevel = Byte.parseByte(sArgLevel);
                    if(argLevel < 0 || 9 < argLevel)
                        throw new NumberFormatException();
                }
                catch(NumberFormatException e)
                {
                    channel.sendMessage(String.format("I've never heard of a spell level being `%s` before. Usually they are between 0 and 9.", sArgLevel)).queue();
                    return;
                }
                //Not ideal, but the above try-catch ensures argLevel is a) numerical b) within byte range and c) within our spellLevel range.
                //a) and c) were fairly easily solved, but I couldn't solve b) without try-catch so I use it to test all three conditions.
                levelFilter.add(argLevel);
            }
            else if(arg.startsWith("SCHOOL:") || arg.startsWith("S:"))
            {   //Parse level: school
                String argSchool = arg.split(":")[1];
                if(dndSpellSchool.isValid(argSchool))
                {   //If school: is valid, add it to the filter
                    schoolFilter.add(dndSpellSchool.valueOf(argSchool));
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
        ArrayDeque<String> spellList = new ArrayDeque<>();
        for(dndSpells spell : EnumSet.allOf(dndSpells.class))
        {
            boolean classPass = false, levelPass = false, schoolPass = false;   //Default to fail

            if(classFilter.size() == 0)
                classPass = true;   //If no class filter is specified, then set to true. We don't need to search
            else
            {   //Go through the classes 'spell' is used by, and if any class on the filter matches then set to true
                dndClasses[] spellClasses = spell.getSpellClasses();
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
        {   //List all the spells that matched the filters
            String response = "Hmm... These spells match your request:\n";
            while(spellList.size() != 0) //Go through all the spells that contained the searchTerm and print them out
                response += spellList.removeFirst().toString() + '\n';
            largeMessageSender(response, channel);
            return;
        }
    }

    private void classCommandHandler(String searchTerm, MessageChannel channel)
    {
        if(searchTerm.equals("HELP") || searchTerm.equals("H"))
        {
            channel.sendMessage(Character.toString((char)32)).embed(new EmbedBuilder().setDescription("Class Command - Returns an image of class info.\nFormat: ;spell [class name]\nYou can specify table, class, path.\nEx. \";class bard\"").build()).queue();
            return;
        }
        String[] parsedMessage = searchTerm.split(" ");
        if(parsedMessage.length == 0 || parsedMessage.length > 2)
        {
            channel.sendMessage("Too many or too few arguments. Use 1 or 2.").queue();
            return;
        }

        if(!dndClasses.isValid(parsedMessage[0]))
        {
            channel.sendMessage("Invalid class name").queue();
            return;
        }

        String className = parsedMessage[0];
        if(parsedMessage.length == 1)
        {
            imageSender("PHB\\Classes\\" + parsedMessage[0] + "\\" + "Table.png", "", channel);
            imageSender("PHB\\Classes\\" + parsedMessage[0] + "\\" + "Class.png", "", channel);
            imageSender("PHB\\Classes\\" + parsedMessage[0] + "\\" + "Paths.png", "", channel);
            return;
            //File imageFile = new File("PHB\\Classes\\" + parsedMessage[0] + "\\" + "Table.png");    //Used for IDE testing
            //File imageFile = new File(String.format("%s%sImages%sSpells%s%s.png", Main.executionLocation, Main.FILE_SEPARATOR, Main.FILE_SEPARATOR, Main.FILE_SEPARATOR, imageName)); //Used for when in Jar. Put PHB in same dir as .jar
        }
        else
        {
            String specifier = parsedMessage[1];
            if(("TABLESLEVELUP").contains(specifier))
                imageSender("PHB\\Classes\\" + parsedMessage[0] + "\\" + "Table.png", "", channel);
            else if(("CLASSESFEATURESFEATS").contains(specifier))
                imageSender("PHB\\Classes\\" + parsedMessage[0] + "\\" + "Class.png", "", channel);
            else if(("PATHSCOLLEGESDOMAINSCIRCLESARCHETYPESWAYSTRADITIONSOATHSORIGINSPATRONSSCHOOLS").contains(specifier))
                imageSender("PHB\\Classes\\" + parsedMessage[0] + "\\" + "Paths.png", "", channel);
            else
            {
                channel.sendMessage("I don't get that").queue();
            }
        }
    }

    private void adminCommandHandler(String term, User author, MessageChannel channel)
    {
        if(author.getIdLong() != PersonalData.ADMIN_ID) //Only allow ADMIN to use these commands
            return;

        String[] parsedMessage = separateFirstTerm(term);
        switch(parsedMessage[0])
        {
            case "SHUTDOWN":    //Stop execution of bot
                channel.sendMessage("Shutting down...").queue();
                Main.bot.shutdown();    //Shutdown JDA
                System.exit(0); //Exit execution
                break;

            case "UPTIME":
                long diff = System.currentTimeMillis() - Main.startEpoch;
                channel.sendMessage("Start Time: " + new Date(Main.startEpoch) + "\nTime Elapsed: " + String.format("%d days, %d hrs, %d mins, %d secs, %d ms", TimeUnit.MILLISECONDS.toDays(diff), TimeUnit.MILLISECONDS.toHours(diff) % 24, TimeUnit.MILLISECONDS.toMinutes(diff) % 60, TimeUnit.MILLISECONDS.toSeconds(diff) % 60, diff % 1000)).queue();
                break;

            case "GUILD":
                guildCommandHandler(parsedMessage[1], channel);
                break;

            default:
                break;
        }
    }

    private void guildCommandHandler(String term, MessageChannel channel)
    {
        String[] parsedMessage = separateFirstTerm(term);
        switch(parsedMessage[0])
        {
            case "LIST":
                List<Guild> guildList = Main.bot.getGuilds();
                String message = "";
                for(Guild serv : guildList)
                    message += "Guild Name: " + serv.getName() + '\n' + "Guild ID: " + serv.getIdLong() + "\n\n";
                largeMessageSender(message, channel);
                break;
        }
    }

    private void helpCommandHandler(String searchTerm, User author)
    {
        if(searchTerm.equals("SPELL"))
        {
            author.openPrivateChannel().complete().sendMessage("Used to get information about a spell. You can also search for a fragment of the spell name\nSyntax: ;spell [spell name].").queue();
        }
        else if(searchTerm.equals("BOT"))
        {
            return;
        }
    }

    //Turns "spell Hello World" into {"spell", "Hello World"} or "help" into {"help", ""}
    private String[] separateFirstTerm(String term)
    {
        if(term.contains(" ")) {
            int spaceIndex = term.indexOf(' ');
            return new String[]{term.substring(0, spaceIndex), term.substring(spaceIndex+1, term.length())};
        }
        return new String[]{term, ""};
    }

    //used to send text messages that might be very large. Breaks the message down into smaller chunks
    private void largeMessageSender(String message, MessageChannel channel)
    {
        while(message.length() > 1999)
        {
            int messageEndPoint = message.substring(0, 1999).lastIndexOf('\n');
            channel.sendMessage(message.substring(0, messageEndPoint)).queue();
            message = message.substring(messageEndPoint);
        }
        if(message.length() > 0)
            channel.sendMessage(message).queue();
    }

    private void imageSender(String path, String optionalMessage, MessageChannel channel)
    {
        File imageFile = new File(path);    //Used for IDE testing
        //File imageFile = new File(String.format("%s%sImages%sSpells%s%s.png", Main.executionLocation, Main.FILE_SEPARATOR, Main.FILE_SEPARATOR, Main.FILE_SEPARATOR, imageName)); //Used for when in Jar. Put PHB in same dir as .jar
        if(imageFile.exists())
            channel.sendFile(imageFile, "image.png").embed(new EmbedBuilder().setImage("attachment://image.png").setDescription(optionalMessage).build()).queue();
        else
            channel.sendMessage("Curious... I know of that file but cannot find it in my library!\naka File not Found").queue();
    }

}
