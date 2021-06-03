import net.dv8tion.jda.api.entities.User;
import java.util.ArrayList;


/**
 * The userQuery class represents the results of a user's search query.
 */
public class userQuery<E> {
    /**
     * The user who initiated this search query.
     * Currently a user can only have one userQuery at a time in storedUserQueries.
     *
     * @see Actions#storedUserQueries
     */
    private final User author;

    /**
     * A list of the results from the user query.
     */
    private final ArrayList<E> queryResults;

    /**
     * The type of the elements of queryResults. Currently only FEAT or SPELL
     *
     * @see userQuery#queryResults
     * @see userQuery.queryType
     */
    private final queryType type;

    /**
     * Constructor for userQuery
     * @param author The User who initiated the query
     * @param queryResults The list of Enum values returned from the query
     * @param type The type of Enum the query was for
     */
    protected userQuery(final User author, final ArrayList<E> queryResults, final queryType type)
    {
        this.author = author;
        this.queryResults = queryResults;
        this.type = type;
    }

    /**
     * Returns the User who initiated this userQuery
     * @return the User who initiated the userQuery
     */
    protected User getAuthor()
    {
        return author;
    }

    /**
     * Returns the results of this userQuery
     * @return An ArrayList containing a list of the
     */
    protected ArrayList<E> getResults()
    {
        return queryResults;
    }

    /**
     * Returns the type of the search
     * @return The type of the search
     *
     * @see userQuery.queryType
     */
    protected queryType getType()
    {
        return type;
    }

    /**
     * An enum which represents the valid types of a userQuery.
     */
    protected enum queryType{
        SPELL, FEAT;
    }

}
