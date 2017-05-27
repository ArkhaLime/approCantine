package fr.fiegel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.fiegel.dao.MenuDAO;
import fr.fiegel.objects.Menu;
import fr.fiegel.utils.Utils;

@SuppressWarnings("serial")
public class ListeMenusServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute(Utils.USER_CO) == null){
				resp.sendRedirect("login");
				return;
			}
			MenuDAO dao = new MenuDAO();
			ArrayList<Menu> menus = new ArrayList<Menu>( dao.getMenus(false));			
			dao.closeConnection();
			req.setAttribute("menus", menus);
			req.getRequestDispatcher("jsp/ListeMenus.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}
	
}
