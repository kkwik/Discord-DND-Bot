import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;


//Enum that determines what a valid feat is. Each field contains a properly formatted string name
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

    static class featSorter implements Comparator<dndFeats>
    {
        @Override
        public int compare(dndFeats a, dndFeats b)
        {
            return a.toString().compareTo(b.toString());
        }
    }

    protected static boolean isValid(final String searchForFeat)       //Tests against validFeatNames HashSet and returns true if present. Throws exception if any non-uppercase characters are present
    {
        if(searchForFeat.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();
        return validFeatNames.contains(searchForFeat);
    }
    protected int getSize(){return size;}
}
