import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

//Class that wraps up both GuildMessageReceivedEvents and PrivateMessageReceivedEvents so they can be used in the same methods since we don't need the distinctions between the two
public final class MessageEvent {
    private final MessageChannel channel;   //The channel the message was in
    private final User author;              //The author of the message
    private final String message;           //The text of the message
    private long guildId = -1;              //The guildId if applicable. -1 if pm

    protected MessageEvent(final GuildMessageReceivedEvent event)
    {
        channel = event.getChannel();
        author = event.getAuthor();
        message = event.getMessage().getContentRaw();
        guildId = event.getGuild().getIdLong();
    }

    protected MessageEvent(final PrivateMessageReceivedEvent event)
    {
        channel = event.getChannel();
        author = event.getAuthor();
        message = event.getMessage().getContentRaw();
    }

    protected final MessageChannel getChannel(){return channel;}
    protected final User getAuthor(){return author;}
    protected final String getMessage(){return message;}
    protected final long getGuildId(){return guildId;}
}
