package object;

/**
 * Lớp lưu trữ thông tin của 1 thực thể Time
 *
 */
public class Time extends Entity{
	private static int index=0;
	
	public static int getIndex() {
    	return index;
    }
	
    public Time(String name,String description){
        super(name,description);
        this.id="Time"+(index++);
    }
    public Time(String name) {
    	super(name,null);
    	this.id="Time"+(index++);
    }
    
    @Override
    public String toString() {
    	return "Time:"+name;
    }
}