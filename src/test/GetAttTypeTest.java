package test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAttTypeTest {
	public String ahihi = "Vuong";
	protected String bhihi = "Dang";
	private String chihi = "Xuan";
	public String getFields() {
	    Class<? extends GetAttTypeTest> componentClass = getClass();
//	    return(componentClass.getName());
	    Field[] fields = componentClass.getDeclaredFields();
	    
	    String fieldName = fields[0].getName();
		try {
			Field field = componentClass.getField(fieldName);
			System.out.println(field.get(this));
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return "";
//	    lines.toArray(new String[lines.size()]);
	}
}
