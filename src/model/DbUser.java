package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import main.entity.*;

public class DbUser {

	static Db db = new Db();

	 Connection dbConnection = null;
	static PreparedStatement preparedStatement = null;
	static Statement Statement = null;
	static ResultSet result = null;
	static List<User> userList = new ArrayList<>();

	private static String adduser = "INSERT INTO `users` (firstnameua, surnameua, patronymicua, firstnamelatin, surnamelatin, patronymiclatin, email, password, phone, user_group_id) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String isuser = "SELECT user_id FROM `users` WHERE email = ?";
	private static String getusers = "SELECT * FROM `users`";
	private static String getuser = "SELECT * FROM `users` WHERE user_id = ?";
	private static String updateuser = "UPDATE users  SET firstnameua = ?,surnameua = ?,patronymicua = ?,firstnamelatin = ?,surnamelatin = ?,patronymiclatin = ?,"
			+ "password = ? ,phone = ?,user_group_id=?,status = ?, reason = ? WHERE user_id = ?";
	private static String removeuser = "DELETE  FROM `users` WHERE user_id = ?";
	private static String search = "SELECT * FROM `users` WHERE email LIKE ?";
	private static String depsearch = "SELECT * FROM `users` WHERE user_group_id = ?";

	public  void addUser(Map<String, String> userdata) throws SQLException {
		this.dbConnection = db.getDBConnection();
		try {

			preparedStatement = dbConnection.prepareStatement(adduser);
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

	public  Boolean isUser(String mail) throws SQLException {
		int count = -1;
		this.dbConnection = db.getDBConnection();
		try {
			preparedStatement = dbConnection.prepareStatement(isuser);
			preparedStatement.setString(1, mail);
			result = preparedStatement.executeQuery();

			if (result.last()) {
				count = result.getRow();
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

		if (count == -1) {
			return false;
		} else {
			return true;
		}
	}

	public List<User> getUsers() throws SQLException {
		this.dbConnection = db.getDBConnection();
		try {

			preparedStatement = dbConnection.prepareStatement(getusers);
			result = preparedStatement.executeQuery();

			while (result.next()) {
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

	public User getUser(Integer user_id) throws SQLException {
		this.dbConnection = db.getDBConnection();
		User user = new User();

		try {

			preparedStatement = dbConnection.prepareStatement(getuser);
			preparedStatement.setInt(1, user_id);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				user = SetUsers(result);
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
		return user;
	}

	public void updateUser(int user_id, User user) throws SQLException {
		this.dbConnection = db.getDBConnection();
		try {

			PreparedStatement preparedStatement = dbConnection.prepareStatement(updateuser);
			int i = 1;

			preparedStatement.setString(i++, user.getFirstnameua());
			preparedStatement.setString(i++, user.getSurnameua());
			preparedStatement.setString(i++, user.getPatronymicua());
			preparedStatement.setString(i++, user.getFirstnamelatin());
			preparedStatement.setString(i++, user.getSurnamelatin());
			preparedStatement.setString(i++, user.getPatronymiclatin());
			preparedStatement.setString(i++, user.getPassword());
			preparedStatement.setString(i++, user.getPhone());
			preparedStatement.setInt(i++, user.getUser_group_id());
			preparedStatement.setBoolean(i++, user.isStatus());
			preparedStatement.setString(i++, user.getReason());
			preparedStatement.setInt(i++, user_id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			dbConnection.close();
		}
	}

	public void removeUser(int user_id) throws SQLException {
		this.dbConnection = db.getDBConnection();
		try {
			preparedStatement = dbConnection.prepareStatement(removeuser);
			preparedStatement.setInt(1, user_id);
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
	
	public List<User> Search(String email) throws SQLException {
		this.dbConnection = db.getDBConnection();

		User user = new User();
		try {

			preparedStatement = dbConnection.prepareStatement(search);
			preparedStatement.setString(1, email+"%");
				
			result = preparedStatement.executeQuery();
			
			while (result.next()) {
				user = SetUsers(result);
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
	
	public List<User> DepSearch( Integer id) throws SQLException {
		this.dbConnection = db.getDBConnection();

		User user = new User();

		try {

			preparedStatement = dbConnection.prepareStatement(depsearch);
			preparedStatement.setInt(1, id);
				
			result = preparedStatement.executeQuery();
			
			while (result.next()) {
				user = SetUsers(result);
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
		user.setReason(result.getString("reason"));
		return user;

	}

}
