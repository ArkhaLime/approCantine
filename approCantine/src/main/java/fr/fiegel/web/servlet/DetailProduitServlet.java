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
public class DetailProduitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			if(session.getAttribute(Utils.USER_CO) == null){
				resp.sendRedirect("login");
				return;
			}
			
			String ident = req.getParameter("ident");
			Produit produit=null;
			if(!StrUtils.isNullOrEmpty(ident)){
				ProduitDAO dao = new ProduitDAO();
				produit = dao.getProduitByIdent(Integer.parseInt(ident));
				dao.closeConnection();
			}else{
				produit = new Produit();
			}
			
			/*if(produit==null){
				resp.sendRedirect("listeProduit");
				return;
			}*/
			req.setAttribute("produit", produit);
			req.getRequestDispatcher("jsp/DetailProduit.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}

}
