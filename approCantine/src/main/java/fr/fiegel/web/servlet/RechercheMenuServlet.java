package fr.fiegel.web.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.fiegel.dao.MenuDAO;
import fr.fiegel.objects.Menu;
import fr.fiegel.utils.CalUtils;
import fr.fiegel.utils.StrUtils;
import fr.fiegel.utils.Utils;

@SuppressWarnings("serial")
public class RechercheMenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute(Utils.USER_CO) == null){
				resp.sendRedirect("login");
				return;
			}
			String tmpDate = req.getParameter("date");
			if(StrUtils.isNullOrEmpty(tmpDate)){
				resp.sendRedirect("listeMenus");
				return;
			}
			LocalDate date = CalUtils.fromDMYString(tmpDate);
			MenuDAO dao = new MenuDAO();
			ArrayList<Menu> menus = new ArrayList<Menu>( dao.getMenusByDate(false, date));			
			dao.closeConnection();
			req.setAttribute("menus", menus);
			req.setAttribute("recherche", true);
			req.getRequestDispatcher("jsp/ListeMenus.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}
	
}
