package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Db {
	static Connection dbConnection = null;
	static Statement Statement = null;
	static PreparedStatement preparedStatement = null;
	static ResultSet result = null;

	public Connection getDBConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			 dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Users", "root", "");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

}
