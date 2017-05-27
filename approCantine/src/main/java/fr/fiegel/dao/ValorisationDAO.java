package fr.fiegel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.fiegel.objects.Valorisation;

public class ValorisationDAO extends AbstractDAO<Valorisation> {

	private static final String COLONNE_VALEUR_TOT = "valeurTotale";
	private static final String COLONNE_VALEUR_PERIME = "valeurPerime";

	public ValorisationDAO() {
		super();
	}

	public Valorisation getValorisation() throws SQLException {
		String requete = "select " + COLONNE_VALEUR_TOT + ", " + COLONNE_VALEUR_PERIME
				+ " from (select sum(quantite*prix_achat) as " + COLONNE_VALEUR_TOT
				+ " from produit where archive=0) as t1, (select sum(quantite*prix_achat) as " + COLONNE_VALEUR_PERIME
				+ " from produit where datediff(date_peremption,curdate())<=0 and archive=0) as t2";
		try {
			Statement stmt = connexion.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			if (result.next())
				return fromResultSet(result);
			return null;
		} catch (SQLException e) {
			System.out.println("ValorisationDAO#getProduitByIdent");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	protected Valorisation fromResultSet(ResultSet result) throws SQLException {
		return new Valorisation(result.getDouble(COLONNE_VALEUR_TOT), result.getDouble(COLONNE_VALEUR_PERIME));
	}

}
