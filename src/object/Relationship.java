package object;

/**
 * Lớp lưu trữ thông tin của 1 quan hệ giữa 2 thực thể
 * 
 */
public class Relationship {
	private String type; // Tên quan hệ
	private String en_id1; // Id thực thể chủ động
	private String en_id2; // Id thực thể thụ động
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

	public void setType(String type) {
		this.type = type;
	}

	public Relationship() {
		type = "";
		en_id1 = "";
		en_id2 = "";
		source = new Source();
	}

	public void setEn_id1(String en_id1) {
		this.en_id1 = en_id1;
	}

	public void setEn_id2(String en_id2) {
		this.en_id2 = en_id2;
	}

	@Override
	public String toString() {
		return en_id1 + " " + type + " " + en_id2;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
}