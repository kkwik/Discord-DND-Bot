import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;


//Enum that determines what a valid cond is. Each field contains a properly formatted string name
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

    private final String condName;                                         //The conds fully punctuated name used for text output
    private static final int size = dndConditions.values().length;              //The amount of conds
    private static final HashSet<String> validCondNames = new HashSet<String>();     //A HashSet of the valid cond names. Uppercase only.
    static{
        for(dndConditions name : EnumSet.allOf(dndConditions.class))
            validCondNames.add(name.name());
    }

    //This enum contains all the conds and condnames
    dndConditions(final String condName) {
        this.condName = condName;
    }

    @Override
    public String toString(){return condName;}                         //Overriding toString() to return the punctuated name of the cond

    static class condSorter implements Comparator<dndConditions>
    {
        @Override
        public int compare(dndConditions a, dndConditions b)
        {
            return a.toString().compareTo(b.toString());
        }
    }

    protected static boolean isValid(final String searchForCond)       //Tests against validCondNames HashSet and returns true if present. Throws exception if any non-uppercase characters are present
    {
        if(searchForCond.replaceAll("[^A-Z]","").length() == 0)
            throw new IllegalArgumentException();
        return validCondNames.contains(searchForCond);
    }
    protected int getSize(){return size;}
}
