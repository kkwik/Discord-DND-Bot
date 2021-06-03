import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

//Class that wraps up both GuildMessageReceivedEvents and PrivateMessageReceivedEvents so they can be used in the same methods since we don't need the distinctions between the two

/**
 * A class that wraps both GuildMessageReceivedEvents and PrivateMessageReceivedEvents
 * For our purposes the distinctions between the two don't matter so this class allows us to treat them the same
 */
public final class MessageEvent {
    private final MessageChannel channel;   //The channel the message was in
    private final User author;              //The author of the message
    private final String message;           //The text of the message
    private final long guildId;              //The guildId if applicable. -1 if pm
    private final eventType type;

    /**
     * A constructor for if the source MessageEvent was a server message
     * @param event The guild message event that triggered the call
     */
    protected MessageEvent(final GuildMessageReceivedEvent event)
    {
        channel = event.getChannel();
        author = event.getAuthor();
        message = event.getMessage().getContentRaw();
        guildId = event.getGuild().getIdLong();
        type = eventType.GUILD;
    }

    /**
     * A constructor for if the source MessageEvent was a private message
     * @param event The private message event that triggered the call
     */
    protected MessageEvent(final PrivateMessageReceivedEvent event)
    {
        channel = event.getChannel();
        author = event.getAuthor();
        message = event.getMessage().getContentRaw();
        guildId = -1;
        type = eventType.PRIVATE;
    }

    protected final MessageChannel getChannel(){return channel;}
    protected final User getAuthor(){return author;}
    protected final String getMessage(){return message;}
    protected final long getGuildId(){return guildId;}
    protected final eventType getType(){return type;}

    protected enum eventType{
        GUILD, PRIVATE
    }
}
