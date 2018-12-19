package storage;

public class Entity {
	private int id;
	private String name;
	private String description;
	public Entity() {
		super();
		this.id = 0;
		this.name = new String();
		this.description = new String();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}