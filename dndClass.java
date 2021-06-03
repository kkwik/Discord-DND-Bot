import java.util.EnumSet;
import java.util.HashSet;

/**
 * An Enum that represents all valid classes the bot knows.
 */
public enum dndClass {
    ARTIFICER, BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WARLOCK, WIZARD;   //All valid classes

    /**
     * A static member field storing a list of all class values. Uppercase, letters only.
     */
    private static final HashSet<String> validClasses = new HashSet<String>();  //HashSet of all valid class names
    static{
        for(dndClass dndClass : EnumSet.allOf(dndClass.class))
            validClasses.add(dndClass.name());
    }

    /**
     * Checks if the provided String is contained in the Enum
     * @param searchForClass The name of the class to check for
     * @return A boolean value, true if the String is a valid class name and false otherwise
     * @throws IllegalArgumentException
     */
    protected static boolean isValid(final String searchForClass)  //Tests against validClasses HashSet and returns true if present. Throws exception if any non-uppercase characters are present
    {
        if(searchForClass.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();
        return validClasses.contains(searchForClass);
    }

    /**
     * Finds and returns the closest class name to the search string.
     * @param searchClass The name of the class to search for
     * @return An enum value of dndClass that is the closest value to the search string or null if no school was close
     */
    protected static dndClass findClosestClass(final String searchClass)
    {
        if(searchClass.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();

        for(dndClass dndClass : EnumSet.allOf(dndClass.class))
            if(dndClass.name().contains(searchClass))
                return dndClass;

        return null;
    }
}
