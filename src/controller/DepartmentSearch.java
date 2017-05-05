package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.entity.Department;
import main.entity.User;
import model.DbDepartment;
import model.DbUser;

@WebServlet("/DepartmentSearch")
public class DepartmentSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DbDepartment dep = new DbDepartment();
	private User user;
	private List<User> users = new ArrayList();
	private List<Department> departments = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DbUser db = new DbUser();
		
		Integer id = Integer.parseInt(request.getParameter("id"));	
		
		try {
			departments.clear();
			users.clear();
			departments = dep.getDepartments();
			request.setAttribute("departments", departments);
			users = db.DepSearch(id);
			request.setAttribute("users", users);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("User.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
