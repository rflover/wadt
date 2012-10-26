package lv.javaguru.app;

import java.util.HashMap;
import java.util.Map;

import lv.javaguru.app.service.CourseService;
import lv.javaguru.app.service.UserService;
import lv.javaguru.core.Initializable;
import lv.javaguru.dao.CourseDao;
import lv.javaguru.dao.UserDao;

public class Context {

	public static final String APP_SERVICE_COURSES = "app.service.Courses";
	public static final String APP_SERVICE_USERS = "app.service.Users";
	public static final String APP_COURSE_LIST = "app.CourseList";
	public static final String APP_USER_LIST = "app.UserList";
	public static final String DAO_COURSES = "dao.Courses";
	public static final String DAO_USERS = "dao.Users";
	@SuppressWarnings("serial")
	public static Map<String, Initializable> context;

	static {
		reset();
	}

	public static Object get(String key) {
		return context.get(key);
	}

	public static void init() {
		for (Initializable item : context.values()) {
			item.init();
		}
	}

	public static void reset() {
		context = new HashMap<String, Initializable>() {
			{
				put(DAO_COURSES, 			new CourseDao());
				put(DAO_USERS, 				new UserDao());
				put(APP_COURSE_LIST, 		new CourseList());
				put(APP_USER_LIST, 			new UserList());
				put(APP_SERVICE_COURSES, 	new CourseService());
				put(APP_SERVICE_USERS, 		new UserService());
			}
		};
	}
}
