package object;

public abstract class Entity{
    protected String id;
    protected String name;
    protected String description;
    protected Source source;
    public Entity(String name,String description){
    	this.name=name;
    	this.description=description;
    	this.source=null;
    }
}