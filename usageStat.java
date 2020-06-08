public class usageStat {
    private final long guildId;
    private final long timeStamp;
    protected usageStat(final long guildId)
    {
        this.guildId = guildId;
        this.timeStamp = System.currentTimeMillis();
    }

    protected long getGuildId(){
        return guildId;
    }
    protected long getTime(){
        return timeStamp;
    }
}
