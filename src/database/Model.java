package database;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import object.Country;
import object.Entity;
import object.Event;
import object.Location;
import object.Organization;
import object.Person;
import object.Relationship;
import object.Time;
import object.Source;

/**
 * Lớp Model dùng để lưu trữ các thực thể và quan hệ trước khi đưa lên cơ sở dữ liệu
 * @author vuong
 *
 */
public class Model {
	private static String entityAnnotationPattern = "CREATE (:{label}{{attributes}})\n";
	private static String relationshipAnnotationPattern = "MATCH (a), (b)\n"
			+ "WHERE a.id = {entId1} and b.id = {endId2}\n"
			+ "CREATE (a)-[r:{attributes}]->(b)\n";
	private static String attributeAnnotationPattern = "{fieldname}: {fieldvalue}";
	
	private ArrayList<Object> model = new ArrayList<Object>();

	public Model() {
		this.model = new ArrayList<Object>();
	}

	/**
	 * Thêm một thực thể/ quan hệ vào model
	 * @param object đối tượng cần thêm vào model
	 */
	public void add(Object object) {
		model.add(object);
	}

	
	/**
	 * Xoá toàn bộ thực thể trong model
	 */
	public void clear() {
		this.model = new ArrayList<Object>();
	}

	/**
	 * Chuyển giá trị của một trường thành chuỗi ký tự tương ứng trong Cypher
	 * @param fieldValue Giá trị cần chuyển đổi
	 * @return Chuỗi ký tự tương ứng trong Cypher
	 */
	private String fieldValueToAnnotation(Object fieldValue) {
		String fieldValueAnnotation;
		if (fieldValue instanceof Integer || fieldValue instanceof Double) {
			fieldValueAnnotation = fieldValue.toString();
		} else if (fieldValue instanceof Source) {
			Source source = (Source) fieldValue;
			fieldValueAnnotation = "\"{link: " + source.getLink() + ", date: "
					+ source.getDate().toString();
		} else if (fieldValue instanceof Time) {
			fieldValueAnnotation = "\"date(" + (new SimpleDateFormat("yyyy-mm-dd")).format(fieldValue) + ")\"";
		}
		else {
			fieldValueAnnotation = "\"" + fieldValue.toString() + "\"";
		}
		return fieldValueAnnotation;
	}

	/**
	 * Chuyển đổi một thực thể thành chuỗi ký tự tương ứng trong Cypher
	 * @param ent Thực thể cần chuyển đổi
	 * @return Chuỗi ký tự tương ứng trong Cypher
	 */
	private String entityAnnotation(Entity ent) {
		String label = "";
		if (ent instanceof Country) {
			label = "Country";
			ent = (Country) ent;
		} else if (ent instanceof Event) {
			label = "Event";
			ent = (Event) ent;
		} else if (ent instanceof Location) {
			label = "Location";
			ent = (Location) ent;
		} else if (ent instanceof Organization) {
			label = "Organization";
			ent = (Organization) ent;
		} else if (ent instanceof Person) {
			label = "Person";
			ent = (Person) ent;
		} else if (ent instanceof Time) {
			label = "Time";
			ent = (Time) ent;
		} else {
			return "";
		}
		ArrayList<String> fieldAnnotation = new ArrayList<String>();
		Class<?> entityClass = ent.getClass();
		ArrayList<Field> fields = new ArrayList<Field>(
				Arrays.asList(entityClass.getDeclaredFields()));
		fields.addAll(Arrays.asList(entityClass.getSuperclass()
				.getDeclaredFields()));
		for (Field field : fields) {
			String fieldName = field.getName();
			Object fieldValue = new Object();
			try {
				field.setAccessible(true);
				fieldValue = field.get(ent);
			} catch (IllegalArgumentException | IllegalAccessException
					| SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String fieldValueAnnotation = fieldValueToAnnotation(fieldValue);
			fieldAnnotation.add(attributeAnnotationPattern.replace(
					"{fieldname}", fieldName).replace("{fieldvalue}",
					fieldValueAnnotation));
		}
		return entityAnnotationPattern.replace("{label}", label).replace(
				"{attributes}", String.join(", ", fieldAnnotation));
	}

	/**
	 * Chuyển đổi một quan hệ thành chuỗi ký tự tương ứng trong Cypher
	 * @param rela Quan hệ cần chuyển đổi
	 * @return Chuỗi ký tự tương ứng trong Cypher
	 */
	private String relationshipAnnotation(Relationship rela) {
		ArrayList<String> fieldAnnotation = new ArrayList<String>();
		Class<?> relationshipClass = rela.getClass();
		Field[] fields = relationshipClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();
			if (fieldName == "en_id1" || fieldName == "en_id2") {
				continue;
			}
			Object fieldValue = "";
			try {
				Field field = relationshipClass.getDeclaredField(fieldName);
				field.setAccessible(true);
				fieldValue = field.get(rela);
			} catch (IllegalArgumentException | IllegalAccessException
					| NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
			String fieldValueAnnotation = fieldValueToAnnotation(fieldValue);
			fieldAnnotation.add(attributeAnnotationPattern.replace(
					"{fieldname}", fieldName).replace("{fieldvalue",
					fieldValueAnnotation));
		}
		return relationshipAnnotationPattern.replace("{entId1}", "")
				.replace("{entId2}", "")
				.replace("{attributes}", String.join(", ", fieldAnnotation));
	}

	/**
	 * Chuyển đổi một đối tượng bất kỳ sang chuỗi ký tự tương ứng trong Cypher
	 * @param obj Đối tượng cần chuyển đổi
	 * @return Chuỗi ký tự tương ứng trong Cypher
	 */
	private String annotation(Object obj) {
		if (obj instanceof Entity) {
			return entityAnnotation((Entity) obj);
		} else if (obj instanceof Relationship) {
			return relationshipAnnotation((Relationship) obj);
		} else {
			return "";
		}
	}

	/**
	 * Chuyển đổi model thành chuỗi ký tự tương ứng trong Cypher
	 * @return StringBuilder chứa chuỗi ký tự tương ứng trong Cypher
	 */
	public StringBuilder getModel() {
		StringBuilder modelString = new StringBuilder();
		for (Object obj : model) {
			modelString.append(annotation(obj));
		}
		return modelString;
	}
}
