package lv.javaguru.app.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import lv.javaguru.app.Context;
import lv.javaguru.model.Course;

import org.junit.Before;
import org.junit.Test;

public class CoursesIntegrationTest {

	@Before
	public void before() { 
		Context.reset(); 
	}
	
	@Test
	public void testGetCourseList() {
		lv.javaguru.dao.CourseDao coursesDaoMock = mock(lv.javaguru.dao.CourseDao.class); 
		Context.context.put(Context.DAO_COURSES, coursesDaoMock);
		Context.init();
		Map<String, Course> expected = new HashMap<String, Course>() {{  
			put("Java1", new Course("Java 1 description", "Java 1 - Java Fundamentals", "Java1"));
			put("Java2", new Course("Java 2 description", "Java 2 - Agile Web Application Development", "Java2"));
		}};
		
		when(coursesDaoMock.getList()).thenReturn(expected.values()); 
		
		lv.javaguru.app.service.CourseService courses = (CourseService) Context.context.get(Context.APP_SERVICE_COURSES); 

		Map<String, Course> actual = courses.getMap(); 
		
		assertTrue(expected.size() == actual.size() 
				&& expected.get("Java1") == actual.get("Java1") 
				&& expected.get("Java2") == actual.get("Java2") 
		);
	}

}
