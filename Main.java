import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
        JDABuilder builder = JDABuilder.createDefault(PersonalData.BETA_TOKEN);   //This line builds the bot builder. Replace %REPLACEME% with the token for your bot
        bot = builder.build().awaitReady();                                                                         //Builds bot
        bot.getPresence().setStatus(OnlineStatus.ONLINE);                                                               //Sets bot to online status
        bot.addEventListener(new Actions());                                                                            //This bot uses event listeners to listen for events in discord servers. To execute custom actions on events I created my own event listener named "Actions.java"
    }

    protected static final String executionLocation = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getAbsolutePath();
    protected static final String FILE_SEPARATOR = System.getProperty("file.separator");
    protected static final char trigger = ';';

    protected static HashSet<Long> guildWhitelist = new HashSet<Long>();
    private static void initGuildWhitelist() {
        for(long guildId : PersonalData.guilds)
            guildWhitelist.add(guildId);
    }
}
