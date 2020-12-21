import java.util.EnumSet;
import java.util.HashSet;

//Enum that determines what a valid class is
public enum dndClasses {
    ARTIFICER, BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WARLOCK, WIZARD;   //All valid classes

    private static final HashSet<String> validClasses = new HashSet<String>();  //HashSet of all valid class names
    static{
        for(dndClasses dndClass : EnumSet.allOf(dndClasses.class))
            validClasses.add(dndClass.name());
    }

    protected static boolean isValid(final String searchForClass)  //Tests against validClasses HashSet and returns true if present. Throws exception if any non-uppercase characters are present
    {
        if(searchForClass.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();
        return validClasses.contains(searchForClass);
    }

    protected static dndClasses findClosestClass(final String searchClass)
    {
        if(searchClass.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();

        for(dndClasses dndClass : EnumSet.allOf(dndClasses.class))
            if(dndClass.name().contains(searchClass))
                return dndClass;

        return null;
    }
}
