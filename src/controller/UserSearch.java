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


@WebServlet("/UserSearch")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbDepartment dep = new DbDepartment();
	private User user;
	private List<User> users = new ArrayList();
	private List<Department> departments = new ArrayList<>();
	
	
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbUser db = new DbUser();
		
		String email = request.getParameter("search");	
		
		try {
			departments.clear();
			users.clear();
			departments = dep.getDepartments();
			request.setAttribute("departments", departments);
			
			users = db.Search(email);
			request.setAttribute("users", users);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("User.jsp").forward(request, response);
		
	}

}
