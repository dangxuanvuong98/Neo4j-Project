package object;

/**
 * Lớp thực thể Country,lưu trữ thông tin của 1 thực thể Country
 */
public class Country extends Entity {
	private String capital;

	public Country() {
		super();
		this.capital = "";
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "###Name:" + name + "\n-ID:" + id + "\n-Description:"
				+ description + "\n-Capital:" + capital;
	}
}