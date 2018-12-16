package object;
/**
 * Lớp lưu trữ thông tin của thực thể Location
 *
 */
public class Location extends Entity{
	private static int index=0;
    private String country;
    
    public static int getIndex() {
    	return index;
    }
    
    public String getCountry() {
    	return country;
    }

    public void setCountry(String country) {
    	this.country = country;
    }
    
    public Location(String name,String description,String country){
        super(name,description);
        this.id="Location"+(index++);
        this.country=country;
    }
} 