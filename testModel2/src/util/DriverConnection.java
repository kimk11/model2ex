package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.sql.DataSource;

public class DriverConnection {
	public static Connection connection = null;
	public static DataSource dataSource = null;
	
	public static Connection getConnectionInfo() {
		try {
			Context init = new InitialContext();
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
