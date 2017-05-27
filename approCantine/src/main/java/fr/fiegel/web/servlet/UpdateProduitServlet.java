package fr.fiegel.web.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.fiegel.dao.ProduitDAO;
import fr.fiegel.objects.Produit;
import fr.fiegel.utils.CalUtils;
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
			Produit produitInBdd = dao.getProduitByIdent(Integer.parseInt(req.getParameter("ident").toString()));
			Produit produit = new Produit();
			boolean erreur = false;
			
			//récupération des champs et traitements
			int ident = Integer.parseInt(req.getParameter("ident").toString());
			produit.setIdent(ident);
			String libelle = req.getParameter("libelle").toString();
			produit.setLibelle(libelle);
			String marque = req.getParameter("marque").toString();
			produit.setMarque(marque);
			String conditionnement = req.getParameter("conditionnement").toString();
			produit.setConditionnement(conditionnement);
			String reference = req.getParameter("reference").toString();
			produit.setReference(reference);
			try {
				double prixAchat = Double.parseDouble(req.getParameter("prix_achat").toString());
				produit.setPrixAchat(prixAchat);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				req.setAttribute("prix_achat_erreur", "Le prix d'achat doit être au format 0.00");
				erreur=true;
			}
			try {
				int minRupture = Integer.parseInt(req.getParameter("min_rupture").toString());
				produit.setMinRupture(minRupture);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				req.setAttribute("min_rupture_erreur", "Le minimum avant rupture doit être un nombre >= 1");
				erreur=true;
			}
			try {
				int quantite = Integer.parseInt(req.getParameter("quantite").toString());
				produit.setQuantite(quantite);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				req.setAttribute("quantite_erreur", "Le quantité doit être un nombre >= 1");
				erreur=true;
			}
			LocalDate datePeremption = CalUtils.fromDMYString(req.getParameter("date_peremption").toString());
			produit.setDatePeremption(datePeremption);
			if(erreur){
				req.setAttribute("produit", produit);
				req.getRequestDispatcher("jsp/DetailProduit.jsp").forward(req, resp);
				return;
			}
			
			//insertion ou maj selon présence dans BDD
			if(produitInBdd==null){
				dao.insertProduit(produit);
			}else{
				dao.updateProduit(produit);
			}
			dao.closeConnection();
			resp.sendRedirect("listeProduits");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("exception", e);
			req.getRequestDispatcher("jsp/Exception.jsp").forward(req, resp);
		}
	}

}
