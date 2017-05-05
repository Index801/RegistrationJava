package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.SchedulerException;

import model.Quartzmain;

@WebServlet("/RemoveUserCron")
public class RemoveUserCron extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Quartzmain quajob = new Quartzmain();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String remove = request.getParameter("remove");

		quajob.remove(remove);

	}

}
