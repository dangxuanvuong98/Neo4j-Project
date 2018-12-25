package generator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import object.*;

/**
 * Lớp tiện ích phục vụ việc sinh ngẫu nhiên các quan hệ
 * 
 */
public class RelationshipGenerator {
	static Integer[][] index = new Integer[6][6];
	static List<String>[][] relationship_list;

	/**
	 * Đọc dữ liêụ từ các file,trích rút và lưu trữ phục vụ việc sinh ngẫu nhiên
	 * 
	 * @param folder_path
	 *            đường dẫn tới thư mục chứa các danh sách phục vụ sinh quan hệ
	 */
	@SuppressWarnings("unchecked")
	public static void readData(String folder_path) {
		/*
		 * Khởi tạo mảng 6*6 các String list Mỗi String list lưu trữ danh sách
		 * quan hệ giữa 2 loại thực thể với nhau Có 6 loại thực thể,type_index
		 * ứng với từng loại cụ thể như sau: #Person:0 #Oganization:1 #Country:2
		 * #Location:3 #Event:4 #Time:5 Ví dụ:List<String>[1][4] là danh sách
		 * quan hệ phù hợp giữa 1 Oganization(type_index=1) với một
		 * Event(type_index=4)
		 */
		relationship_list = new List[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				index[i][j] = 0;
				relationship_list[i][j] = new ArrayList<String>();
				try (BufferedReader reader = new BufferedReader(
						new InputStreamReader(new FileInputStream(folder_path
								+ "/" + i + j), "UTF8"))) {
					String name;
					while ((name = reader.readLine()) != null) {
						relationship_list[i][j].add(name);
					}
				} catch (FileNotFoundException e) {
					System.out.println("Error: Missing filename: "
							+ folder_path + "/" + i + j);
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Error: Fail to read filename: "
							+ folder_path + "/" + i + j);
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Ngẫu nhiên sinh 1 id của 1 thực thể có type_index chỉ định
	 * 
	 * @param type_index
	 * @return một id ngẫu nhiên của 1 thực thể có type_index chỉ định
	 */
	private static String randomIdByType(int type_index) {
		try {
			switch (type_index) {
			case 0:
				return "Person"
						+ (int) (Math.random() * PersonGenerator.getIndex());
			case 1:
				return "Oganization"
						+ (int) (Math.random() * OrganizationGenerator
								.getIndex());
			case 2:
				return "Country"
						+ (int) (Math.random() * CountryGenerator.getIndex());
			case 3:
				return "Location"
						+ (int) (Math.random() * LocationGenerator.getIndex());
			case 4:
				return "Event"
						+ (int) (Math.random() * EventGenerator.getIndex());
			case 5:
				return "Time"
						+ (int) (Math.random() * TimeGenerator.getIndex());
			default:
				return "Entity";
			}
		} catch (IllegalArgumentException e) {
			return "Entity";
		}
	}

	/**
	 * Sinh ngẫu nhiên một Relationship. Xác xuất xuất hiện của từng loại quan
	 * hệ là khác nhau,cụ thể hơn: Các quan hệ Person-Person(0-0),
	 * Person-Oganization(0-1), Person-Location(0-3), Person-Event(0-4),
	 * Oganization-Oganization(1-1), Oganization-Event(1-4),
	 * Country-Country(2-2), Event-Time(4-5) xuất hiện với xác suât lớn hơn 1/9.
	 * Các loại quan hệ khác xuất hiên với xác suất 1/324
	 * 
	 * @return 1 object Relationship với các thuộc tính ngẫu nhiên
	 */
	public static Relationship generateRelationship() {
		int random_num = (int) (Math.random() * 9);
		int en_type_index1;
		int en_type_index2;

		switch (random_num) {
		case 0:
			en_type_index1 = 0;
			en_type_index2 = 0;
		case 1:
			en_type_index1 = 0;
			en_type_index2 = 1;
		case 2:
			en_type_index1 = 0;
			en_type_index2 = 3;
		case 3:
			en_type_index1 = 0;
			en_type_index2 = 4;
		case 4:
			en_type_index1 = 1;
			en_type_index2 = 1;
		case 5:
			en_type_index1 = 1;
			en_type_index2 = 4;
		case 6:
			en_type_index1 = 2;
			en_type_index2 = 2;
		case 7:
			en_type_index1 = 4;
			en_type_index2 = 5;
		default:
			en_type_index1 = (int) (Math.random() * 6);
			en_type_index2 = (int) (Math.random() * 6);
		}
		Relationship relationship = new Relationship();
		String type;
		if (relationship_list[en_type_index1][en_type_index2].isEmpty())
			type = "Label";
		else {
			int type_index = (int) (Math.random() * relationship_list[en_type_index1][en_type_index2]
					.size());
			type = relationship_list[en_type_index1][en_type_index2]
					.get(type_index);
		}
		relationship.setType(type);
		relationship.setEn_id1(randomIdByType(en_type_index1));
		relationship.setEn_id2(randomIdByType(en_type_index2));
		relationship.setSource(SourceGenerator.generateSource());
		return relationship;
	}

}