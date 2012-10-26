package lv.javaguru.app.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import lv.javaguru.app.Context;
import lv.javaguru.app.User;

import org.junit.Before;
import org.junit.Test;

public class UsersIntegrationTest {

	public lv.javaguru.dao.UserDao usersDaoMock; 
	public lv.javaguru.app.service.UserService users;
	
	@Before
	public void before() {
		Context.reset();
		usersDaoMock = mock(lv.javaguru.dao.UserDao.class);
		Context.context.put(Context.DAO_USERS, usersDaoMock);
		Context.init();
		users = (UserService) Context.context
				.get(Context.APP_SERVICE_USERS);
	}
	
	@Test
	public void testUserSignsUp() {
		User user = users.signUp("login", "password");
		
		verify(usersDaoMock).save(user);
	}

	@Test
	public void testUserLogsInWithCorrectPassword() {
		when(usersDaoMock.getList()).thenReturn(
				Arrays.<User> asList(new User("login", "password")));

		User user = users.login("login", "password");

		assertTrue(user.getLogin().equals("login"));
	}

	@Test
	public void testUserCantLogInWithIncorrectPassword() {
		when(usersDaoMock.getList()).thenReturn(
				Arrays.<User> asList(new User("login", "password")));
		
		User user = users.login("login", "wrong");

		assertTrue(user == null);
	}

	@Test
	public void testNonexistentUserCantLogIn() {
		when(usersDaoMock.getList()).thenReturn(
				Arrays.<User> asList(new User("login", "password")));

		User user = users.login("wronglogin", "password");

		assertTrue(user == null);
	}
	
}
