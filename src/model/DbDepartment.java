package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.entity.*;

public class DbDepartment {

	static Db db = new Db();
	Connection dbConnection = null;
	static PreparedStatement preparedStatement = null;
	static Statement Statement = null;
	static ResultSet result = null;

	static List<Department> departmentList = new ArrayList<>();

	String getdepartment = "SELECT * FROM `departments` WHERE id = ?";
	String getdepartments = "SELECT * FROM `departments`";

	public Department getDepartment(Integer id) throws SQLException {
		this.dbConnection = db.getDBConnection();
		Department department = new Department();

		try {
			preparedStatement = dbConnection.prepareStatement(getdepartment);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				department = SetDepartment(result);
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

		return department;
	}

	public List<Department> getDepartments() throws SQLException {
		this.dbConnection = db.getDBConnection();
		try {
			preparedStatement = dbConnection.prepareStatement(getdepartments);
			result = preparedStatement.executeQuery();

			while (result.next()) {
				Department department = SetDepartment(result);
				departmentList.add(department);
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
		return departmentList;

	}

	private static Department SetDepartment(ResultSet result) throws SQLException {
		
		Department department = new Department();
		department.setId(result.getInt("id"));
		department.setName(result.getString("name"));

		return department;

	}

}
