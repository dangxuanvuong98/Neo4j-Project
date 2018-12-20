package generator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import object.Event;

public class EventGenerator {
	private static Integer index;
	private static List<String> event_list;
	private static List<String> venue_list;

	/**
	 * Đọc vào các tên các sự kiện được chuẩn bị sẵn
	 * 
	 * @param event_file
	 *            Đường dẫn đến file chứa tên các sự kiện
	 * @param venue_file
	 *            Đường dẫn đến file chứa tên các địa điểm tổ chức sự kiện
	 */
	public static void getData(String event_file, String venue_file) {
		index = 0;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(event_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				event_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + event_list);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: " + event_list);
			e.printStackTrace();
		}

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(event_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				event_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + event_list);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: " + event_list);
			e.printStackTrace();
		}
	}

	/**
	 * Sinh ra id cho thực thể Event mới
	 * @return
	 */
	public static String randomId() {
		Integer index = getIndex();
		return "Event" + index;
	}

	/**
	 * Sinh ngẫu nhiên tên cho event
	 * @return
	 */
	public static String randomName() {
		if (event_list.isEmpty())
			return "";
		int random_num = (int) (Math.random() * event_list.size());
		return event_list.get(random_num);
	}

	/** 
	 * Sinh ngẫu nhiên mô tả cho sự kiện
	 * @return
	 */
	public static String randomDescription() {
		return "là một sự kiện";
	}

	/**
	 * Sinh ngẫu nhiên thời gian bắt đầu
	 * @return
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
	 * Sinh ngẫu nhiên thời gian kết thúc
	 * @return
	 */
	public static Date randomTimeEnd(Date date_start) {
		return new Date(date_start.getTime() + ((long) (Math.random() * 60 * 86400000)));
	}

	/**
	 * Sinh ngẫu nhiên một địa điểm tổ chức
	 * @return
	 */
	public static String randomVenue() {
		if (event_list.isEmpty())
			return "";
		int random_num = (int) (Math.random() * event_list.size());
		return venue_list.get(random_num);
	}
	
	/**
	 * Sinh ngẫu nhiên một sự kiện
	 * @return
	 */
	public static Event generateEvent(){
		Event event = new Event();
		event.setId(randomId());
		event.setName(randomName());
		event.setDescription(randomDescription());
		event.setTimeStart(randomTimeStart());
		event.setTimeEnd(randomTimeEnd(event.getTimeStart()));
		event.setVenue(randomVenue());
		return event;
	}

	public static Integer getIndex() {
		return index;
	}
}
