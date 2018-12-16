package generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import object.Time;

/**
 * Lớp sinh ngẫu nhiên các thực thể Time
 *
 */
public class TimeGenerator{
	static List<String> special_day_list;
	
	/**
	 * Đọc dữ liệu từ file,trích rút và lưu trữ thông tin phục vụ sinh ngẫu nhiên
	 * @param filename đường dẫn tới file chứa danh sách các ngày đặc biệt trong năm
	 */
	public static void getData(String filename) {
		//Initialize list of times
        special_day_list=new ArrayList<String>();
        try(BufferedReader reader=new BufferedReader(new FileReader(filename)))
        {
        	String name;
        	
            while((name=reader.readLine()) != null) {
            	special_day_list.add(name);
            }

        } catch (FileNotFoundException e) {
			System.out.println("Error: Missing filename: "+filename);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Fail to read filename: "+filename);
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return một object Time với các thuộc tính ngẫu nhiên
	 */
    public static Time generateTime() {
    	int random_year=1980+(int)(Math.random()*40);
    	int random_type=(int)(Math.random()*4);
    	if(special_day_list.isEmpty()) random_type=1;
    	if(random_type==0) {
    		int random_day=(int)(Math.random()*special_day_list.size());
    		return new Time(special_day_list.get(random_day)+" năm "+random_year);
    	}
    	else {
    		int random_day=1+(int)(Math.random()*28);
    		int random_month=1+(int)(Math.random()*12);
    		return new Time("ngày "+random_day+" tháng "+random_month+" năm "+random_year);
    	}
    }
    
}