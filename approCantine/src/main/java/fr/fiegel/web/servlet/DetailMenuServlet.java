package fr.fiegel.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.fiegel.dao.MenuDAO;
import fr.fiegel.objects.Menu;
import fr.fiegel.utils.StrUtils;
import fr.fiegel.utils.Utils;

@SuppressWarnings("serial")
public class DetailMenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute(Utils.USER_CO) == null){
				resp.sendRedirect("login");
				return;
			}
			
			String ident = req.getParameter("ident");
			Menu menu=null;
			if(StrUtils.isNullOrEmpty(ident)){
				resp.sendRedirect("listeMenus");
				return;
			}
			MenuDAO dao = new MenuDAO();
			menu = dao.getMenuByIdent(Integer.parseInt(ident));
			dao.closeConnection();
			
			/*if(produit==null){
				resp.sendRedirect("listeProduit");
				return;
			}*/
			req.setAttribute("menu", menu);
			req.getRequestDispatcher("jsp/DetailMenu.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}
	
}
