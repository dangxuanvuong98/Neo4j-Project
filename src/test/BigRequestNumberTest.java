package test;
import java.util.ArrayList;

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

public class BigRequestNumberTest
{
    // Driver objects are thread-safe and are typically made available application-wide.
    Driver driver;

    public BigRequestNumberTest(String uri, String user, String password)
    {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }
    
    private void deleteBatch(Integer startIndex, Integer endIndex) {
    	long start = System.currentTimeMillis();
    	String model = "[{name: \"Vuong_0\", age: 20}";
    	for (Integer i = startIndex; i < endIndex; i++) {
    		System.out.println(i);
    		model += ", {name: \"Vuong_" + i.toString() + "\", age: 20}";
    	}
    	model += "]";
    	String query = "unwind " + model + " as row match(n) where n.name = row.name detach delete n";
    	System.out.println("Time for generating query string: " + (System.currentTimeMillis() - start));
    	start = System.currentTimeMillis();
    	try (Session session = driver.session())
        {
            try (Transaction tx = session.beginTransaction())
            {
                tx.run(query);
                tx.success();  // Mark this write as successful.
            }
        }
    	System.out.println("Time for query: " + (System.currentTimeMillis() - start));
    }

    private void addBatch(Integer batchSize) {
//    	long start = System.currentTimeMillis();
    	String model = "[{name: \"Vuong_0\", age: 20}";
    	for (Integer i = 1; i < batchSize; i++) {
    		model += ", {name: \"Vuong_" + i.toString() + "\", age: 20}";
    	}
    	model += "]";
    	String query = "unwind " + model + " as row create(n: label) set n += row";
//    	System.out.println("Time for generating query string: " + (System.currentTimeMillis() - start));
//    	start = System.currentTimeMillis();
    	try (Session session = driver.session())
        {
            // Wrapping Cypher in an explicit transaction provides atomicity
            // and makes handling errors much easier.
            try (Transaction tx = session.beginTransaction())
            {
                tx.run(query);
                tx.success();  // Mark this write as successful.
            }
        }
//    	System.out.println("Time for query: " + (System.currentTimeMillis() - start));
    }
    
    private void addBatchver2(Integer batchSize) {
    	ArrayList<String> model = new ArrayList<String>();
    	for (Integer i = 0; i < batchSize; i++) {
    		model.add("(:Person{name: \"Vuong_" + i.toString() + "\", age: 20})");
    	}
    	String query = "CREATE " + String.join(", ", model);
    	try (Session session = driver.session())
        {
            try (Transaction tx = session.beginTransaction())
            {
                tx.run(query);
                tx.success();
            }
        }
    }
    
    private void addMiniBatch(Integer batchSize) {
    	for (Integer i = 0; i < batchSize; i++) {
    		try (Session session = driver.session()) {
    			try (Transaction tx = session.beginTransaction()) {
    				tx.run("CREATE (n:Person {name: {x}, age: {y}})", parameters("x", "Vuong_" + i.toString(), "y", 20));
                    tx.success();
    			}
    		}
    	}
    }

    public void close()
    {
        // Closing a driver immediately shuts down all open connections.
        driver.close();
    }

    public static void main(String... args)
    {
        BigRequestNumberTest example = new BigRequestNumberTest("bolt://localhost:7687", "neo4j", "vuong220598");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1; i++)
        	example.addBatchver2(1000);
        System.out.println(System.currentTimeMillis() - start);
        example.close();
    }
}