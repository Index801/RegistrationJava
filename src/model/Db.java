package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Db {
	static Connection dbConnection = null;
	static Statement Statement = null;
    static PreparedStatement preparedStatement = null; 
    static ResultSet result = null;
	
	public static Connection getDBConnection() {
	    
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	    try {
	        dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Users","root", "");
	        return dbConnection;
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return dbConnection;
	}
	
	public static void addUser(Map<String, String> userdata) throws SQLException {
	    	    
	    String createTableSQL = "INSERT INTO `users` (firstnameua, surnameua, patronymicua, firstnamelatin, surnamelatin, patronymiclatin, email, password, phone, user_group_id) "+
	    	    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	 
	    try {
	        dbConnection = getDBConnection();
	        preparedStatement = dbConnection.prepareStatement(createTableSQL);
	 
	        preparedStatement.setString(1, userdata.get("firstname"));
	        preparedStatement.setString(2, userdata.get("surname"));
	        preparedStatement.setString(3, userdata.get("patronymic"));
	        preparedStatement.setString(4, userdata.get("firstnamelatin"));
	        preparedStatement.setString(5, userdata.get("surnamelatin"));
	        preparedStatement.setString(6, userdata.get("patronymiclatin"));
	        preparedStatement.setString(7, userdata.get("email"));
	        preparedStatement.setString(8, userdata.get("password"));
	        preparedStatement.setString(9, userdata.get("phone"));
	        preparedStatement.setString(10, userdata.get("department"));
	        userdata.clear();
	        preparedStatement.executeUpdate();

	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	        if (Statement != null) {
	        	Statement.close();
	        }
	        if (dbConnection != null) {
	            dbConnection.close();
	        }
	    }
	}
	
	public static Boolean isUser(String mail) throws SQLException {
	    int count = -1;    
	    Map< Integer, String > useremail = new HashMap< Integer, String >();
	    
	    String sql = "SELECT user_id FROM `users` WHERE email = ?";

	    try {
	        dbConnection = getDBConnection();
//	        statement = dbConnection.createStatement();
	        preparedStatement = dbConnection.prepareStatement(sql);
	        preparedStatement.setString(1, mail);
	        result = preparedStatement.executeQuery();
	        
	        
	        if(result.last()) {
	        	count = result.getRow();
	        }
	        
//	        ResultSet result = statement.executeQuery(createTableSQL);
//	        
//	        while (result.next()) {
//	        	System.out.println(result.getString("email"));
//	        	System.out.println(result.getString("user_id"));
//	        	useremail.put(result.getInt("user_id"), result.getString("email"));
//	            
//	        }
	        
//	        preparedStatement = dbConnection.prepareStatement(createTableSQL);
	 
//	        preparedStatement.executeUpdate();

	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	        if (Statement != null) {
	        	Statement.close();
	        }
	        if (dbConnection != null) {
	            dbConnection.close();
	        }
	    }
	    
	    if(count == -1) {
        	return false;
        } else {
        	return true;
        }
	}
	
	public static List<User> getUsers() throws SQLException {
		
		List<User> userList = new ArrayList<>();
	    String sql = "SELECT * FROM `users`";
	 
	    try {
	        dbConnection = getDBConnection();
	        preparedStatement = dbConnection.prepareStatement(sql);
	        result = preparedStatement.executeQuery();
	        while(result.next())
	        {        	
	        	User user = SetUsers(result);
	        	userList.add(user);
	        }
	        
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	        if (Statement != null) {
	        	Statement.close();
	        }
	        if (dbConnection != null) {
	            dbConnection.close();
	        }
	    }
	    return userList;
	}
	 private static User SetUsers(ResultSet result) throws SQLException {
			User user = new User();
			user.setUser_id(result.getInt("user_id"));
			user.setFirstnameua(result.getString("firstnameua"));
			user.setSurnameua(result.getString("surnameua"));
			user.setPatronymicua(result.getString("patronymicua"));
			user.setFirstnamelatin(result.getString("firstnamelatin"));
			user.setSurnamelatin(result.getString("surnamelatin"));
			user.setPatronymiclatin(result.getString("patronymiclatin"));
			user.setEmail(result.getString("email"));
			user.setPassword(result.getString("password"));
			user.setPhone(result.getString("phone"));
			user.setStatus(result.getBoolean("status"));
			user.setUser_group_id(result.getInt("user_group_id"));
			return user;
		    }
}
