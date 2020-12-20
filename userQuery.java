import net.dv8tion.jda.api.entities.User;
import java.util.ArrayList;

//Stores the latest query of of a user
public class userQuery<E> {
    private final User author;                  //The user who created this query. Each user can have at most one userquery
    private final ArrayList<E> queryResults;    //The list of results from the query
    private final queryType type;               //The type of query it was. Currently supports only feats and spells

    
    protected userQuery(final User author, final ArrayList<E> queryResults, final queryType type)
    {
        this.author = author;
        this.queryResults = queryResults;
        this.type = type;
    }

    protected User getAuthor()
    {
        return author;
    }

    protected ArrayList<E> getResults()
    {
        return queryResults;
    }

    protected queryType getType()
    {
        return type;
    }

    protected enum queryType{
        SPELL, FEAT;
    }

}
