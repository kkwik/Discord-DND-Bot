import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Main extends ListenerAdapter {
    /*
        This project uses the JDA wrapper for Discord API found at: https://github.com/DV8FromTheWorld/JDA
        Documentation for JDA is found here: https://ci.dv8tion.net/job/JDA/javadoc/
    */

    protected static JDA bot;
    protected static long startEpoch;
    public static void main(String[] args) throws LoginException, InterruptedException, IOException {
        startEpoch = System.currentTimeMillis();
        JDABuilder builder = JDABuilder.createDefault(BOT_TOKEN);
        bot = builder.build().awaitReady();
        bot.getPresence().setStatus(OnlineStatus.ONLINE);
        bot.addEventListener(new Actions());
    }

    protected static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String BOT_TOKEN = ""; //Use your bot token
    protected static final long ADMIN_ID = 0;   //Use your user id. Only this user can use 'bot' commands
    protected static final char trigger = ';';

    //List of all 360 PHB spells alphabetically
    protected static final String[] spellList = new String[]{
            "Acid Splash", "Aid", "Alarm", "Alter Self", "Animal Friendship", "Animal Messenger", "Animal Shapes", "Animate Dead", "Animate Objects", "Antilife Shell", "Antimagic Field", "Antipathy/Sympathy",
            "Arcane Eye", "Arcane Gate", "Arcane Lock", "Armor of Agathys", "Arms of Hadar", "Astral Projection", "Augury", "Aura of Life", "Aura of Purity", "Aura of Vitality", "Awaken", "Bane", "Banishing Smite",
            "Banishment", "Barkskin", "Beacon of Hope", "Beast Sense", "Bestow Curse", "Bigby's Hand", "Blade Barrier", "Blade Ward", "Bless", "Blight", "Blinding Smite", "Blindness/Deafness", "Blink", "Blur",
            "Branding Smite", "Burning Hands", "Call Lightning", "Calm Emotions", "Chain Lightning", "Charm Person", "Chill Touch", "Chromatic Orb", "Circle of Death", "Circle of Power", "Clairvoyance", "Clone",
            "Cloud of Daggers", "Cloudkill", "Color Spray", "Command", "Commune", "Commune with Nature", "Compelled Duel", "Comprehend Languages", "Compulsion", "Cone of Cold", "Confusion", "Conjure Animals",
            "Conjure Barrage", "Conjure Celestial", "Conjure Elemental", "Conjure Fey", "Conjure Minor Elementals", "Conjure Volley", "Conjure Woodland Beings", "Contact Other Plane", "Contagion", "Contingency",
            "Continual Flame", "Control Water", "Control Weather", "Cordon of Arrows", "Counterspell", "Create Food and Water", "Create or Destroy Water", "Create Undead", "Creation", "Crown of Madness",
            "Crusader's Mantle", "Cure Wounds", "Dancing Lights", "Darkness", "Darkvision", "Daylight", "Death Ward", "Delayed Blast Fireball", "Demiplane", "Destructive Wave", "Detect Evil And Good", "Detect Magic",
            "Detect Poison and Disease", "Detect Thoughts", "Dimension Door", "Disguise Self", "Disintegrate", "Dispel Evil and Good", "Dispel Magic", "Dissonant Whispters", "Divination", "Divine Favor", "Divine Word",
            "Dominate Beast", "Dominate Monster", "Dominate Person", "Drawmij's Instant Summons", "Dream", "Druidcraft", "Earthquake", "Eldritch Blast", "Elemental Weapon", "Enhance Ability", "Enlarge/Reduce",
            "Ensnaring Strike", "Entangle", "Enthrall", "Etherealness", "Evard's Black Tentacles", "Expeditious Retreat", "Eyebite", "Fabricate", "Faerie Fire", "False Life", "Fear", "Feather Fall", "Feeblemind",
            "Feign Death", "Find Familiar", "Find Steed", "Find the Path", "Find Traps", "Finger of Death", "Fireball", "Fire Bolt", "Fire Shield", "Fire Storm", "Flame Blade", "Flame Strike", "Flaming Sphere",
            "Flesh to Stone", "Fly", "Fog Cloud", "Forbiddance", "Forcecage", "Foresight", "Freedom of Movement", "Friends", "Gaseous Form", "Gate", "Geas", "Gentle Repose", "Giant Insect", "Glibness",
            "Globe of Invulnerability", "Glyph of Warding", "Goodberry", "Grasping Vine", "Grease", "Greater Invisibility", "Greater Restoration", "Guardian of Faith", "Guards and Wards", "Guidance",
            "Guiding Bolt", "Gust of Wind", "Hail of Thorns", "Hallow", "Hallucinatory Terrain", "Harm", "Haste", "Heal", "Heat Metal", "Hellish Rebuke", "Heroes' Feast", "Heroism", "Hex", "Hold Monster",
            "Hold Person", "Holy Aura", "Hunger of Hadar", "Hunter's Mark", "Hypnotic Pattern", "Ice Storm", "Identify", "Illusory Script", "Imprisonment", "Incendiary Cloud", "Inflict Wounds", "Insect Plague",
            "Invisibility", "Jump", "Knock", "Legend Lore", "Leomund's Secret Chest", "Leomund's Tiny Hut", "Lesser Restoration", "Levitate", "Light", "Lightning Arrow", "Lightning Bolt", "Locate Animals or Plants",
            "Locate Creature", "Locate Object", "Longstrider", "Mage Armor", "Mage Hand", "Magic Circle", "Magic Jar", "Magic Missile", "Magic Mouth", "Magic Weapon", "Major Image", "Mass Cure Wounds",
            "Mass Heal", "Mass Healing Word", "Mass Suggestion", "Maze", "Meld Into Stone", "Melf's Acid Arrow", "Mending", "Message", "Meteor Swarm", "Mind Blank", "Minor Illusion", "Mirage Arcane",
            "Mirror Image", "Mislead", "Misty Step", "Modify Memory", "Moonbeam", "Mordenkainen's Faithful Hound", "Mordenkainen's Magnificent Mansion", "Mordenkainen's Private Sanctum",
            "Mordenkainen's Sword", "Move Earth", "Nondetection", "Nystul's Magic Aura", "Otiluke's Freezing Sphere", "Otiluke's Resilient Sphere", "Otto's Irresistible Dance", "Pass Without Trace",
            "Passwall", "Phantasmal Force", "Phantasmal Killer", "Phantom Steed", "Planar Ally", "Planar Binding", "Plane Shift", "Plant Growth", "Poison Spray", "Polymorph", "Power Word Heal", "Power Word Kill",
            "Power Word Stun", "Prayer of Healing", "Prestidigitation", "Prismatic Spray", "Prismatic Wall", "Produce Flame", "Programmed Illusion", "Project Image", "Protection From Energy",
            "Protection From Evil and Good", "Protection From Poison", "Purify Food and Drink", "Raise Dead", "Rary's Telepathic Band", "Ray of Enfeeblement", "Ray of Frost", "Ray of Sickness", "Regenerate",
            "Reincarnate", "Remove Curse", "Resistance", "Resurrection", "Reverse Gravity", "Revivify", "Rope Trick", "Sacred Flame", "Sanctuary", "Scorching Ray", "Scrying", "Searing Smite", "See Invisibility",
            "Seeming", "Sending", "Sequester", "Shapechange", "Shatter", "Shield", "Shield of Faith", "Shillelagh", "Shocking Grasp", "Silence", "Silent Image", "Simulacrum", "Sleep", "Sleet Storm",
            "Slow", "Spare the Dying", "Speak with Animals", "Speak with Dead", "Speak with Plants", "Spider Climb", "Spike Growth", "Spirit Guardians", "Spiritual Weapon", "Staggering Smite", "Stinking Cloud",
            "Stone Shape", "Stoneskin", "Storm of Vengeance", "Suggestion", "Sunbeam", "Sunburst", "Swift Quiver", "Symbol", "Tasha's Hideous Laughter", "Telekinesis", "Telepathy", "Teleport", "Teleportation Circle",
            "Tenser's Floating Disk", "Thaumaturgy", "Thorn Whip", "Thunderous Smite", "Thunderwave", "Time Stop", "Tongues", "Transport Via Plants", "Tree Stride", "True Polymorph", "True Resurrection", "True Seeing",
            "True Strike", "Tsunami", "Unseen Servant", "Vampiric Touch", "Vicious Mockery", "Wall of Fire", "Wall of Force", "Wall of Ice", "Wall of Stone", "Wall of Thorns", "Warding Bond", "Water Breathing",
            "Water Walk", "Web", "Weird", "Wind Walk", "Wind Wall", "Wish", "Witch Bolt", "Word of Recall", "Wrathful Smite", "Zone of Truth"
    };
}
