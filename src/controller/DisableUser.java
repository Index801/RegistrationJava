package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.entity.User;
import model.DbUser;

@WebServlet("/DisableUser")
public class DisableUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user;
	DbUser db = new DbUser();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] user_id;

		user_id = request.getParameterValues("user_check");
		for (int i = 0; i < user_id.length; i++) {
			Integer id = Integer.parseInt(user_id[i]);
			try {
				user = db.getUser(id);
				user.setStatus(false);
				db.updateUser(id, user);
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}

}
