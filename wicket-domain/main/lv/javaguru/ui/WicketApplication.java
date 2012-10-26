package lv.javaguru.ui;

import java.util.Map;

import lv.javaguru.app.Context;
import lv.javaguru.app.service.CourseService;
import lv.javaguru.model.Course;
import lv.javaguru.ui.page.HomePage;

import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see lv.javaguru.ui.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	private CourseService courseService;

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		Context.init();
		courseService = (CourseService) Context.get(Context.APP_SERVICE_COURSES); 
	}

	public CourseService getCourseService() {
		return courseService;
	}

}
