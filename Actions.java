import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Actions extends ListenerAdapter {

    @Override   //This method is triggered everytime a message is sent in the discord server
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot())   //If the message sent is from a bot, then ignore it
            return;
        topLevelHandler(new MessageEvent(event));
    }

    @Override   //This method is triggered by private messages to the bot
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        if(event.getAuthor().isBot())   //If the message sent is from a bot, then ignore it
            return;
        topLevelHandler(new MessageEvent(event));
    }

    private void topLevelHandler(MessageEvent messageEvent) {
        String message = messageEvent.getMessage();
        if(message.length() < 2 || message.charAt(0) != ';')
            return;

        String[] parsedMessage = separateFirstTerm(message.substring(1).toLowerCase());

        switch(parsedMessage[0])
        {
            case "spell":
                spellCommandHandler(parsedMessage[1], messageEvent.getChannel());
                break;
            case "class":
                messageEvent.getChannel().sendMessage("Not implemented.").queue();
                break;
            case "bot":
                adminCommandHandler(parsedMessage[1], messageEvent.getAuthor(), messageEvent.getChannel());
                break;
            case "help":
                helpCommandHandler(parsedMessage[1], messageEvent.getAuthor());
                break;
            default:
                messageEvent.getChannel().sendMessage("Unrecognized command.").queue();
                break;
        }
    }

    private void spellCommandHandler(String searchTerm, MessageChannel channel) {
        String searchSpell = searchTerm.replaceAll("[^a-z]","");
        if(searchSpell.length() == 0) {   //If the searchTerm is symbols return because it is invalid
            channel.sendMessage("I'm sorry but I'm not a symbologist. How about adding some letters in there?").queue();
            return;
        }

        Stack<String> matches = new Stack<String>();
        String exactMatch = "";
        //Search
        for(int i = Main.spellList.length-1; i >= 0; i--)                              //Go through the list of spells in reverse order.
        {
            if (Main.spellList[i].toLowerCase().replaceAll("[^a-z]", "").equals(searchSpell))
            {
                exactMatch = Main.spellList[i];
                break;
            }
            else if (Main.spellList[i].toLowerCase().replaceAll("[^a-z]", "").contains(searchSpell))     //If the spell we are currently comparing against contains the term we are searching for
            {
                //Search term is contained within spell so put it on the list of potential spells
                matches.push(Main.spellList[i]);
            }
        }

        //Results
        if(!exactMatch.isEmpty() || matches.size() == 1)//Spell found
        {
            String imageName = (!exactMatch.isEmpty() ? exactMatch : matches.pop());
            //File imageFile = new File(new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile() + Main.FILE_SEPARATOR +"Images" + Main.FILE_SEPARATOR + imageName + ".png");
            File imageFile = new File("Images\\" + imageName + ".png");
            System.out.println(imageFile.getName());
            if(imageFile.exists()) //If a file by that name exists in the working directory then send it
                channel.sendFile(imageFile, "image.png").embed(new EmbedBuilder().setImage("attachment://image.png").setDescription("Ah... here it is:").build()).queue();
            else    //Print that something has gone wrong
                channel.sendMessage("Curious... I know of that file but cannot find it!\n[FILE IMAGE NOT FOUND]").queue();
            return;
        }
        else if(!matches.empty())    //If multiple similar spells were found
        {
            String response = "Hmm... I found a couple of spells that remind me of that one:\n";
            while(!matches.empty()) //Go through all the spells that contained the searchTerm and print them out
                response += matches.pop() + '\n';
            largeMessageSender(response, channel);
            return;
        }
        else        //No spell contained the searchTerm
        {
            channel.sendMessage("I'm sorry, but I couldn't find that spell.").queue();
            return;
        }
    }

    private void adminCommandHandler(String term, User author, MessageChannel channel)
    {
        if(author.getIdLong() != Main.ADMIN_ID)
            return;

        String[] parsedMessage = separateFirstTerm(term);
        switch(parsedMessage[0])
        {
            case "shutdown":
                channel.sendMessage("Shutting down...").queue();
                try{ TimeUnit.SECONDS.sleep(1);}
                catch(Exception e){}
                System.exit(0);
                break;

            case "uptime":
                long diff = System.currentTimeMillis() - Main.startEpoch;
                channel.sendMessage("Start Time: " + new Date(Main.startEpoch) + "\nTime Elapsed: " + String.format("%d days, %d hrs, %d mins, %d secs, %d ms", TimeUnit.MILLISECONDS.toDays(diff), TimeUnit.MILLISECONDS.toHours(diff) % 24, TimeUnit.MILLISECONDS.toMinutes(diff) % 60, TimeUnit.MILLISECONDS.toSeconds(diff) % 60, diff % 1000)).queue();
                break;

            case "guild":
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
            case "list":
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
        if(searchTerm.equals("spell"))
        {
            author.openPrivateChannel().complete().sendMessage("Used to get information about a spell. You can also search for a fragment of the spell name\nSyntax: ;spell [spell name].").queue();
        }
        else if(searchTerm.equals("bot"))
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
