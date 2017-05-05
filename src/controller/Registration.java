package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.entity.Department;
import model.DbDepartment;
import model.DbUser;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DbDepartment dep = new DbDepartment();
	DbUser dbuser = new DbUser();
	Map<String, String> userdata = new HashMap<String, String>();
	private List<Department> departments = new ArrayList<>();
//	Map<Integer, String> useremail = new HashMap<Integer, String>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			departments = dep.getDepartments();
			request.setAttribute("departments", departments);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		try {
			departments = dep.getDepartments();
			request.setAttribute("departments", departments);
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
			if (dbuser.isUser(email)) {
				request.setAttribute("error", "<h2>User already registered</h2>");
			} else {
				dbuser.addUser(userdata);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
