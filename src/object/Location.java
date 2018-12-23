package object;

/**
 * Lớp lưu trữ thông tin của thực thể Location
 * 
 */
public class Location extends Entity {
	private String country;

	public Location() {
		super();
		this.country = "";
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "###Name:" + name + "\n-ID:" + id + "\n-Description:"
				+ description + "\n-Source:" + source + "\n-Country:" + country;
	}
}