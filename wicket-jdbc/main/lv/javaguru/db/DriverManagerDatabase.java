package lv.javaguru.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import lv.javaguru.core.Initializable;

public class DriverManagerDatabase implements Database {

	private String connectString;
	private String user;
	private String password;

	public void setConnectString(String connectString) {
		this.connectString = connectString;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DriverManagerDatabase() {

	}

	public DriverManagerDatabase(String connectString, String user, String password) {
		this.connectString = connectString;
		this.user = user;
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see lv.javaguru.db.IDatabase#getConnection()
	 */
	@Override
	public Connection getConnection() {
		Connection connection;
		try {
			connection = DriverManager.getConnection(connectString, user,
					password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

	@Override
	public void init() {

	}

}
