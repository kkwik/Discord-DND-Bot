//Used to log when and where a command was called from

public class usageStat {
    private final long id;
    private final long timeStamp;
    private final boolean pm;
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
