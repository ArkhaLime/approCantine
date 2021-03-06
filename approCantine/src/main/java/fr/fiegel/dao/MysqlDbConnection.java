package fr.fiegel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDbConnection implements DbConnection {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/fiegel_jee_appro_cantine?serverTimezone=UTC";
	// &useUnicode=true
	private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String USER = "root";
	private static final String PASSWORD = "";

	static {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to instanciate Mysql driver!");
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	}
}
