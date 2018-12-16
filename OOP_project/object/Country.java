package object;
/**
 * Lớp thực thể Country,lưu trữ thông tin của 1 thực thể Country
 */
public class Country extends Entity{
	private static int index=0; 
    private String capital;
    
    public Country(String name,String description,String capital){
        super(name,description);
        this.id="Country"+(index++);
        this.capital=capital;
    }
    
    public String getCapital() {
    	return capital;
    }

    public void setCapital(String capital) {
    	this.capital = capital;
    }

    public static int getIndex() {
    	return index;
    }
    
    @Override
    public String toString() {
    	return "###Name:"+name+"\n-ID:"+id+"\n-Capital:"+capital+"\n-Description:"+description+"\n-Source:";
    }
}