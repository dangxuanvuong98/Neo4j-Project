package storage;

public class Person extends Entity {
	byte age;
	boolean gender;
	String job;
	public Person() {
		super();
		this.age = 0;
		this.gender = false;
		this.job = new String();
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
