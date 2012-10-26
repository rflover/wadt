package lv.javaguru.app.service;

import lv.javaguru.app.Context;
import lv.javaguru.app.User;
import lv.javaguru.app.UserList;
import lv.javaguru.core.Initializable;
import lv.javaguru.dao.UserDao;

public class UserService implements Initializable {

	private UserList userList;
	public UserDao userDao;

	public User signUp(String login, String password) {
		User user = new User(login, password);
		userDao.save(user);
		return user;
	}

	public User login(String login, String password) {
		User user = userList.getList().get(login);
		
		if (user != null && user.isACorrectPassword(password)) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public void init() {
		userList = (UserList) Context
				.get(Context.APP_USER_LIST);
		userDao = (lv.javaguru.dao.UserDao) Context
				.get(Context.DAO_USERS);
		
	}

}
