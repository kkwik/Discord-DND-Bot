import java.util.EnumSet;
import java.util.HashSet;

//Enum that determines what a valid class is
public enum dndClasses {
    BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WARLOCK, WIZARD;

    private static final HashSet<String> validClasses = new HashSet<String>();
    static{
        for(dndClasses dndClass : EnumSet.allOf(dndClasses.class))
            validClasses.add(dndClass.name());
    }

    protected static boolean isValid(final String searchForClass){return validClasses.contains(searchForClass);}
}
