package object;

/**
 * Lớp lưu trữ thông tin của 1 thực thể Time
 * 
 */
public class Time extends Entity {
	public Time() {
		super();
	}

	@Override
	public String toString() {
		return "###Name:" + name + "\n-ID:" + id + 
				 "\n-Description:" + description + "\n-Source:"+source;
	}
}