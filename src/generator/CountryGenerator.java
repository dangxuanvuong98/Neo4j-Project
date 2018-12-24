package generator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import object.Country;

/**
 * Lớp tiện ích phục vụ sinh ngẫu nhiên các thành phần con/thực thể Country
 * 
 */
public abstract class CountryGenerator {
	private static Integer index;
	private static List<String> country_list;
	private static List<String> capital_list;
	private static List<String> des_element1_list;
	private static List<String> des_element2_list;
	private static List<String> des_element3_list;

	/**
	 * Đọc dữ liệu từ file,trích rút thông tin phục vụ cho quá trình sinh ngẫu
	 * nhiên
	 * 
	 * @param country_file
	 *            :đường dẫn tới file chứa danh sách các country
	 * @param capital_file
	 *            :đường dẫn tới file chứa danh sách các thành phố
	 * @param des_element1_file
	 *            :đường dẫn tới file chứa danh sách các phần tử 1 của
	 *            description
	 * @param des_element2_file
	 *            :đường dẫn tới file chứa danh sách các phần tử 2 của
	 *            description
	 * @param des_element3_file
	 *            :đường dẫn tới file chứa danh sách các phần tử 3 của
	 *            description
	 */
	public static void getData(String country_file, String capital_file,
			String des_element1_file, String des_element2_file,
			String des_element3_file) {
		index = 0;

		// Khởi tạo danh sách countries
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

		// Khởi tạo danh sách locations
		capital_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(capital_file), "UTF8"))) {
			String name;

			while ((name = reader.readLine()) != null) {
				capital_list.add(name);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + capital_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: " + capital_file);
			e.printStackTrace();
		}

		// Khởi tạo danh sách des_element1
		des_element1_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(des_element1_file), "UTF8"))) {
			String name;

			while ((name = reader.readLine()) != null) {
				des_element1_list.add(name);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + des_element1_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: "
					+ des_element1_file);
			e.printStackTrace();
		}

		// Khởi tạo danh sách des_element2
		des_element2_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(des_element2_file), "UTF8"))) {
			String name;

			while ((name = reader.readLine()) != null) {
				des_element2_list.add(name);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + des_element2_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: "
					+ des_element2_file);
			e.printStackTrace();
		}

		// Khởi tạo danh sách des_element3
		des_element3_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(des_element3_file), "UTF8"))) {
			String name;

			while ((name = reader.readLine()) != null) {
				des_element3_list.add(name);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + des_element3_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: "
					+ des_element3_file);
			e.printStackTrace();
		}
	}

	/**
	 * @return id của thực thể Country mới
	 */
	public static String randomId() {
		Integer index = getIndex();
		String id = "Country" + index;
		incIndex();
		return id;
	}

	/**
	 * @return tên Country ngẫu nhiên
	 */
	public static String randomName() {
		if (country_list.isEmpty())
			return "";
		int random_num = (int) (Math.random() * country_list.size());
		return country_list.get(random_num);
	}

	/**
	 * 
	 * @return tên một thành phố ngẫu nhiên
	 */
	public static String randomCapital() {
		if (capital_list.isEmpty())
			return "";
		int random_num = (int) (Math.random() * capital_list.size());
		return capital_list.get(random_num);
	}

	/**
	 * 
	 * @return một description ngẫu nhiên
	 */
	public static String randomDescription() {
		if (des_element1_list.isEmpty() || des_element2_list.isEmpty()
				|| des_element3_list.isEmpty())
			return "";
		int rand1 = (int) (Math.random() * des_element1_list.size());
		int rand2 = (int) (Math.random() * des_element2_list.size());
		int rand3 = (int) (Math.random() * des_element3_list.size());
		return "Là một " + des_element1_list.get(rand1) + " thuộc khu vực "
				+ des_element2_list.get(rand2) + " "
				+ des_element3_list.get(rand3);
	}

	/**
	 * 
	 * @return 1 object Country với các thuộc tính được sinh ngẫu nhiên
	 */
	public static Country generateCountry() {
		Country country = new Country();
		country.setId(randomId());
		country.setName(randomName());
		country.setDescription(randomDescription());
		country.setCapital(randomCapital());
		return country;
	}

	public static Integer getIndex() {
		return index;
	}

	private static void incIndex() {
		index = index + 1;
	}
}