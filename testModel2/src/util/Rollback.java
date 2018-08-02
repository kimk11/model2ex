package util;

import java.sql.Connection;
import java.sql.SQLException;

public class Rollback {
	public Rollback(Connection connection) {
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
