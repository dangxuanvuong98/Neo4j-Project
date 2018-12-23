package listener;

import java.util.Scanner;

import database.Connector;
import database.Model;
import generator.*;

public class Router {

	private static Connector connector;

	private static void create(int E, int R) {
		for (int i = 0; i < E / 1000; i++) {
			Model model = new Model();
			for (int j = 0; j < 1000; j++) {
				if (i * 1000 + j == E) {
					break;
				}
				int random_num = (int) (Math.random() * 6);
				switch (random_num) {
				case 0:
					model.add(PersonGenerator.generatePerson());
					continue;
				case 1:
					model.add(OrganizationGenerator.generateOrganization());
					continue;
				case 2:
					model.add(EventGenerator.generateEvent());
					continue;
				case 3:
					model.add(LocationGenerator.generateLocation());
					continue;
				case 4:
					model.add(TimeGenerator.generateTime());
					continue;
				case 5:
					model.add(CountryGenerator.generateCountry());
					continue;
				default:
					continue;
				}
			}
			connector.query(model);
		}
		// System.out.println(CountryGenerator.getIndex());
		for (int i = 0; i < R; i++) {
			Model model = new Model();
			for (int j = 0; j < 1; j++) {
				if (i * 1000 + j == R) {
					break;
				}
				model.add(RelationshipGenerator.generateRelationship());
			}
			connector.query(model);
		}
		System.out.println("Đã tạo " + E + " thực thể và " + R + " quan hệ!");
	}

	public static void route(Connector connector) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (true) {
			Router.connector = connector;
			int i = sc.nextInt();
			if (i == 0) {
				int E = sc.nextInt();
				int R = sc.nextInt();
				create(E, R);
			} else {
				continue;
			}
		}
	}
}
