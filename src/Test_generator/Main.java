

import generator.*;
import object.*;

public class Main {

	public static void main(String[] args) {
		SourceGenerator.getData("rawdata/Source/domain_list");
		PersonGenerator.getData("rawdata/Person/firstname_list", 
								"rawdata/Person/midname_list", 
								"rawdata/Person/lastname_list",
								"rawdata/Person/job_list",
								"rawdata/Person/des_element_list");
		OrganizationGenerator.getData("rawdata/Organization/organization_name_list",
									  "rawdata/Organization/headquarters_list",
									  "rawdata/Organization/firstname_list",
									  "rawdata/Organization/midname_list", 
									  "rawdata/Organization/lastname_list",
									  "rawdata/Organization/email_domain_list",
									  "rawdata/Organization/des_element1_list",
									  "rawdata/Organization/des_element2_list",
									  "rawdata/Organization/country_list");
		CountryGenerator.getData("rawdata/Country/country_list",
								 "rawdata/Country/capital_list", 
								 "rawdata/Country/des_element1_list",
								 "rawdata/Country/des_element2_list",
								 "rawdata/Country/des_element3_list");
		LocationGenerator.getData("rawdata/Location/location_list",
								  "rawdata/Location/country_list",
								  "rawdata/Location/des_element_list");
		EventGenerator.getData("rawdata/Event/venue_list",
							   "rawdata/Event/country_list",
							   "rawdata/Event/festival_name_list",
							   "rawdata/Event/product_name_list");
		TimeGenerator.getData("rawdata/Time/special_day_list");
		RelationshipGenerator.getData("rawdata/Relationship");
		
	
	for(int i=0;i<10000;i++) {
			Country country=CountryGenerator.generateCountry();
			Event event=EventGenerator.generateEvent();
			Location location=LocationGenerator.generateLocation();
			Organization organization=OrganizationGenerator.generateOrganization();
			Person person=PersonGenerator.generatePerson();
			Time time=TimeGenerator.generateTime();
			
			//System.out.println(time);
			//System.out.println(time);
		}
		
		for(int i=0;i<20000;i++) {
			Relationship relationship=RelationshipGenerator.generateRelationship();
			System.out.println(relationship);
		}

		System.out.println("OK!");
	}
}
