package lv.javaguru.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import lv.javaguru.core.Initializable;

public class DatasourceDatabase implements Database {

	private DataSource datasource;

	@Override
	public Connection getConnection() {
		try {
			Connection con = datasource.getConnection();
			return con;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void init() {
		Context context;
		DataSource datasource;
		try {
			context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/hsqldb/wadtdb");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	public void initializeDatasource(String resourceName) {
		Context context;
		try {
			context = new InitialContext();
			datasource = (DataSource) context.lookup(resourceName);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	
}
