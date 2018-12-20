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
	private static Integer index = 0;
	private static List<String> country_list;
	private static List<String> capital_list;
	private static String[] element1 = { "cường quốc",
			"quốc gia đang phát triển", "quốc gia phát triển",
			"đất nước tươi đẹp", "đất nước nhỏ", "đất nước lớn",
			"tiểu vương quốc", "vương quốc", "quốc đảo" };
	private static String[] element2 = { "trung tâm", "phía Đông", "phía Tây",
			"phía Nam", "phía Bắc", "Đông Bắc", "Đông Nam", "Tây Bắc",
			"Tây Nam" };
	private static String[] element3 = { "Châu Á", "Châu Âu", "Châu Phi",
			"Châu Mỹ", "Châu Úc" };

	/**
	 * Đọc dữ liệu từ file,trích rút và lưu lại để phục vụ việc sinh ngẫu nhiên
	 * 
	 * @param country_file
	 *            đường dẫn tới file chứa tên các country
	 * @param capital_file
	 *            đường dẫn tới file chứa tên các thành phố
	 */
	public static void getData(String country_file, String capital_file) {
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
	}

	/**
	 * @return id của thực thể Country mới
	 */
	public static String randomId() {
		Integer index = getIndex();
		return "Country" + index;
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
		int rand1 = (int) (Math.random() * element1.length);
		int rand2 = (int) (Math.random() * element2.length);
		int rand3 = (int) (Math.random() * element3.length);
		return "Là một " + element1[rand1] + " thuộc khu vực "
				+ element2[rand2] + " " + element3[rand3];
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
}