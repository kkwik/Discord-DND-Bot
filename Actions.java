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
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(!event.getAuthor().isBot() && Main.guildWhitelist.contains(event.getChannel().getGuild().getIdLong()))   //If the message sent is from a bot, then ignore it
            topLevelHandler(new MessageEvent(event));
    }

    @Override   //This method is triggered by private messages to the bot
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        if(!event.getAuthor().isBot())   //If the message sent is from a bot, then ignore it
            topLevelHandler(new MessageEvent(event));
    }

    private void topLevelHandler(MessageEvent messageEvent) {
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
                messageEvent.getChannel().sendMessage("Not implemented.").queue();
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

    private void spellCommandHandler(String searchTerm, MessageChannel channel) {
        String searchSpell = searchTerm.replaceAll("[^A-Z]","");
        if(searchSpell.length() == 0) {   //If the searchTerm is symbols return because it is invalid
            channel.sendMessage("I'm sorry but I'm not a symbologist. How about adding some letters in there?").queue();
            return;
        }

        ArrayDeque<dndSpells> matches = new ArrayDeque<>();
        dndSpells exactMatch = null;

        if(dndSpells.isValid(searchSpell))
        {
            exactMatch = dndSpells.valueOf(searchSpell);
        }
        else
        {
            for(dndSpells sp : EnumSet.allOf(dndSpells.class))                              //Go through the list of spells in reverse order.
                if (sp.name().contains(searchSpell))     //If the spell we are currently comparing against contains the term we are searching for
                    matches.addLast(sp);
        }

        //Results
        if(exactMatch != null || matches.size() == 1)
        {
            dndSpells imageName = (exactMatch != null ? exactMatch : matches.pop());
            //File imageFile = new File(new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile() + Main.FILE_SEPARATOR +"Images" + Main.FILE_SEPARATOR + imageName + ".png");
            File imageFile = new File("Images\\" + imageName + ".png");

            if(imageFile.exists()) //If a file by that name exists in the working directory then send it
                channel.sendFile(imageFile, "image.png").embed(new EmbedBuilder().setImage("attachment://image.png").setDescription("Ah... here it is:").build()).queue();
            else    //Print that something has gone wrong
                channel.sendMessage("Curious... I know of that file but cannot find it!\n[FILE IMAGE NOT FOUND]").queue();
            return;
        }
        else if(matches.size() != 0)    //If similar spells were found
        {
            String response = "Hmm... I found a couple of spells that remind me of that one:\n";
            while(matches.size() != 0) //Go through all the spells that contained the searchTerm and print them out
                response.concat(matches.removeFirst().toString() + '\n');
            largeMessageSender(response, channel);
            return;
        }
        else        //No spell contained the searchTerm
        {
            channel.sendMessage("I'm sorry, but I couldn't find that spell.").queue();
            return;
        }
    }

    private void spellListCommandHandler(String searchTerm, MessageChannel channel) {
        String[] terms = searchTerm.split(" ");
        if(terms.length == 0) {
            channel.sendMessage("ERROR MESSAGE").queue();
            return;
        }

        //Parse argument
        ArrayList<dndClasses> classFilter = new ArrayList<>();
        ArrayList<Byte> levelFilter = new ArrayList<>();
        ArrayList<dndSpellSchool> schoolFilter = new ArrayList<>();
        for(String arg : terms)
        {
            if (arg.startsWith("CLASS:") || arg.startsWith("C:"))
            {
                String argClass = arg.split(":")[1];
                if (dndClasses.isValid(argClass))
                {
                    classFilter.add(dndClasses.valueOf(argClass));
                }
                else
                {
                    channel.sendMessage("Invalid Class Name: " + argClass).queue();
                    return;
                }
            }
            else if (arg.startsWith("LEVEL:") || arg.startsWith("LVL:") || arg.startsWith("L:"))
            {

                char argLevel = arg.split(":")[1].charAt(0);
                if(48 <= argLevel && argLevel <= 57)
                {
                    levelFilter.add(Byte.parseByte(Character.toString(argLevel)));
                }
                else
                {
                    channel.sendMessage("Invalid Spell Level: " + argLevel).queue();
                    return;
                }
            }
            else if(arg.startsWith("SCHOOL:") || arg.startsWith("S:"))
            {
                String argSchool = arg.split(":")[1];
                if(dndSpellSchool.isValid(argSchool))
                {
                    schoolFilter.add(dndSpellSchool.valueOf(argSchool));
                }
                else
                {
                    channel.sendMessage("Invalid School Name: " + argSchool).queue();
                    return;
                }
            }
            else
            {
                channel.sendMessage("Invalid Argument: " + arg).queue();
                return;
            }
        }

        //Search spells
        ArrayDeque<String> spellList = new ArrayDeque<>();
        for(dndSpells spell : EnumSet.allOf(dndSpells.class))
        {
                boolean classPass = false, levelPass = false, schoolPass = false;
                //Testing class filter
                if(classFilter.size() == 0)//No filter specified
                    classPass = true;
                else
                {
                    dndClasses[] spellClasses = spell.getSpellClasses();
                    for(dndClasses cl : spellClasses)
                    {
                        if(classFilter.contains(cl))
                            classPass = true;
                    }
                }

            if(levelFilter.size() == 0)
                levelPass = true;
            else
            {
                byte spellLevel = spell.getLevel();
                if(levelFilter.contains(spellLevel))
                    levelPass = true;
            }

            if(schoolFilter.size() == 0)//No filter specified
                schoolPass = true;
            else
            {
                dndSpellSchool spellSchool = spell.getSchool();
                if(schoolFilter.contains(spellSchool))
                    schoolPass = true;
            }

            if(classPass && levelPass && schoolPass)
                spellList.addLast(spell.toString());
        }

        //Results
        if(spellList.size() == 0)
        {
            channel.sendMessage("I didn't find any spell that matched those characteristics").queue();
            return;
        }
        else
        {
            String response = "Hmm... These spells match your request:\n";
            while(spellList.size() != 0) //Go through all the spells that contained the searchTerm and print them out
                response += spellList.removeFirst().toString() + '\n';
            largeMessageSender(response, channel);
            return;
        }
    }

    private void classCommandHandler(String searchTerm, MessageChannel channel){

    }

    private void adminCommandHandler(String term, User author, MessageChannel channel) {
        if(author.getIdLong() != PersonalData.ADMIN_ID)
            return;

        String[] parsedMessage = separateFirstTerm(term);
        switch(parsedMessage[0])
        {
            case "SHUTDOWN":
                channel.sendMessage("Shutting down...").queue();
                try{ TimeUnit.SECONDS.sleep(1);}
                catch(Exception e){}
                System.exit(0);
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

    private void guildCommandHandler(String term, MessageChannel channel) {
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
    private String[] separateFirstTerm(String term) {
        if(term.contains(" ")) {
            int spaceIndex = term.indexOf(' ');
            return new String[]{term.substring(0, spaceIndex), term.substring(spaceIndex+1, term.length())};
        }
        return new String[]{term, ""};
    }

    //used to send text messages that might be very large. Breaks the message down into smaller chunks
    private void largeMessageSender(String message, MessageChannel channel) {
        while(message.length() > 1999)
        {
            int messageEndPoint = message.substring(0, 1999).lastIndexOf('\n');
            channel.sendMessage(message.substring(0, messageEndPoint)).queue();
            message = message.substring(messageEndPoint);
        }
        if(message.length() > 0)
            channel.sendMessage(message).queue();
    }
}
