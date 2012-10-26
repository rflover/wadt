package lv.javaguru.model;

public class Course {
	private final String description; 
	private final String name;
	private final String id;
	
	public Course(String description, String name, String id) {
		this.description = description;
		this.name = name;
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	
}
