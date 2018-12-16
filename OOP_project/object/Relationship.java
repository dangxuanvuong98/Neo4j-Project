package object;

/**
 * Lớp lưu trữ thông tin của 1 quan hệ giữa 2 thực thể
 *
 */
public class Relationship{
	private static int index=0;
    private String id;
    private String type;	//Tên quan hệ
    private String en_id1; 	//Id thực thể chủ động
    private String en_id2;	//Id thực thể thụ động
    private Source source;
    
    public String getEn_id1() {
    	return en_id1;
    }

    public String getEn_id2() {
    	return en_id2;
    }

    public String getType() {
    	return type;
    }

    public void setType(String type){
    	this.type=type;
    }

    public static int getIndex() {
    	return index;
    }
    
    public Relationship(String type,String en_id1,String en_id2){
    	this.id="Relationship"+(index++);
        this.type=type;
        this.en_id1=en_id1;
        this.en_id2=en_id2;
        //this.source=???
    }
    
    @Override
    public String toString() {
    	return en_id1+" "+type+" "+en_id2;
    }
}