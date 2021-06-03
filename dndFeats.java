import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;


//Enum that determines what a valid feat is. Each field contains a properly formatted string name
/**
 * An Enum that represents all valid feats the bot knows.
 * Each value contains a formatted name
 */
public enum dndFeats {
    //PHB feats
    ACTOR ("Actor"),
    ALERT ("Alert"),
    ATHLETE ("Athlete"),
    CHARGER ("Charger"),
    CROSSBOWEXPERT ("Crossbow Expert"),
    DEFENSIVEDUELIST ("Defensive Duelist"),
    DUALWIELDER ("Dual Wielder"),
    DUNGEONDELVER ("Dungeon Delver"),
    DURABLE ("Durable"),
    ELEMENTALADEPT ("Elemental Adept"),
    GRAPPLER ("Grappler"),
    GREATWEAPONMASTER ("Great Weapon Master"),
    HEALER ("Healer"),
    HEAVILYARMORED ("Heavily Armored"),
    HEAVYARMORMASTER ("Heavy Armor Master"),
    INSPIRINGLEADER ("Inspiring Leader"),
    KEENMIND ("Keen Mind"),
    LIGHTLYARMORED ("Lightly Armored"),
    LINGUIST ("Linguist"),
    LUCKY ("Lucky"),
    MAGESLAYER ("Mage Slayer"),
    MAGICINITIATE ("Magic Initiate"),
    MARTIALADEPT ("Martial Adept"),
    MEDIUMARMORMASTER ("Medium Armor Master"),
    MOBILE ("Mobile"),
    MODERATELYARMORED ("Moderately Armored"),
    MOUNTEDCOMBATANT ("Mounted Combatant"),
    OBSERVANT ("Observant"),
    POLEARMMASTER ("Polearm Master"),
    RESILIENT ("Resilient"),
    RITUALCASTER ("Ritual Caster"),
    SAVAGEATTACKER ("Savage Attacker"),
    SENTINEL ("Sentinel"),
    SHARPSHOOTER ("Sharpshooter"),
    SHIELDMASTER ("Shield Master"),
    SKILLED ("Skilled"),
    SKULKER ("Skulker"),
    SPELLSNIPER ("Spell Sniper"),
    TAVERNBRAWLER ("Tavern Brawler"),
    TOUGH ("Tough"),
    WARCASTER ("War Caster"),
    WEAPONMASTER ("Weapon Master"),

    //Xanathar's Guide to Everything feats
    BOUNTIFULLUCK ("Bountiful Luck"),
    DRAGONFEAR ("Dragon Fear"),
    DRAGONHIDE ("Dragon Hide"),
    DROWHIGHMAGIC ("Drow High Magic"),
    DWARVENFORTITUDE ("Dwarven Fortitude"),
    ELVENACCURACY ("Elven Accuracy"),
    FADEAWAY ("Fade Away"),
    FEYTELEPORTATION ("Fey Teleportation"),
    FLAMESOFPHLEGETHOS ("Flames of Phlegethos"),
    INFERNALCONSTITUTION ("Infernal Constitution"),
    ORCISHFURY ("Orcish Fury"),
    PRODIGY ("Prodigy"),
    SECONDCHANCE ("Second Chance"),
    SQUATNIMBLENESS ("Squat Nimbleness"),
    WOODELFMAGIC ("Wood Elf Magic"),

    //Tasha
    ARTIFICERINITIATE ("Artificer Initiate"),
    CHEF ("Chef"),
    CRUSHER ("Crusher"),
    ELDRITCHADEPT ("Eldritch Adept"),
    FEYTOUCHED ("Fey Touched"),
    FIGHTINGINITIATE ("Fighting Initiate"),
    GUNNER ("Gunner"),
    METAMAGICADEPT ("Metamagic Adept"),
    PIERCER ("Piercer"),
    POISONER ("Poisoner"),
    SHADOWTOUCHED ("Shadow Touched"),
    SKILLEXPERT ("Skill Expert"),
    SLASHER ("Slasher"),
    TELEKINETIC ("Telekinetic"),
    TELEPATHIC ("Telepathic");

    /**
     * A member field storing the conditions fully formatted name used for text output to the user
     */
    private final String featName;
    /**
     * A static member field storing how many feats there are
     */
    private static final int size = dndFeats.values().length;
    /**
     * A static member field storing a list of all feat values. Uppercase, letters only.
     */
    private static final HashSet<String> validFeatNames = new HashSet<String>();
    static{
        for(dndFeats name : EnumSet.allOf(dndFeats.class))
            validFeatNames.add(name.name());
    }

    /**
     * Constructor for the dndFeats enum
     * @param featName The fully punctuated name for the feat
     */
    dndFeats(final String featName) {
        this.featName = featName;
    }

    /**
     * Overriding the toString function to return the properly punctuated feat name
     * @return A string that is the fully punctuated feat name
     */
    @Override
    public String toString()
    {
        return featName;
    }

    /**
     * A Comparator class used to sort feats based on String comparison
     */
    static class featSorter implements Comparator<dndFeats>
    {
        /**
         * Overriden compare method that uses String.compareTo(String)
         * @param a The first feat to compare with
         * @param b The feat to compare against
         * @return The value returned by String.compareTo(String)
         */
        @Override
        public int compare(dndFeats a, dndFeats b)
        {
            return a.toString().compareTo(b.toString());
        }
    }
    /**
     * Checks if the provided String is contained in the Enum
     * @param searchForFeat The name of the feat to check for
     * @return A boolean value, true if the String is a valid feat name and false otherwise
     * @throws IllegalArgumentException
     */
    protected static boolean isValid(final String searchForFeat)       //Tests against validFeatNames HashSet and returns true if present. Throws exception if any non-uppercase characters are present
    {
        //TODO: Check for any non uppercase letters, not for all
        if(searchForFeat.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();
        return validFeatNames.contains(searchForFeat);
    }
    /**
     * Returns how many feats are in the enum
     * @return An integer representing the number of feats in the enum
     */
    protected int getSize()
    {
        return size;
    }
}
