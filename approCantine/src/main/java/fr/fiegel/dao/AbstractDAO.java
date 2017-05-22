package fr.fiegel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ServiceLoader;

public abstract class AbstractDAO<T extends Object> {

	protected Connection connexion;

	public AbstractDAO() {
		ServiceLoader<DbConnection> dbConnectionImplem = ServiceLoader.load(DbConnection.class);
		dbConnectionImplem.forEach(implem -> {
			try {
				connexion = implem.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
//		DbConnection con =  new MysqlDbConnection();
//		try {
//			connexion  =  con.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	public void closeConnection() {
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected abstract T fromResultSet(ResultSet result) throws SQLException ;
	
}
