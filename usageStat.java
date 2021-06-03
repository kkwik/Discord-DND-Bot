//Used to log when and where a command was called from

/**
 * A class used to log the bots usage by users.
 * Every call to the bot from PM or server generates a usageStat object which is placed on Main.usageStatQueue until removed
 */
public class usageStat {
    /**
     * The relevant id of this message, either the guild ID or the authors ID if a pm
     */
    private final long id;
    /**
     * The unix epoch timestamp of when this usageStat is generated
     */
    private final long timeStamp;
    /**
     * A boolean that is true if the message was originated from a private message and false otherwise
     */
    private final boolean pm;

    /**
     * Constructor for usageStat
     * @param id The ID of the guild/author
     * @param pm A boolean value that is true if the message is a private message
     */
    protected usageStat(final long id, final boolean pm)
    {
        this.id = id;
        this.timeStamp = System.currentTimeMillis();
        this.pm = pm;
    }

    /**
     * Returns the ID of the guild or author depending on the messages origin
     * @return a long that is the guild or author ID
     */
    protected long getId(){
        return id;
    }

    /**
     * Returns the time the usageStat was generated.
     * Unix epoch time sourced from System.currentTimeMillis()
     * @return a long containing the unix epoch time when the usageStat was generated
     */
    protected long getTime() { return timeStamp; }

    /**
     * Returns true if the usageStat originated from a private message
     * @return true if this usageStat was generated from a private message
     */
    protected boolean isPM() { return pm; }
}
