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
import fr.fiegel.dao.ProduitDAO;
import fr.fiegel.objects.Produit;
import fr.fiegel.utils.CalUtils;
import fr.fiegel.utils.StrUtils;
import fr.fiegel.utils.Utils;

@SuppressWarnings("serial")
public class CreationMenuServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute(Utils.USER_CO) == null){
				resp.sendRedirect("login");
				return;
			}
			ProduitDAO dao = new ProduitDAO();
			ArrayList<Produit> produits = new ArrayList<Produit>( dao.rechercherProduit(true));			
			dao.closeConnection();
			req.setAttribute("produits", produits);
			req.getRequestDispatcher("jsp/CreationMenu.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute(Utils.USER_CO) == null){
				resp.sendRedirect("login");
				return;
			}
			String tmpDate = req.getParameter("date");
			String[] produits = req.getParameterValues("produits");
			if(StrUtils.isNullOrEmpty(tmpDate) || produits.length==0){
				resp.sendRedirect("creationMenu");
				return;
			}
			LocalDate date = CalUtils.fromDMYString(tmpDate);
			MenuDAO dao = new MenuDAO();
			dao.insertMenu(date, produits);
			dao.closeConnection();
			resp.sendRedirect("listeMenus");
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}
	
}
