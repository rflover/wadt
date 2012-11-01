package lv.javaguru.app.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import lv.javaguru.app.Context;
import lv.javaguru.db.DriverManagerDatabase;
import lv.javaguru.model.Course;

import org.junit.Before;
import org.junit.Test;

public class CoursesIntegrationTest {

	@Before
	public void before() { 
		Context.reset(); 
	}
	
	@Test
	public void testGetCourseListMocked() {
		lv.javaguru.dao.CourseDao coursesDaoMock = mock(lv.javaguru.dao.CourseDao.class); 
		Context.put(Context.DAO_COURSES, coursesDaoMock);
		Context.init();
		@SuppressWarnings("serial")
		Map<String, Course> expected = new HashMap<String, Course>() {{  
			put("Java1", new Course("Java 1 description", "Java 1 - Java Fundamentals", "Java1"));
			put("Java2", new Course("Java 2 description", "Java 2 - Agile Web Application Development", "Java2"));
		}};
		
		when(coursesDaoMock.getList()).thenReturn(expected.values()); 
		
		lv.javaguru.app.service.CourseService courses = (CourseService) Context.get(Context.APP_SERVICE_COURSES); 

		Map<String, Course> actual = courses.getMap(); 
		
		assertTrue(expected.size() == actual.size() 
				&& expected.get("Java1") == actual.get("Java1") 
				&& expected.get("Java2") == actual.get("Java2") 
		);
	}

	@Test
	public void testGetCourseListFromDb() {
		DriverManagerDatabase database = new DriverManagerDatabase(); 
		database.setConnectString("jdbc:hsqldb:file:wadtdb");
		database.setUser("SA"); 
		database.setPassword("");
		Context.put(Context.DB_DATABASE, database);
		Context.init();

		@SuppressWarnings("serial")
		Map<String, Course> expected = new HashMap<String, Course>() {{  
			put("Java1", new Course("Java 1 description from db", "Java 1 - Java Fundamentals", "Java1"));
			put("Java2", new Course("Java 2 description from db", "Java 2 - Agile Web Application Development", "Java2"));
		}};
		
		
		lv.javaguru.app.service.CourseService courses = (CourseService) Context.get(Context.APP_SERVICE_COURSES); 

		Map<String, Course> actual = courses.getMap(); 
		
		assertEquals(expected.size(), actual.size()); 
		assertEquals(expected.get("Java1").getName(), actual.get("Java1").getName());
		assertEquals(expected.get("Java2").getName(), actual.get("Java2").getName());
		assertEquals(expected.get("Java1").getDescription(), actual.get("Java1").getDescription());
		assertEquals(expected.get("Java2").getDescription(), actual.get("Java2").getDescription());
	}

	
}
