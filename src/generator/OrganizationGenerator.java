package generator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import object.Organization;

public class OrganizationGenerator {
	private static Integer index;
	private static List<String> organization_list;
	private static List<String> headquarters_list;
	private static List<String> firstname_list;
	private static List<String> midname_list;
	private static List<String> lastname_list;
	private static List<String> email_domain_list;
	private static List<String> des_element1_list;
	private static List<String> des_element2_list;
	private static List<String> country_list;

	/**
	 * 
	 * @param organization_file
	 *            :đường dẫn tới file chứa tên các tổ chức
	 * @param headquarters_file
	 *            :đường dẫn tới file chứa tên các trụ sở
	 * @param firstname_file
	 *            :đường dẫn tới file chứa danh sách first name
	 * @param midname_file
	 *            :đường dẫn tới file chứa danh sách mid name
	 * @param lastname_file
	 *            :đường dẫn tới file chứa danh sách last name
	 * @param email_domain_file
	 *            :đường dẫn tới file chứa danh sách các email domain
	 * @param des_element_file
	 *            :đường dẫn tới file chứa danh sách phần tử phù hợp để sinh
	 *            description
	 * @param country_file
	 *            :đường dẫn tới file chứa danh sách các quốc gia
	 */
	public static void getData(String organization_file,
			String headquarters_file, String firstname_file,
			String midname_file, String lastname_file,
			String email_domain_file, String des_element1_file,
			String des_element2_file, String country_file) {
		index = 0;

		// Đọc tên tổ chức
		organization_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(organization_file), "UTF8"))) {
			String name;

			while ((name = reader.readLine()) != null) {
				organization_list.add(name);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + organization_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: "
					+ organization_file);
			e.printStackTrace();
		}

		// Đọc địa điểm
		headquarters_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(headquarters_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				headquarters_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + headquarters_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: "
					+ headquarters_file);
			e.printStackTrace();
		}

		// Đọc danh sách tên
		firstname_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(firstname_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				firstname_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + firstname_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: "
					+ firstname_file);
			e.printStackTrace();
		}

		// Đọc danh sách tên đệm
		midname_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(midname_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				midname_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + midname_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: " + midname_file);
			e.printStackTrace();
		}

		// Đọc danh sách họ
		lastname_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(lastname_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				lastname_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + lastname_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out
					.println("Error: Fail to read filename: " + lastname_file);
			e.printStackTrace();
		}

		// Đọc danh sách email doamain
		email_domain_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(email_domain_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				email_domain_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + email_domain_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: "
					+ email_domain_file);
			e.printStackTrace();
		}

		// Đọc danh sách phần tử 1 phục vụ sinh mô tả phù hợp
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

		// Đọc danh sách phần tử 2 phục vụ sinh mô tả phù hợp
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

		// Đọc danh sách các đất nước
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
	}

	/**
	 * 
	 * @return id phù hợp cho thực thể Organization được tạo mới
	 */
	public static String randomId() {
		Integer index = getIndex();
		String id = "Organization" + index;
		incIndex();
		return id;
	}

	/**
	 * 
	 * @return tên tổ chức ngẫu nhiên phù hợp
	 */
	public static String randomName() {
		if (organization_list.isEmpty())
			return "";
		int random_num = (int) (Math.random() * organization_list.size());
		return organization_list.get(random_num);
	}

	/**
	 * 
	 * @return mô tả ngẫu nhiên phù hợp
	 */
	public static String randomDescription() {
		if (des_element1_list.isEmpty() || des_element2_list.isEmpty())
			return "là một tổ chức";
		int rand1 = (int) (Math.random() * des_element1_list.size());
		int rand2 = (int) (Math.random() * des_element2_list.size());

		return "là một " + des_element1_list.get(rand1) + " "
				+ des_element2_list.get(rand2) + " trên thế giới";
	}

	/**
	 * 
	 * @return một trụ sở chính phù hợp
	 */
	public static String randomHeadquarters() {
		if (headquarters_list.isEmpty() || country_list.isEmpty())
			return "";
		int random_num1 = (int) (Math.random() * headquarters_list.size());
		int random_num2 = (int) (Math.random() * country_list.size());
		return headquarters_list.get(random_num1) + " city of "
				+ country_list.get(random_num2);
	}

	/**
	 * 
	 * @return số diện thoại ngẫu nhiên
	 */
	public static String randomPhone() {
		String phone = "";
		for (int i = 0; i < 10; i++) {
			phone += Integer.toString((int) (Math.random() * 10));
		}
		return phone;
	}

	/**
	 * 
	 * @param name
	 *            tên tổ chức
	 * @return email ngẫu nhiên phù hợp
	 */
	public static String randomEmail(String name) {
		if (email_domain_list.isEmpty())
			return "";
		int random_num = (int) (Math.random() * email_domain_list.size());
		return name.toLowerCase().replaceAll(" ", "")
				+ Integer.toString((int) (Math.random() * 1000)) + "@"
				+ email_domain_list.get(random_num);
	}

	/**
	 * 
	 * @return tên chủ tịch bất kì(tên người)
	 */
	public static String randomChairman() {
		if (lastname_list.isEmpty() && midname_list.isEmpty()
				&& firstname_list.isEmpty()) {
			return "";
		}
		String chairman = "";
		int random_num = (int) (Math.random() * lastname_list.size());
		chairman = lastname_list.get(random_num) + " ";
		random_num = (int) (Math.random() * midname_list.size());
		chairman = chairman + midname_list.get(random_num) + " ";
		random_num = (int) (Math.random() * firstname_list.size());
		chairman += firstname_list.get(random_num);
		return chairman;
	}

	/**
	 * 
	 * @return một thực thể Oganization với các thuộc tính ngẫu nhiên phù hợp
	 */
	public static Organization generateOrganization() {
		Organization organization = new Organization();
		organization.setId(randomId());
		organization.setName(randomName());
		organization.setDescription(randomDescription());
		organization.setChairman(randomChairman());
		organization.setHeadquarters(randomHeadquarters());
		organization.setPhone(randomPhone());
		organization.setEmail(randomEmail(organization.getName()));
		return organization;
	}

	public static Integer getIndex() {
		return index;
	}

	private static void incIndex() {
		index = index + 1;
	}
}
