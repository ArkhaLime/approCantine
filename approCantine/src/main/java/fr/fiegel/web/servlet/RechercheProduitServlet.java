package fr.fiegel.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.fiegel.dao.ProduitDAO;
import fr.fiegel.objects.Produit;
import fr.fiegel.utils.StrUtils;
import fr.fiegel.utils.Utils;

@SuppressWarnings("serial")
public class RechercheProduitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute(Utils.USER_CO) == null){
				resp.sendRedirect("login");
				return;
			}
			
			String ident = req.getParameter("champ");
			String valeur = req.getParameter("valeur");
			String desc = req.getParameter("desc");
			boolean asc =StrUtils.isNullOrEmpty(desc);
			if(StrUtils.isNullOrEmpty(ident) || StrUtils.isNullOrEmpty(valeur)){
				resp.sendRedirect("listeProduits");
				return;
			}
			ProduitDAO dao = new ProduitDAO();
			ArrayList<Produit> produits = new ArrayList<Produit>(dao.rechercherProduit(asc, ident, valeur));
			dao.closeConnection();
			req.setAttribute("recherche", true);
			req.setAttribute("produits", produits);
			req.getRequestDispatcher("jsp/ListeProduits.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}
	
}
