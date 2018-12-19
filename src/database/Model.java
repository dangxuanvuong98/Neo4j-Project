package database;

import java.util.ArrayList;
import storage.Entity;

public class Model {
	ArrayList<Entity> model = new ArrayList<Entity>();
	public Model() {
		this.model = new ArrayList<Entity>();
	}
	
	public void add(Entity entity) {
		model.add(entity);
	}
	
	public void clear() {
		this.model = new ArrayList<Entity>();
	}
	
	public String toString() {
		return("nyll");
	}
}
