package fr.fiegel.web.servlet;

import java.io.IOException;

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
public class DeleteProduitServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute(Utils.USER_CO) == null){
				resp.sendRedirect("login");
				return;
			}
			ProduitDAO dao = new ProduitDAO();
			String ident = req.getParameter("ident");
			if(StrUtils.isNullOrEmpty(ident)){
				throw new IllegalArgumentException("L'identifiant du produit ne peut être null");
			}
			Produit produit = dao.getProduitByIdent(Integer.parseInt(ident));
			if(produit==null){
				throw new Exception("Aucun produit ne correspond à l'identfiant '"+ident+"'");
			}
			dao.deleteProduit(produit);
			dao.closeConnection();
			//req.getRequestDispatcher("jsp/ListeProduits.jsp").forward(req, resp);
			resp.sendRedirect("listeProduits");
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}
	
}
