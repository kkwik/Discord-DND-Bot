import java.util.EnumSet;
import java.util.HashSet;


//Enum that determines what a valid feat is. Each field contains a properly formatted string name
public enum dndFeats {
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
    WEAPONMASTER ("Weapon Master");

    private final String featName;                                         //The feats fully punctuated name used for text output
    private static final int size = dndFeats.values().length;              //The amount of feats
    private static final HashSet<String> validFeatNames = new HashSet<String>();     //A HashSet of the valid feat names. Uppercase only.
    static{
        for(dndFeats name : EnumSet.allOf(dndFeats.class))
            validFeatNames.add(name.name());
    }

    //This enum contains all the feats and featnames
    dndFeats(final String featName) {
        this.featName = featName;
    }

    @Override
    public String toString(){return featName;}                         //Overriding toString() to return the punctuated name of the feat
    protected static boolean isValid(final String searchForFeat)       //Tests against validFeatNames HashSet and returns true if present. Throws exception if any non-uppercase characters are present
    {
        if(searchForFeat.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();
        return validFeatNames.contains(searchForFeat);
    }
    protected int getSize(){return size;}
}
