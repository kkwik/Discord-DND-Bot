import java.util.EnumSet;
import java.util.HashSet;

/**
 * An Enum that represents all valid spell schools the bot knows.
 */
public enum dndSpellSchool {
    ABJURATION, CONJURATION, DIVINATION, ENCHANTMENT, EVOCATION, ILLUSION, NECROMANCY, TRANSMUTATION;

    /**
     * A static member field storing a list of all school values. Uppercase, letters only.
     */
    private static final HashSet<String> validSchools = new HashSet<String>();
    static{
        for(dndSpellSchool school : EnumSet.allOf(dndSpellSchool.class))
            validSchools.add(school.name());
    }

    /**
     * Checks if the provided String is contained in the Enum
     * @param searchForSchool The name of the school to check for
     * @return A boolean value, true if the String is a valid school name and false otherwise
     * @throws IllegalArgumentException
     */
    protected static boolean isValid(final String searchForSchool) //Tests against validSchools HashSet and returns true if present. Throws exception if any non-uppercase characters are present
    {
        //TODO: Check for any non uppercase letters, not for all
        if(searchForSchool.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();
        return validSchools.contains(searchForSchool);
    }

    /**
     * Finds and returns the closest school name to the search string.
     * @param searchSchool The name of the school to search for
     * @return An enum value of dndSpellSchool that is the closest value to the search string or null if no school was close
     */
    protected static dndSpellSchool findClosestSchool(final String searchSchool)
    {
        if(searchSchool.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();

        //TODO: Revamp this to actually look for the closest
        for(dndSpellSchool dndSchool : EnumSet.allOf(dndSpellSchool.class))
            if(dndSchool.name().contains(searchSchool))
                return dndSchool;

        return null;
    }
}