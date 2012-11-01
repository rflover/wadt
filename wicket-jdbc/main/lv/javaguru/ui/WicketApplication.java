package lv.javaguru.ui;

import lv.javaguru.app.Context;
import lv.javaguru.app.service.CourseService;
import lv.javaguru.db.Database;
import lv.javaguru.db.DatasourceDatabase;
import lv.javaguru.ui.page.HomePage;

import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see lv.javaguru.ui.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	private CourseService courseService;

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		try {
			DatasourceDatabase datasourceDatabase = new DatasourceDatabase();
			datasourceDatabase
					.initializeDatasource("java:comp/env/hsqldb/wadtdb");
			Context.put(Context.DB_DATABASE, datasourceDatabase);
		} catch (Exception e) {
			// It might mean we are launched in a test containter
		}
		Context.init();

		courseService = (CourseService) Context
				.get(lv.javaguru.app.Context.APP_SERVICE_COURSES);
	}

	public CourseService getCourseService() {
		return courseService;
	}

}
