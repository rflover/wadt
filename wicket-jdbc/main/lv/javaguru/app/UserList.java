package lv.javaguru.app;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lv.javaguru.core.Initializable;
import lv.javaguru.dao.CourseDao;
import lv.javaguru.dao.UserDao;
import lv.javaguru.model.Course;
/* 
 * Not thread safe!
 */
public class UserList implements Initializable {

	private Map<String, User> list;  
	
	public Map<String, User> getList() {
		if (list == null) { 
			list = new HashMap<String, User>();
			UserDao UsersDao = (UserDao) Context.get(Context.DAO_USERS);
			Collection<User> rawList = UsersDao.getList(); 
			for (User User : rawList) { 
				list.put(User.getLogin(), User); 
			}
		}
		return Collections.unmodifiableMap(list); 
	}

	@Override
	public void init() {
	}

}
