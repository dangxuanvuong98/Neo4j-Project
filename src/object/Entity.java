package object;

/**
 * Lá»›p trá»«u tÆ°á»£ng,Ä‘áº¡i diá»‡n cho thá»±c thá»ƒ nÃ³i chung. LÃ  lá»›p
 * cha cá»§a má»�i lá»›p thá»±c
 * thá»ƒ:Person,Organization,Country,Location,Event,Time
 * 
 */
public abstract class Entity {
	protected String id;
	protected String name;
	protected String description;

	public Entity() {
		super();
		this.id = new String();
		this.name = new String();
		this.description = new String();
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
}