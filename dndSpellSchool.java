import java.util.EnumSet;
import java.util.HashSet;

//Enum that determines what a valid school for a spell is
public enum dndSpellSchool {
    ABJURATION, CONJURATION, DIVINATION, ENCHANTMENT, EVOCATION, ILLUSION, NECROMANCY, TRANSMUTATION;   //All valid schools

    private static final HashSet<String> validSchools = new HashSet<String>();  //HashSet of all valid school names
    static{
        for(dndSpellSchool school : EnumSet.allOf(dndSpellSchool.class))
            validSchools.add(school.name());
    }

    protected static boolean isValid(final String searchForSchool) //Tests against validSchools HashSet and returns true if present. Throws exception if any non-uppercase characters are present
    {
        if(searchForSchool.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();
        return validSchools.contains(searchForSchool);
    }
}