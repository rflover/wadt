package lv.javaguru.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lv.javaguru.app.Context;
import lv.javaguru.core.Initializable;
import lv.javaguru.db.Database;
import lv.javaguru.model.Course;

public class CourseDao implements Initializable {
//	private List<Course> courseList = new ArrayList<Course>() {{  
//		add(new Course("Java 1 description", "Java 1 - Java Fundamentals", "Java1"));
//		add(new Course("Java 2 description", "Java 2 - Agile Web Application Development", "Java2"));
//	}};

	private Database database;

	public Collection<Course> getList() {
		Connection connection = database.getConnection(); 
		ResultSet rs;
		List<Course> courseList = new ArrayList<Course>(); 
		try {
			rs = connection.createStatement().executeQuery("select * from courses");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name"); 
				String description = rs.getString("description"); 
				courseList.add(new Course(description, name, id)); 
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 

		return courseList;
	}

	@Override
	public void init() {
		database = (Database) Context.get(Context.DB_DATABASE); 
	}
	
}
