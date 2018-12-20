package generator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import object.Person;

public class PersonGenerator {
	private static Integer index;
	private static List<String> firstname_list;
	private static List<String> midname_list;
	private static List<String> lastname_list;
	private static List<String> job_list;

	public static void getData(String firstname_file, String midname_file,
			String lastname_file, String job_file) {
		index = 0;

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

		// Đọc danh sách nghề nghiệp
		job_list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(job_file), "UTF8"))) {
			String name;
			while ((name = reader.readLine()) != null) {
				job_list.add(name);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: " + job_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: " + job_file);
			e.printStackTrace();
		}
	}

	public String randomId() {
		return "Person" + getIndex();
	}

	public String randomName() {
		if (lastname_list.isEmpty() && midname_list.isEmpty()
				&& firstname_list.isEmpty()) {
			return "";
		}
		String name = "";
		int random_num = (int) (Math.random() * lastname_list.size());
		name += lastname_list.get(random_num);
		random_num = (int) (Math.random() * midname_list.size());
		name += midname_list.get(random_num);
		random_num = (int) (Math.random() * firstname_list.size());
		name += firstname_list.get(random_num);
		return name;
	}

	public String randomDescription() {
		return "Là một người nổi tiếng";
	}

	public Integer randomAge() {
		return 10 + (int) (Math.random() * 50);
	}

	public Boolean randomGender() {
		if (Math.random() >= 0.5) {
			return true;
		} else {
			return false;
		}
	}

	public String randomJob() {
		if (job_list.isEmpty()) {
			return "";
		}
		int random_num = (int) (Math.random() * job_list.size());
		return job_list.get(random_num);
	}
	
	public Person generatePerson() {
		Person person = new Person();
		person.setAge(randomAge());
		person.setDescription(randomDescription());
		person.setGender(randomGender());
		person.setId(randomId());
		person.setJob(randomJob());
		person.setName(randomName());
		return person;
	}

	public static Integer getIndex() {
		return index;
	}
}
