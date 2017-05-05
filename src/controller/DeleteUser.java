package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.entity.User;
import model.DbUser;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private User user;
	DbUser db = new DbUser();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		Integer user_id = Integer.parseInt(request.getParameter("user_id"));
		
		try {
			db.removeUser(user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print("success");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		response.setContentType("text/plain");
		String[] user_id;

		user_id = request.getParameterValues("user_check");
		for (int i = 0; i < user_id.length; i++) {
			Integer id = Integer.parseInt(user_id[i]);
			try {
				db.removeUser(id);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		PrintWriter out = response.getWriter();
		out.print("success");

	}
}
