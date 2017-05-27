package fr.fiegel.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.fiegel.dao.ProduitDAO;
import fr.fiegel.objects.Produit;
import fr.fiegel.utils.Utils;

@SuppressWarnings("serial")
public class ListeProduitsPerimesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute(Utils.USER_CO) == null){
				resp.sendRedirect("login");
				return;
			}
			ProduitDAO dao = new ProduitDAO();
			int nbJours=14;
			Object tmp = req.getParameter("nbJours");
			if(tmp!=null) {
				nbJours=Integer.parseInt(tmp.toString());
			}
			req.setAttribute("nbJours", String.valueOf(nbJours));
			ArrayList<Produit> produits = new ArrayList<Produit>( dao.rechercherProduitPerimes(true, nbJours));
			req.setAttribute("produits", produits);
			req.setAttribute("showPerime", true);
			req.setAttribute("titre", "Liste des produits proches de la péremption");
			req.getRequestDispatcher("jsp/ListeProduits.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}

}
