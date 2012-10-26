package lv.javaguru.app;

import lv.javaguru.core.WrongPasswordException;

public class User {
	private final String login; 
	private String password;
	
	public String getLogin() {
		return login;
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	} 
	
	public boolean isACorrectPassword(String password) { 
		return this.password.equals(password); 
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if (!isACorrectPassword(oldPassword)) { 
			throw new WrongPasswordException(); 
		}
		
		password = newPassword; 
	}
}
