package generator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import object.Time;

/**
 * Lớp sinh ngẫu nhiên các thực thể Time
 * 
 */
public class TimeGenerator {
	private static Integer index;
	static List<String> special_day_list;

	/**
	 * Đọc dữ liệu từ file,trích rút và lưu trữ thông tin phục vụ sinh ngẫu
	 * nhiên
	 * 
	 * @param special_day_file
	 *            đường dẫn tới file chứa danh sách các ngày đặc biệt trong năm
	 */
	public static void getData(String special_day_file) {
		index = 0;
		
		// Initialize list of times
		special_day_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(special_day_file), "UTF8"))) {
			String name;

			while ((name = reader.readLine()) != null) {
				special_day_list.add(name);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + special_day_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: " + special_day_file);
			e.printStackTrace();
		}
	}
	
	public static String randomId() {
		Integer index = getIndex();
		String id = "Time" + index;
		incIndex();
		return id;
	}
	
	public static String randomName() {
		int random_year=1980+(int)(Math.random()*40);
		int random_type=(int)(Math.random()*4);
    	if(special_day_list.isEmpty()) random_type=1;
    	if(random_type==0) {
    		int random_day=(int)(Math.random()*special_day_list.size());
    		return special_day_list.get(random_day)+" năm "+random_year;
    	}
    	else {
    		int random_day=1+(int)(Math.random()*28);
    		int random_month=1+(int)(Math.random()*12);
    		return "ngày "+random_day+" tháng "+random_month+" năm "+random_year;
    	}
	}
	
	public static String randomDescription() {
		return "Là một ngày đặc biệt";
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
		time.setSource(SourceGenerator.generateSource());
		return time;
	}

	public static Integer getIndex() {
		return index;
	}
	
	private static void incIndex() {
		index = index + 1;
	}
}