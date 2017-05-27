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
import fr.fiegel.dao.ValorisationDAO;
import fr.fiegel.objects.Produit;
import fr.fiegel.objects.Valorisation;
import fr.fiegel.utils.Utils;

@SuppressWarnings("serial")
public class ListeProduitsServlet extends HttpServlet {

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
			ValorisationDAO dao2 = new ValorisationDAO();
			Valorisation valeur = dao2.getValorisation();
			dao.closeConnection();
			dao2.closeConnection();
			req.setAttribute("produits", produits);
			req.setAttribute("valorisation", valeur);
			req.getRequestDispatcher("jsp/ListeProduits.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}
	
	

}
