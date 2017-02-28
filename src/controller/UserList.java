package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Db;
import model.User;

@WebServlet(name = "User", urlPatterns = { "/User" })
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Db db = new Db();
	List<User> users = new ArrayList();
	Object user = new ArrayList();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			users = Db.getUsers();
			request.setAttribute("users", users);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("User.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("User.jsp").forward(request, response);
	}
	
}
