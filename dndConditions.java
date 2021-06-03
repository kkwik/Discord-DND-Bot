import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;


/**
 * An Enum that represents all valid condition effects the bot knows.
 * Each value contains a formatted name
 */
public enum dndConditions {
    BLINDED ("Blinded"),
    CHARMED ("Charmed"),
    DEAFENED ("Deafened"),
    FRIGHTENED ("Frightened"),
    GRAPPLED ("Grappled"),
    INCAPACITATED ("Incapacitated"),
    INVISIBLE ("Invisible"),
    PARALYZED ("Paralyzed"),
    PETRIFIED ("Petrified"),
    EXHAUSTION ("Exhaustion"),
    POISONED ("Poisoned"),
    PRONE ("Prone"),
    RESTRAINED ("Restrained"),
    STUNNED ("Stunned"),
    UNCONSCIOUS ("Unconscious");

    /**
     * A member field storing the conditions fully formatted name used for text output to the user
     */
    private final String condName;
    /**
     * A static member field storing how many conditions there are
     */
    private static final int size = dndConditions.values().length;
    /**
     * A static member field storing a list of all condition values. Uppercase, letters only.
     */
    private static final HashSet<String> validCondNames = new HashSet<String>();
    static{
        for(dndConditions name : EnumSet.allOf(dndConditions.class))
            validCondNames.add(name.name());
    }

    /**
     * Constructor for the dndConditions enum
     * @param condName The fully punctuated name for the condition
     */
    dndConditions(final String condName) {
        this.condName = condName;
    }
    /**
     * Overriding the toString function to return the properly punctuated condition name
     * @return A string that is the fully punctuated condition name
     */
    @Override
    public String toString()
    {
        return condName;
    }
    /**
     * A Comparator class used to sort conditions based on String comparison
     */
    static class condSorter implements Comparator<dndConditions>
    {
        /**
         * Overriden compare method that uses String.compareTo(String)
         * @param a The first condition to compare with
         * @param b The condition to compare against
         * @return The value returned by String.compareTo(String)
         */
        @Override
        public int compare(dndConditions a, dndConditions b)
        {
            return a.toString().compareTo(b.toString());
        }
    }
    /**
     * Checks if the provided String is contained in the Enum
     * @param searchForCond The name of the condition to check for
     * @return A boolean value, true if the String is a valid condition name and false otherwise
     * @throws IllegalArgumentException
     */
    protected static boolean isValid(final String searchForCond)       //Tests against validCondNames HashSet and returns true if present. Throws exception if any non-uppercase characters are present
    {
        //TODO: Check for any non uppercase letters, not for all
        if(searchForCond.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();
        return validCondNames.contains(searchForCond);
    }
    /**
     * Returns how many conditions are in the enum
     * @return An integer representing the number of conditions in the enum
     */
    protected int getSize() {
        return size;
    }
}
