package generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import object.Time;

/**
 * Lớp sinh ngẫu nhiên các thực thể Time
 * 
 */
public class TimeGenerator {
	private static Integer index = 0;
	static List<String> special_day_list;

	/**
	 * Đọc dữ liệu từ file,trích rút và lưu trữ thông tin phục vụ sinh ngẫu
	 * nhiên
	 * 
	 * @param filename
	 *            đường dẫn tới file chứa danh sách các ngày đặc biệt trong năm
	 */
	public static void getData(String filename) {
		// Initialize list of times
		special_day_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(
				new FileReader(filename))) {
			String name;

			while ((name = reader.readLine()) != null) {
				special_day_list.add(name);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + filename);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: " + filename);
			e.printStackTrace();
		}
	}
	
	public static String randomId() {
		return "Time" + getIndex();
	}
	
	public static String randomName() {
		if (special_day_list.isEmpty()) {
			return "";
		}
		int random_num = (int) (Math.random() * special_day_list.size());
		return special_day_list.get(random_num);
	}
	
	public static String randomDescription() {
		return "Là một ngày lễ";
	}

	/**
	 * 
	 * @return một object Time với các thuộc tính ngẫu nhiên
	 */
	public static Time generateTime() {
		Time time = new Time();
		time.setDescription(randomDescription());
		time.setId(randomId());
		time.setName(randomName());
		return time;
	}

	public static Integer getIndex() {
		return index;
	}
}