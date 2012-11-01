package lv.javaguru.app.service;

import java.util.Map;

import lv.javaguru.app.Context;
import lv.javaguru.app.CourseList;
import lv.javaguru.core.Initializable;
import lv.javaguru.model.Course;

public class CourseService implements Initializable {

	private CourseList courseList;
	
	public Map<String, Course> getMap() {
		return courseList.getList();
	}

	@Override
	public void init() {
		courseList = (CourseList) Context.get(Context.APP_COURSE_LIST);		
	}
}
