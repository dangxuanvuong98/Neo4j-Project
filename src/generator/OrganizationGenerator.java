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
	private static String[] email_domain = { "gmail.com", "outlook.com",
			"yahoo.com.vn", "sis.hust.edu.vn" };

	/**
	 * Đọc dữ liệu
	 * 
	 * @return
	 */
	public static void getData(String organization_file,
			String headquarters_file, String firstname_file,
			String midname_file, String lastname_file) {
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
			System.out.println("Error: Fail to read filename: "
					+ midname_file);
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
			System.out.println("Error: Fail to read filename: "
					+ lastname_file);
			e.printStackTrace();
		}
	}

	// id cho thực thể Organization mới
	public static String randomId() {
		Integer index = getIndex();
		String id = "Organization" + index;
		incIndex();
		return id;
	}

	public static String randomName() {
		if (organization_list.isEmpty())
			return "";
		int random_num = (int) (Math.random() * organization_list.size());
		return organization_list.get(random_num);
	}

	public static String randomDescription() {
		return "là một tổ chức";
	}

	public static String randomHeadquarters() {
		if (headquarters_list.isEmpty())
			return "";
		int random_num = (int) (Math.random() * headquarters_list.size());
		return headquarters_list.get(random_num);
	}

	public static String randomPhone() {
		String phone = "";
		for (int i = 0; i < 10; i++) {
			phone += Integer.toString((int) (Math.random() * 10));
		}
		return phone;
	}

	public static String randomEmail(String name) {
		int random_num = (int) (Math.random() * email_domain.length);
		return name.toLowerCase()
				+ Integer.toString((int) (Math.random() * 1000)) + "@"
				+ email_domain[random_num];
	}
	
	public static String randomChairman() {
		if (lastname_list.isEmpty() && midname_list.isEmpty()
				&& firstname_list.isEmpty()) {
			return "";
		}
		String chairman = "";
		int random_num = (int) (Math.random() * lastname_list.size());
		chairman += lastname_list.get(random_num);
		random_num = (int) (Math.random() * midname_list.size());
		chairman += midname_list.get(random_num);
		random_num = (int) (Math.random() * firstname_list.size());
		chairman += firstname_list.get(random_num);
		return chairman;
	}

	public static Organization generateOrganization() {
		Organization organization = new Organization();
		organization.setChairman(randomChairman());
		organization.setDescription(randomDescription());
		organization.setHeadquarters(randomHeadquarters());
		organization.setId(randomId());
		organization.setName(randomName());
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
