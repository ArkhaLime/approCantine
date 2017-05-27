package fr.fiegel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.fiegel.objects.Produit;

public class ProduitDAO extends AbstractDAO<Produit> {

	private static final String COLONNE_IDENT = "ident";
	private static final String COLONNE_LIBELLE = "libelle";
	private static final String COLONNE_MARQUE = "marque";
	private static final String COLONNE_CONDITIONNEMENT = "conditionnement";
	private static final String COLONNE_REFERENCE = "reference";
	private static final String COLONNE_PRIX = "prix_achat";
	private static final String COLONNE_RUPTURE = "min_rupture";
	private static final String COLONNE_PEREMPTION = "date_peremption";
	private static final String COLONNE_QUANTITE = "quantite";

	public ProduitDAO() {
		super();
	}

	public void insertProduit(Produit produit) throws SQLException {
		String requete = "INSERT INTO Produit(" + COLONNE_LIBELLE + "," + COLONNE_MARQUE + "," + COLONNE_CONDITIONNEMENT
				+ "," + COLONNE_REFERENCE + "," + COLONNE_PRIX + "," + COLONNE_RUPTURE + "," + COLONNE_PEREMPTION + ") "
				+ " VALUES " + "('" + produit.getLibelle() + "','" + produit.getMarque() + "','"
				+ produit.getConditionnement() + "','" + produit.getReference() + "','" + produit.getPrixAchat() + "','"
				+ produit.getMinRupture() + "','" + produit.getDatePeremption().toString() + "');";
		try {
			Statement stmt = connexion.createStatement();
			stmt.executeUpdate(requete);
			ResultSet result = stmt.executeQuery(
					"SELECT " + COLONNE_IDENT + " from Produit ORDER BY " + COLONNE_IDENT + " DESC LIMIT 1");
			result.next();
			int index = result.getInt(1);
			produit.setIdent(index);
		} catch (SQLException e) {
			System.out.println("ProduitDAO#insertProduit");
			e.printStackTrace();
			throw e;
		}
	}

	public void updateProduit(Produit produit) throws SQLException {
		String requete = "UPDATE Produit SET " + COLONNE_LIBELLE + "= '" + produit.getLibelle() + "', " + COLONNE_MARQUE
				+ "='" + produit.getMarque() + "', " + COLONNE_CONDITIONNEMENT + "='" + produit.getConditionnement()
				+ "', " + COLONNE_REFERENCE + "='" + produit.getReference() + "', " + COLONNE_PRIX + "='"
				+ produit.getPrixAchat() + "', " + COLONNE_RUPTURE + "='" + produit.getMinRupture() + "', "
				+ COLONNE_PEREMPTION + "='" + produit.getDatePeremption().toString() + "', " + COLONNE_QUANTITE + "='"
				+ produit.getQuantite() + "' WHERE " + COLONNE_IDENT + "=" + produit.getIdent();
		try {
			Statement stmt = connexion.createStatement();
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			System.out.println("ProduitDAO#updateProduit");
			e.printStackTrace();
			throw e;
		}
	}

	public Produit getProduitByIdent(int ident) throws SQLException {
		String requete = "SELECT " + COLONNE_IDENT + "," + COLONNE_LIBELLE + "," + COLONNE_MARQUE + ","
				+ COLONNE_CONDITIONNEMENT + "," + COLONNE_REFERENCE + "," + COLONNE_PRIX + "," + COLONNE_RUPTURE + ","
				+ COLONNE_PEREMPTION + "," + COLONNE_QUANTITE + " FROM Produit WHERE " + COLONNE_IDENT + "=" + ident;
		try {
			Statement stmt = connexion.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			if (result.next())
				return fromResultSet(result);
			return null;
		} catch (SQLException e) {
			System.out.println("ProduitDAO#getProduitByIdent");
			e.printStackTrace();
			throw e;
		}
	}

	public void deleteProduit(Produit produit) throws SQLException {
		try {
			String requete = "DELETE FROM Produit WHERE " + COLONNE_IDENT + "=" + produit.getIdent();
			Statement stmt = connexion.createStatement();
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			System.out.println("ProduitDAO#deleteProduit");
			e.printStackTrace();
			throw e;
		}
	}

	public List<Produit> rechercherProduit(boolean orderbyAsc) throws SQLException {
		String requete = "SELECT " + COLONNE_IDENT + "," + COLONNE_LIBELLE + "," + COLONNE_MARQUE + ","
				+ COLONNE_CONDITIONNEMENT + "," + COLONNE_REFERENCE + "," + COLONNE_PRIX + "," + COLONNE_RUPTURE + ","
				+ COLONNE_PEREMPTION + "," + COLONNE_QUANTITE + " FROM Produit ORDER BY " + COLONNE_IDENT;
		if (orderbyAsc) {
			requete += " ASC";
		} else {
			requete += " DESC";
		}
		// System.out.println(requete);
		try {
			Statement stmt = connexion.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			List<Produit> liste = new ArrayList<>();
			while (result.next()) {
				liste.add(fromResultSet(result));
			}
			return liste;
		} catch (SQLException e) {
			System.out.println("ProduitDAO#rechercherProduit");
			e.printStackTrace();
			throw e;
		}
	}

	public List<Produit> rechercherProduitRupture(boolean orderbyAsc, int coefRupture) throws SQLException {
		String requete = "SELECT " + COLONNE_IDENT + "," + COLONNE_LIBELLE + "," + COLONNE_MARQUE + ","
				+ COLONNE_CONDITIONNEMENT + "," + COLONNE_REFERENCE + "," + COLONNE_PRIX + "," + COLONNE_RUPTURE + ","
				+ COLONNE_PEREMPTION + "," + COLONNE_QUANTITE + ",(" + COLONNE_QUANTITE + "-" + COLONNE_RUPTURE
				+ ") rupture FROM Produit where ("+COLONNE_QUANTITE+"<="+COLONNE_RUPTURE+"*"+ coefRupture +") ORDER BY rupture";
		if (orderbyAsc) {
			requete += " ASC";
		} else {
			requete += " DESC";
		}
		// System.out.println(requete);
		try {
			Statement stmt = connexion.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			List<Produit> liste = new ArrayList<>();
			while (result.next()) {
				liste.add(fromResultSet(result));
			}
			return liste;
		} catch (SQLException e) {
			System.out.println("ProduitDAO#rechercherProduit");
			e.printStackTrace();
			throw e;
		}
	}

	public List<Produit> rechercherProduitPerimes(boolean orderbyAsc) throws SQLException {
		return rechercherProduitPerimes(orderbyAsc, 14);
	}

	public List<Produit> rechercherProduitPerimes(boolean orderbyAsc, int nbJours) throws SQLException {
		String requete = "SELECT " + COLONNE_IDENT + "," + COLONNE_LIBELLE + "," + COLONNE_MARQUE + ","
				+ COLONNE_CONDITIONNEMENT + "," + COLONNE_REFERENCE + "," + COLONNE_PRIX + "," + COLONNE_RUPTURE + ","
				+ COLONNE_PEREMPTION + "," + COLONNE_QUANTITE + ",datediff(" + COLONNE_PEREMPTION
				+ ",curdate()) interv FROM Produit where datediff(" + COLONNE_PEREMPTION + ",curdate())<=" + nbJours
				+ " ORDER BY interv";
		if (orderbyAsc) {
			requete += " ASC";
		} else {
			requete += " DESC";
		}
		System.out.println(requete);
		try {
			Statement stmt = connexion.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			List<Produit> liste = new ArrayList<>();
			while (result.next()) {
				liste.add(fromResultSet(result));
			}
			return liste;
		} catch (SQLException e) {
			System.out.println("ProduitDAO#rechercherProduit");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	protected Produit fromResultSet(ResultSet result) throws SQLException {
		return new Produit(result.getInt(COLONNE_IDENT), result.getString(COLONNE_LIBELLE),
				result.getString(COLONNE_MARQUE), result.getString(COLONNE_CONDITIONNEMENT),
				result.getString(COLONNE_REFERENCE), result.getDouble(COLONNE_PRIX), result.getInt(COLONNE_RUPTURE),
				LocalDate.parse(result.getString(COLONNE_PEREMPTION)), result.getInt(COLONNE_QUANTITE));
	}

}
