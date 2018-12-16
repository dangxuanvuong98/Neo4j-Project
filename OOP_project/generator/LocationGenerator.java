package generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import object.Location;

/**
 * Lớp tiện ích phục vụ sinh ngẫu nhiên thành phần con/thực thể Location
 *
 */
public class LocationGenerator{
	static List<String> location_list;
	static List<String> country_list;
	static String[] element= {"bãi biển","vùng vịnh","hòn đảo","bãi tắm","khu nghỉ dưỡng","khu sinh thái",
			"hang động","khu di tích","danh lam thắng cảnh","địa danh","vùng vịnh","một thành phố",
			"trung tâm giải trí","trung tâm thương mại","thành phố"};
	/**
	 * Đọc dữ liệu từ file,trích rút và lưu lại làm thông tin phục vụ sinh ngẫu nhiên
	 * @param location_file đường dẫn tới file chưa tên các địa danh
	 * @param country_file đường dẫn tới file chứa tên các đất nước
	 */
	public static void getData(String location_file,String country_file) {
		//Khởi tạo danh sách locations
        location_list=new ArrayList<String>();
        try(BufferedReader reader=new BufferedReader(new FileReader(location_file)))
        {
        	String name;
        	
            while((name=reader.readLine()) != null) {
            	location_list.add(name);
            }
            
        } catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: "+location_file);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: "+location_file);
			e.printStackTrace();
		}
        
      //Khởi tạo danh sách countries
      		country_list=new ArrayList<String>();
              try(BufferedReader reader=new BufferedReader(new FileReader(country_file)))
              {
              	String name;
              	
                  while((name=reader.readLine()) != null) {
                  	country_list.add(name);
                  }

              } catch (FileNotFoundException e) {
      			System.out.println("Error: Missing filename: "+country_file);
      			e.printStackTrace();
      		} catch (IOException e) {
      			System.out.println("Error: Fail to read filename: "+country_file);
      			e.printStackTrace();
      		}
	}
	    /**
	     * 
	     * @return tên 1 location ngẫu nhiên
	     */
	    public static String randomName() {
	    	if(location_list.isEmpty()) return null;
	    	int random_num=(int)(Math.random()*location_list.size());
	    	return location_list.get(random_num);
	    }
	    
	    /**
	     * 
	     * @return Tên một đất nước ngẫu nhiên
	     */
	    public static String randomCountry() {
	    	if(location_list.isEmpty()) return null;
	    	int random_num=(int)(Math.random()*country_list.size());
	    	return country_list.get(random_num);
	    }
	    
	    /**rand
	     * 
	     * @return description ngẫu nhiên cho location
	     */
	    public static String randomDescription() {
	    	int rand1=(int)(Math.random()*element.length);
	    	int rand2=(int)(Math.random()*50);
	    	return "Là một "+element[rand1]+"nổi tiếng thế giới,trung bình mỗi năm đón tiếp khoảng "+rand2+"triệu lượt khách du lịch";
	    }
	    
	    /**
	     * 
	     * @return một object Location với các thuộc tính ngẫu nhiên
	     */
	    public static Location generateLocation() {
	    	return new Location(randomName(),randomDescription(),randomCountry());
	    }

	    
	    
	    
	    
	    
}