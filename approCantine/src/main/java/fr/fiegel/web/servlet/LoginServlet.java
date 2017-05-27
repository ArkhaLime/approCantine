package fr.fiegel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.fiegel.dao.UserDAO;
import fr.fiegel.objects.User;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserDAO dao = new UserDAO();
			User user = dao.connect(req.getParameter("login"), req.getParameter("password"));
			dao.closeConnection();
			if(user==null){
				resp.sendRedirect("jsp/Login-error.jsp");
				return;
			}
			req.getSession().setAttribute("userCo", user);
			resp.sendRedirect("listeProduits");
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}
	
	

}
