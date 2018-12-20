import generator.CountryGenerator;
import generator.EventGenerator;
import generator.LocationGenerator;
import generator.OrganizationGenerator;
import generator.PersonGenerator;
import generator.RelationshipGenerator;
import generator.SourceGenerator;
import generator.TimeGenerator;
import database.Connector;

public class Main {
	
	private static Connector connector;
	
	private static void initApp() {
		connector = new Connector("bolt://localhost:7687", "neo4j", "vuong220598");
		CountryGenerator.getData("", "");
		EventGenerator.getData("", "");
		LocationGenerator.getData("", "");
		OrganizationGenerator.getData("", "", "", "", "");
		PersonGenerator.getData("", "", "", "");
		RelationshipGenerator.getData("");
		TimeGenerator.getData("");
		SourceGenerator.getData("");
	}
	
	public static void main(String args[]) {
		initApp();
	}
}
