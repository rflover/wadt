package lv.javaguru.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lv.javaguru.core.Initializable;
import lv.javaguru.model.Course;

public class CourseDao implements Initializable {
	private List<Course> courseList = new ArrayList<Course>() {{  
		add(new Course("Java 1 description", "Java 1 - Java Fundamentals", "Java1"));
		add(new Course("Java 2 description", "Java 2 - Agile Web Application Development", "Java2"));
	}};

	public Collection<Course> getList() {
		return courseList;
	}

	@Override
	public void init() {
	}
}
