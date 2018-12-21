package generator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import object.Source;

public class SourceGenerator {
	
	private static List<String> domain_list;
	
	/**
	 * 
	 * @param domain_file đường dẫn tới file chứa danh sách các domain
	 */
	public static void getData(String domain_file) {
				// Đọc danh sách domain
				domain_list = new ArrayList<String>();
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(domain_file), "UTF8"))) {
					String name;
					while ((name = reader.readLine()) != null) {
						domain_list.add(name);
					}
				} catch (FileNotFoundException e) {
					System.out.println("Error: Missing filename: " + domain_file);
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Error: Fail to read filename: "
							+ domain_file);
					e.printStackTrace();
				}
	}
	
	/**
	 * 
	 * @return một ngày/tháng/năm được sinh ngẫu nhiên
	 */
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
		if (domain_list.isEmpty()) {
			return "localhost";
		}
		int random_num = (int) (Math.random() * domain_list.size());
		return domain_list.get(random_num) + "/" + Integer.toString((int) (Math.random() * 1000000))+"/"+Integer.toString((int) (Math.random() * 1000000))+".html";
	}
	
	/**
	 * 
	 * @return thực thể Source sinh ngẫu nhiên
	 */
	public static Source generateSource() {
		Source source = new Source();
		source.setDate(randomDate());
		source.setLink(randomLink());
		return source;
	}
}
