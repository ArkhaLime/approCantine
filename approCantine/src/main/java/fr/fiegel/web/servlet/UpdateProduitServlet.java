package fr.fiegel.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.fiegel.dao.ProduitDAO;
import fr.fiegel.objects.Produit;
import fr.fiegel.utils.Utils;

@SuppressWarnings("serial")
public class UpdateProduitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("jsp/DetailProduit.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute(Utils.USER_CO) == null){
				resp.sendRedirect("login");
				return;
			}
			ProduitDAO dao = new ProduitDAO();
			Produit produitInBdd = dao.getProduitByIdent(Integer.parseInt(req.getAttribute("ident").toString()));
			Produit produit = new Produit();
			//TODO: remplir les champs de produit
			if(produitInBdd==null){
				dao.insertProduit(produit);
			}else{
				dao.updateProduit(produit);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}

}
