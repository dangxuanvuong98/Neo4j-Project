package database;
import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

public class Connector
{
    // Driver objects are thread-safe and are typically made available application-wide.
    Driver driver;

    public Connector(String uri, String user, String password)
    {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    private void query(StringBuilder query)
    {
        // Sessions are lightweight and disposable connection wrappers.
        try (Session session = driver.session())
        {
            // Wrapping Cypher in an explicit transaction provides atomicity
            // and makes handling errors much easier.
            try (Transaction tx = session.beginTransaction())
            {
                tx.run(query.toString());
                tx.success();  // Mark this write as successful.
            }
        }
    }

    public void close()
    {
        driver.close();
    }
}