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

import object.Event;

public class EventGenerator {
	private static Integer index;
	private static List<String> venue_list;
	private static List<String> country_list;
	private static List<String> festival_name_list;
	private static List<String> product_name_list;

	/**
	 * 
	 * @param venue_file đường dẫn tới danh sách địa điểm tổ chức
	 * @param countr_file đường dẫn tới danh sách các quốc gia
	 * @param festival_name_file đường dẫn tới danh sách tên các lễ hội
	 * @param product_name_file đường dẫn tới danh sách tên các sản phẩm
	 */
	public static void getData(String venue_file,String country_file,String festival_name_file,String product_name_file) {
		index = 0;
		
		//Khởi tạo danh sách địa điểm
		venue_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(venue_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				venue_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + venue_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: " + venue_file);
			e.printStackTrace();
		}
		//Khởi tạo danh sách các quốc gia
		country_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(country_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				country_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + country_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: " + country_file);
			e.printStackTrace();
		}
		
		//Khởi tạo danh sách tên các lễ hội
		festival_name_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(festival_name_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				festival_name_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + festival_name_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: " + festival_name_file);
			e.printStackTrace();
		}
		
		//Khởi tạo danh sách tên các sản phẩm
		product_name_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(product_name_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				product_name_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + product_name_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: " + product_name_file);
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return Sinh ra id cho thực thể Event mới
	 */
	public static String randomId() {
		Integer index = getIndex();
		String id = "Event" + index;
		incIndex();
		return id;
	}

	/**
	 * 
	 * @return Sinh ngẫu nhiên tên cho event
	 */
	public static String randomName() {
		if (festival_name_list.isEmpty()||product_name_list.isEmpty()) {
			return "";
		}
		int random_type = (int) (Math.random() * 5);
		if(random_type<=3) {
			int rand=(int)(Math.random()*festival_name_list.size());
			return "lễ hội "+festival_name_list.get(rand);
		}
		else {
			int rand1=(int)(Math.random()*product_name_list.size());
			char rand2=(char)(65+Math.random()*26);
			int rand3=(int)(Math.random()*11);
			return "Ra mắt "+product_name_list.get(rand1)+" "+Character.toString(rand2)+rand3;
		}
	}

	/** 
	 * 
	 * @return Sinh ngẫu nhiên mô tả cho sự kiện
	 */
	public static String randomDescription() {
		return "là một sự kiện thu hút đông đảo sự chú ý của cộng đồng";
	}

	/**
	 * 
	 * @return Sinh ngẫu nhiên thời gian bắt đầu
	 */
	public static Date randomTimeStart() {
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

	/**
	 * 
	 * @return Sinh ngẫu nhiên thời gian kết thúc
	 */
	public static Date randomTimeEnd(Date date_start) {
		return new Date(date_start.getTime() + ((long) (Math.random() * 60 * 86400000)));
	}

	/**
	 * 
	 * @return Sinh ngẫu nhiên một địa điểm tổ chức
	 */
	public static String randomVenue() {
		if (venue_list.isEmpty())
			return "";
		int random_num1 = (int) (Math.random() * venue_list.size());
		int random_num2 = (int) (Math.random() * country_list.size());
		return "thành phố "+venue_list.get(random_num1)+","+country_list.get(random_num2);
	}
	
	/**
	 * 
	 * @return Sinh ngẫu nhiên một sự kiện
	 */
	public static Event generateEvent(){
		Event event = new Event();
		event.setId(randomId());
		event.setName(randomName());
		event.setDescription(randomDescription());
		event.setSource(SourceGenerator.generateSource());
		event.setTimeStart(randomTimeStart());
		event.setTimeEnd(randomTimeEnd(event.getTimeStart()));
		event.setVenue(randomVenue());
		return event;
	}

	public static Integer getIndex() {
		return index;
	}
	
	private static void incIndex() {
		index = index + 1;
	}
}
