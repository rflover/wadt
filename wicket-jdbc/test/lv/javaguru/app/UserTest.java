package lv.javaguru.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import lv.javaguru.app.Context;
import lv.javaguru.app.User;
import lv.javaguru.app.service.UserService;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	@Test
	public void testUserChangesPassword() {
		String oldPassword = "oldPassword";
		String newPassword = "newPassword";

		User user = new User("login", oldPassword); 
		user.changePassword(oldPassword, newPassword); 

		assertTrue(user.isACorrectPassword(newPassword));
	}

	
}
