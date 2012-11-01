package lv.javaguru.db;

import java.sql.Connection;

import lv.javaguru.core.Initializable;

public interface Database extends Initializable {

	public Connection getConnection();

}