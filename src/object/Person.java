package object;

public class Person extends Entity {
	private Integer age;
	private Boolean gender;
	private String job;

	public Person() {
		super();
		this.age = 0;
		this.gender = false;
		this.job = new String();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean isGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
