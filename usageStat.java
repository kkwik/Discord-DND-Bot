//Used to log when and where a command was called from

public class usageStat {
    private final long id;          //The relevant id of this message, either the guild ID or the authors ID if a pm
    private final long timeStamp;   //Unix epoch timestamp of when this message was sent
    private final boolean pm;       //True if this message was a pm

    protected usageStat(final long id, final boolean pm)
    {
        this.id = id;
        this.timeStamp = System.currentTimeMillis();
        this.pm = pm;
    }

    protected long getId(){
        return id;
    }

    protected long getTime() { return timeStamp; }
    protected boolean isPM() { return pm; }
}
