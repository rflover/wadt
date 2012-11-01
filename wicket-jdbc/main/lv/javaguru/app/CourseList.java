package lv.javaguru.app;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lv.javaguru.core.Initializable;
import lv.javaguru.dao.CourseDao;
import lv.javaguru.model.Course;
/* 
 * Not thread safe!
 */
public class CourseList implements Initializable {

	private Map<String, Course> list;  
	
	public Map<String, Course> getList() {
		if (list == null) { 
			list = new HashMap<String, Course>();
			CourseDao coursesDao = (CourseDao) Context.get(Context.DAO_COURSES);
			Collection<Course> rawList = coursesDao.getList(); 
			for (Course course : rawList) { 
				list.put(course.getId(), course); 
			}
		}
		return Collections.unmodifiableMap(list); 
	}

	@Override
	public void init() {
	}

}
