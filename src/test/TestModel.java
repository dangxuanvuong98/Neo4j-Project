package test;
import object.*;

import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

import database.*;
public class TestModel {
	public static void main(String[] args) {
		BigRequestNumberTest example = new BigRequestNumberTest("bolt://localhost:7687", "neo4j", "vuong220598");
		long start = System.currentTimeMillis();
		for (int x = 0; x < 1000; x++) {
			Model m = new Model();
			for (int j = 0; j < 1000; j++) {
				int i = x*1000+j;
				Person p = new Person();
				p.setAge(20);
				p.setDescription("Giao su");
				p.setGender(true);
				p.setId("Person" + Integer.toString(i));
				p.setJob("Student");
				p.setName("Vuong" + Integer.toString(i));
				m.add(p);
			}
			long start2 = System.currentTimeMillis();
			try (Session session = example.driver.session())
	        {
	            try (Transaction tx = session.beginTransaction())
	            {
	                tx.run(m.getModel().toString());
	                tx.success();
	            }
	        }
			System.out.println("Thoi gian truy van:" + (System.currentTimeMillis() - start2));
		}
		example.close();
		System.out.println("Tong thoi gian truy van:" + (System.currentTimeMillis() - start));
	}
}
