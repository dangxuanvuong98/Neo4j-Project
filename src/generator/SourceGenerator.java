package generator;

import java.util.Date;
import java.util.GregorianCalendar;

import object.Source;

public class SourceGenerator {
	
	private static String[] link_list = {"bit.ly", "goo.gl"};
	
	public static void getData(String link_file) {
		
	}
	
	public static Date randomDate() {
		int random_year = 1980 + (int) (Math.random() * 40);
		int random_month = 1 + (int) (Math.random() * 12);
		int random_day;
		if (random_month == 2) {
			if ((random_year % 4 == 0 && random_year % 100 != 0) || (random_year % 400 == 0)) {
				random_day = 1 + (int) (Math.random() * 29);
			}
			else {
				random_day = 1 + (int) (Math.random() * 28);
			}
		}
		else if ((random_month <= 7 && random_month % 2 == 1) || (random_month >= 8 && random_month % 2 == 0)){
			random_day = 1 + (int) (Math.random() * 31);
		}
		else {
			random_day = 1 + (int) (Math.random() * 30);
		}
		return (Date) new GregorianCalendar(random_year, random_month, random_day).getTime();
	}
	
	public static String randomLink() {
		if (link_list.length == 0) {
			return "localhost";
		}
		int random_num = (int) (Math.random() * link_list.length);
		return link_list[random_num] = "/" + Integer.toString((int) (Math.random() * 1000000));
	}
	
	public static Source generateSource() {
		Source source = new Source();
		source.setDate(randomDate());
		source.setLink(randomLink());
		return source;
	}
}
