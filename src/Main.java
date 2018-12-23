import listener.Router;
import generator.CountryGenerator;
import generator.EventGenerator;
import generator.LocationGenerator;
import generator.OrganizationGenerator;
import generator.PersonGenerator;
import generator.RelationshipGenerator;
import generator.SourceGenerator;
import generator.TimeGenerator;
import database.Connector;

/*
 * Điểm bắt đầu của chương trình
 */
public class Main {

	private static Connector connector;

	/*
	 * Phương thức khởi tạo chương trình qua các bước Đọc dữ liệu (rawdata) Gọi
	 * method route trong lớp Router (chờ đợi yêu cầu của người dùng và điều
	 * hướng)
	 */
	public static void init() {
		connector = new Connector("bolt://localhost:7687", "neo4j",
				"vuong220598");
		CountryGenerator.getData("rawdata/Country/country_list",
				"rawdata/Country/capital_list",
				"rawdata/Country/des_element1_list",
				"rawdata/Country/des_element2_list",
				"rawdata/Country/des_element3_list");
		EventGenerator.getData("rawdata/Event/venue_list",
				"rawdata/Event/country_list",
				"rawdata/Event/festival_name_list",
				"rawdata/Event/product_name_list");
		LocationGenerator.getData("rawdata/Location/location_list",
				"rawdata/Location/country_list",
				"rawdata/Location/des_element_list");
		OrganizationGenerator.getData(
				"rawdata/Organization/organization_name_list",
				"rawdata/Organization/headquarters_list",
				"rawdata/Organization/firstname_list",
				"rawdata/Organization/midname_list",
				"rawdata/Organization/lastname_list",
				"rawdata/Organization/email_domain_list",
				"rawdata/Organization/des_element1_list",
				"rawdata/Organization/des_element2_list",
				"rawdata/Organization/country_list");
		PersonGenerator.getData("rawdata/Person/firstname_list",
				"rawdata/Person/midname_list", "rawdata/Person/lastname_list",
				"rawdata/Person/job_list", "rawdata/Person/des_element_list");
		RelationshipGenerator.getData("rawdata/Relationship");
		TimeGenerator.getData("rawdata/Time/special_day_list");
		SourceGenerator.getData("rawdata/Source/domain_list");
		Router.route(connector);
	}

	public static void main(String args[]) {
		init();
	}
}
