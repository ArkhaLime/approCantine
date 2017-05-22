package fr.fiegel.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {

  public Connection getConnection() throws SQLException;

}
