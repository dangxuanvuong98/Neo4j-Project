package object;
/**
 * Lớp trừu tượng,đại diện cho thực thể nói chung. 
 * Là lớp cha của mọi lớp thực thể:Person,Organization,Country,Location,Event,Time
 *
 */
public abstract class Entity {
	protected String id;
	protected String name;
	protected String description;
	protected Source source;

	public Entity() {
		super();
		this.id = new String();
		this.name = new String();
		this.description = new String();
		this.source=new Source();
	}

	public Entity(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	public Source getSource() {
		return this.source;
	}
	
	public void setSource(Source source) {
		this.source=source;
	}
}