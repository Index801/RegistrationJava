package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Db;
import model.User;

@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Db db = new Db();
	User user = new User();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idparam = request.getParameter("id");
		Integer user_id = Integer.parseInt(idparam);
		try {
			user = db.getUser(user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("user_id", user.getUser_id());
		request.setAttribute("firstname", user.getFirstnameua());
		request.setAttribute("surname", user.getSurnameua());
		request.setAttribute("patronymic", user.getPatronymicua());
		request.setAttribute("firstnamelatin", user.getFirstnamelatin());
		request.setAttribute("surnamelatin", user.getSurnamelatin());
		request.setAttribute("patronymiclatin", user.getPatronymiclatin());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("phone", user.getPhone());
		request.setAttribute("password", user.getPassword());
		request.setAttribute("user_group_id", user.getUser_group_id());
		request.setAttribute("status", user.isStatus());
		request.setAttribute("reason", user.getReason());
		request.getRequestDispatcher("edituser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String idparam = request.getParameter("user_id");
		Integer user_id = Integer.parseInt(idparam);
		String department = request.getParameter("department");
		Integer user_group_id = Integer.parseInt(department);
//		String statusparam = request.getParameter("status");
//		Boolean stats = Boolean.parseBoolean(statusparam);
		user.setFirstnameua(request.getParameter("firstname"));
		user.setSurnameua(request.getParameter("surname"));
		user.setPatronymicua(request.getParameter("patronymic"));
		user.setFirstnamelatin(request.getParameter("firstnamelatin"));
		user.setSurnamelatin(request.getParameter("surnamelatin"));
		user.setPatronymiclatin(request.getParameter("patronymiclatin"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		user.setUser_group_id(user_group_id);
		
		if(Integer.parseInt(request.getParameter("status")) == 1) {
			user.setStatus(true);
			user.setReason("");
		} else {		
			user.setStatus(false);
			user.setReason(request.getParameter("reason"));		
		}
		try {
			db.updateUser(user_id, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 response.sendRedirect("User");
//	    request.getRequestDispatcher("User.jsp").forward(request, response);
	   
	   
	}

}
