package object;

public class Organization extends Entity {
	private String headquarters;
	private String phone;
	private String email;
	private String chairman;

	public Organization() {
		this.headquarters = new String();
		this.phone = new String();
		this.email = new String();
		this.chairman = new String();
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChairman() {
		return chairman;
	}

	public void setChairman(String chairman) {
		this.chairman = chairman;
	}
}
