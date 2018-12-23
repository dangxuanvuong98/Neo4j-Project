package database;

import org.neo4j.driver.v1.*;

/*
 * Lớp thực hiện việc kết nối với cơ sở dữ liệu
 */
public class Connector {
	Driver driver;

	/*
	 * Khởi tạo kết nối đến cơ sở dữ liệu
	 */
	public Connector(String uri, String user, String password) {
		driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
	}

	/*
	 * Thực hiện một truy vấn
	 */
	public void query(Model query) {
		try (Session session = driver.session()) {
			try (Transaction tx = session.beginTransaction()) {
				tx.run(query.getModel().toString());
				tx.success();
			}
		}
	}

	public void close() {
		driver.close();
	}
}