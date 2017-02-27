package controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Db;

//import com.mysql.jdbc.PreparedStatement;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Db db = new Db();
	Map< String, String > userdata = new HashMap< String, String >();
	Map<Integer, String> useremail = new HashMap< Integer, String>();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 	request.getRequestDispatcher("index.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		userdata.put("firstname", request.getParameter("firstname"));
		userdata.put("surname", request.getParameter("surname"));
		userdata.put("patronymic", request.getParameter("patronymic"));
		userdata.put("firstnamelatin", request.getParameter("firstnamelatin"));
		userdata.put("surnamelatin", request.getParameter("surnamelatin"));
		userdata.put("patronymiclatin", request.getParameter("patronymiclatin"));
		String email = request.getParameter("email");
		String email_domain = request.getParameter("domain");
		email = email + email_domain;
		userdata.put("email", email);
		userdata.put("password", request.getParameter("password"));
		userdata.put("phone", request.getParameter("phone"));
		userdata.put("department", request.getParameter("department"));
		try {
			if(db.isUser(email)) {
				request.setAttribute("error", "<h2>Error</h2>");
			} else {
				db.addUser(userdata);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
					
//		for (Map.Entry<Integer, String> entry : useremail.entrySet()) {
//			 request.setAttribute(entry.getKey(), entry.getValue());
//			 System.out.println(entry.getValue());
//		}  
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
//	private static Connection getDBConnection() {
//	    Connection dbConnection = null;
//	    try {
//	        Class.forName("com.mysql.jdbc.Driver");
//	    } catch (ClassNotFoundException e) {
//	        System.out.println(e.getMessage());
//	    }
//	    try {
//	        dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Users","root", "");
//	        return dbConnection;
//	    } catch (SQLException e) {
//	        System.out.println(e.getMessage());
//	    }
//	    return dbConnection;
//	}
	
	private static void createDbUserTable() throws SQLException {
	    Connection dbConnection = null;
	    Statement statement = null;
	 
	    String createTableSQL = "CREATE TABLE `users` (`user_id` INT(11) NOT NULL AUTO_INCREMENT,"+
	    	    "`firstnameua` VARCHAR(32) NOT NULL,"+
	    	    "`surnameua` VARCHAR(32) NOT NULL,"+
	    	    "`patronymicua` VARCHAR(32) NOT NULL,"+
	    	    "`firstnamelatin` VARCHAR(32) NOT NULL,"+
	    	    "`surnamelatin` VARCHAR(32) NOT NULL,"+
	    	    "`patronymiclatin` VARCHAR(32) NOT NULL,"+
	    	    "`email` VARCHAR(96) NOT NULL,"+
	    	    "`password` VARCHAR(40) NOT NULL,"+
	    	    "`phone` VARCHAR(32) NOT NULL,"+
	    	    "`user_group_id` INT(11) NOT NULL,"+
	    	    "`status` TINYINT(1) NULL DEFAULT NULL,"+
	    	    "PRIMARY KEY (`user_id`)) COLLATE='utf8_general_ci' ENGINE=MyISAM AUTO_INCREMENT=1;";
	    
	    try {
//	        dbConnection = db.getDBConnection();
	        statement = dbConnection.createStatement();
	 
	                // выполнить SQL запрос
	        statement.execute(createTableSQL);
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	        if (statement != null) {
	            statement.close();
	        }
	        if (dbConnection != null) {
	            dbConnection.close();
	        }
	    }
	}
	
//	private static void addUser(Map<String, String> userdata) throws SQLException {
//	    Connection dbConnection = null;
//	    Statement statement = null;
//	    PreparedStatement preparedStatement = null;    
//	    
//	    String createTableSQL = "INSERT INTO `users` (firstnameua, surnameua, patronymicua, firstnamelatin, surnamelatin, patronymiclatin, email, password, phone, user_group_id) "+
//	    	    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	 
//	    try {
//	        dbConnection = getDBConnection();
//	        preparedStatement = dbConnection.prepareStatement(createTableSQL);
//	 
//	        preparedStatement.setString(1, userdata.get("firstname"));
//	        preparedStatement.setString(2, userdata.get("surname"));
//	        preparedStatement.setString(3, userdata.get("patronymic"));
//	        preparedStatement.setString(4, userdata.get("firstnamelatin"));
//	        preparedStatement.setString(5, userdata.get("surnamelatin"));
//	        preparedStatement.setString(6, userdata.get("patronymiclatin"));
//	        preparedStatement.setString(7, userdata.get("email"));
//	        preparedStatement.setString(8, userdata.get("password"));
//	        preparedStatement.setString(9, userdata.get("phone"));
//	        preparedStatement.setString(10, userdata.get("department"));
//	        userdata.clear();
//	        preparedStatement.executeUpdate();
//
//	    } catch (SQLException e) {
//	        System.out.println(e.getMessage());
//	    } finally {
//	        if (statement != null) {
//	            statement.close();
//	        }
//	        if (dbConnection != null) {
//	            dbConnection.close();
//	        }
//	    }
//	}
	
//	private static Boolean isUser(String mail) throws SQLException {
//	    Connection dbConnection = null;
//	    Statement statement = null;
//	    int count = -1;
//	    PreparedStatement preparedStatement = null;    
//	    Map< Integer, String > useremail = new HashMap< Integer, String >();
//	    String createTableSQL = "SELECT user_id FROM `users` WHERE email = ?";
//
//	    try {
//	        dbConnection = getDBConnection();
////	        statement = dbConnection.createStatement();
//	        preparedStatement = dbConnection.prepareStatement(createTableSQL);
//	        preparedStatement.setString(1, mail);
//	        ResultSet result = preparedStatement.executeQuery();
//	        
//	        
//	        if(result.last()) {
//	        	count = result.getRow();
//	        }
//	        
////	        ResultSet result = statement.executeQuery(createTableSQL);
////	        
////	        while (result.next()) {
////	        	System.out.println(result.getString("email"));
////	        	System.out.println(result.getString("user_id"));
////	        	useremail.put(result.getInt("user_id"), result.getString("email"));
////	            
////	        }
//	        
////	        preparedStatement = dbConnection.prepareStatement(createTableSQL);
//	 
////	        preparedStatement.executeUpdate();
//
//	    } catch (SQLException e) {
//	        System.out.println(e.getMessage());
//	    } finally {
//	        if (statement != null) {
//	            statement.close();
//	        }
//	        if (dbConnection != null) {
//	            dbConnection.close();
//	        }
//	    }
//	    
//	    if(count == -1) {
//        	return false;
//        } else {
//        	return true;
//        }
//	}

}
