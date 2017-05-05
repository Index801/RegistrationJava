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

import model.DbDepartment;
import model.DbUser;
import main.entity.*;

@WebServlet("/User")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUser db = new DbUser();
	DbDepartment dep = new DbDepartment();
	private List<User> users = new ArrayList();
	private User user;
	private List<Department> departments = new ArrayList<>();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			departments.clear();
			departments = dep.getDepartments();
			request.setAttribute("departments", departments);
			users.clear();
			users = db.getUsers();
			request.setAttribute("users", users);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("User.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer user_id = Integer.parseInt(request.getParameter("user_id"));		

		try {
			user = db.getUser(user_id);
			if (Integer.parseInt(request.getParameter("status")) == 1) {
				user.setStatus(false);
			} else {
				user.setStatus(true);
			}
			db.updateUser(user_id, user);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("User.jsp").forward(request, response);
	}

}
