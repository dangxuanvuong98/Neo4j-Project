package listener;

import java.util.Scanner;

import database.Connector;
import database.Model;
import generator.*;

public class Router {
	
	private static Connector connector;
	
	private static void create(int E, int R) {
		for (int i = 0; i < E / 1000 + 1; i++) {
			Model model = new Model();
			for (int j = 0; j < 1000; j++) {
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
				case 4:
					model.add(TimeGenerator.generateTime());
				case 5:
					model.add(CountryGenerator.generateCountry());
				}		
			}
			connector.query(model);
		}
	}
	
	public static void route(Connector connector) {
		while (true) {
			Router.connector = connector;
			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
			if (i == 0) {
				int E = sc.nextInt();
				int R = sc.nextInt();
				create(E, R);
			}
			else {
				continue;
			}
			sc.close();
		}
	}
}
