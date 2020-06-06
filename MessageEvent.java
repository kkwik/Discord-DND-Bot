import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

public class MessageEvent {
    private final MessageChannel channel;
    private final User author;
    private final String message;

    protected MessageEvent(GuildMessageReceivedEvent event)
    {
        channel = event.getChannel();
        author = event.getAuthor();
        message = event.getMessage().getContentRaw();
    }

    protected MessageEvent(PrivateMessageReceivedEvent event)
    {
        channel = event.getChannel();
        author = event.getAuthor();
        message = event.getMessage().getContentRaw();
    }

    protected MessageChannel getChannel(){return channel;}
    protected User getAuthor(){return author;}
    protected String getMessage(){return message;}
}
