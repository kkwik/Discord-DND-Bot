import java.util.EnumSet;
import java.util.HashSet;

//Enum that determines what a valid school for a spell is
public enum dndSpellSchool {
    ABJURATION, CONJURATION, DIVINATION, ENCHANTMENT, EVOCATION, ILLUSION, NECROMANCY, TRANSMUTATION;

    private static final HashSet<String> validSchools = new HashSet<String>();
    static{
        for(dndSpellSchool school : EnumSet.allOf(dndSpellSchool.class))
            validSchools.add(school.name());
    }

    protected static boolean isValid(final String searchForSchool){return validSchools.contains(searchForSchool);}
}