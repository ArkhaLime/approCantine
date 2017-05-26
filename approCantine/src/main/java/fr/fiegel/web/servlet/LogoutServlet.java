package fr.fiegel.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.fiegel.utils.Utils;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute(Utils.USER_CO)!=null) session.removeAttribute(Utils.USER_CO);
		resp.sendRedirect("Login.jsp");
	}

}
