import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashSet;

public class Main extends ListenerAdapter {
    /*
        This project uses the JDA wrapper for Discord API found at: https://github.com/DV8FromTheWorld/JDA
        Documentation for JDA is found here: https://ci.dv8tion.net/job/JDA/javadoc/
    */
    protected static JDA bot;
    protected static long startEpoch;
    public static void main(String[] args) throws LoginException, InterruptedException, IOException {
        //Init
        initGuildWhitelist();
        //Init done

        startEpoch = System.currentTimeMillis();
        JDABuilder builder = JDABuilder.createDefault(PersonalData.BETA_TOKEN);   //Builds the bot builder based on your bots token. Here that token is stored in a PersonalData.java file you will have to create
        bot = builder.build().awaitReady();                                                                         //Builds bot
        bot.getPresence().setStatus(OnlineStatus.ONLINE);                                                               //Sets bot to online status
        bot.addEventListener(new Actions());                                                                            //This bot uses event listeners to listen for events in discord servers. To execute custom actions on events I created my own event listener named "Actions.java"
    }

    protected static final String executionDirLocation = System.getProperty("user.dir");    //Used for locating the files to send
    protected static final String FILE_SEPARATOR = System.getProperty("file.separator");
    protected static final char trigger = ';';

    protected static final ArrayDeque<usageStat> usageStatQueue = new ArrayDeque<>();
    protected static long usageStat = 0;    //Stores the amount of times the bot was called
    //guildWhitelist is a list of whitelisted guilds. This list is found in a PersonalData.java file not included in this repository
    protected static final HashSet<Long> guildWhitelist = new HashSet<Long>();
    private static void initGuildWhitelist() {
        for(long guildId : PersonalData.guilds)
            guildWhitelist.add(guildId);
    }
}
