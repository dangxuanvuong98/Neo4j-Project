import generator.*;
import object.*;

public class Main {

	public static void main(String[] args) {
		CountryGenerator.getData("data/countries", "data/locations");
		TimeGenerator.getData("data/times");
		RelationshipGenerator.getData("data/relationships");
		LocationGenerator.getData("data/locations", "data/countries");
		
		
		for(int i=0;i<1000000;i++) {
			Country country=CountryGenerator.generateCountry(); 
			Time time=TimeGenerator.generateTime();
			Location location=LocationGenerator.generateLocation();
			//System.out.println(country);
			//System.out.println(time);
		}
		
		for(int i=0;i<2000000;i++) {
			System.out.println(RelationshipGenerator.generateRelationship());
		}

	}

}
