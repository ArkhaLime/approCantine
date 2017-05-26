package fr.fiegel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.fiegel.objects.User;
import fr.fiegel.utils.StrUtils;

public class UserDAO extends AbstractDAO<User> {

	private static final String COLONNE_IDENT = "ident";
	private static final String COLONNE_NOM = "nom";
	private static final String COLONNE_PRENOM = "prenom";
	private static final String COLONNE_EMAIL = "email";
	private static final String COLONNE_MDP = "mdp";

	public UserDAO() {
		super();
	}

	public User connect(String email, String mdp) throws SQLException {
		System.out.println("UserDao.connect('"+email+"','"+mdp+"')");
		String requete = "SELECT " + COLONNE_IDENT + "," + COLONNE_NOM + "," + COLONNE_PRENOM + "," + COLONNE_EMAIL
				+ "," + COLONNE_MDP + " FROM User WHERE " + COLONNE_EMAIL + "='" + email + "' AND " + COLONNE_MDP + " = '"
				+ mdp+"'";
		//if(email.trim().equals("") || mdp.trim().equals("")) return null;
		if(StrUtils.isNullOrEmpty(email) || StrUtils.isNullOrEmpty(mdp)) return null;
		try {
			Statement stmt = connexion.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			if(result.next()){
				return fromResultSet(result);
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			System.out.println("UserDAO#connect");
			e.printStackTrace();
			throw e;
		}
	}

	public void insertUser(User utilisateur) throws SQLException {
		String requete = "INSERT INTO User(" + COLONNE_NOM + "," + COLONNE_PRENOM + "," + COLONNE_EMAIL + ","
				+ COLONNE_MDP + ") " + " VALUES " + "('" + utilisateur.getNom() + "','" + utilisateur.getPrenom()
				+ "','" + utilisateur.getEmail() + "','" + utilisateur.getMdp() + "');";
		try {
			Statement stmt = connexion.createStatement();
			stmt.executeUpdate(requete);
			ResultSet result = stmt
					.executeQuery("SELECT " + COLONNE_IDENT + " from User ORDER BY " + COLONNE_IDENT + " DESC LIMIT 1");
			result.next();
			int index = result.getInt(1);
			utilisateur.setIdent(index);
		} catch (SQLException e) {
			System.out.println("UserDAO#insertUser");
			e.printStackTrace();
			throw e;
		}
	}

	public void updateUser(User utilisateur) throws SQLException {
		String requete = "UPDATE User SET " + COLONNE_NOM + "= '" + utilisateur.getNom() + "', " + COLONNE_PRENOM + "='"
				+ utilisateur.getPrenom() + "', " + COLONNE_EMAIL + "='" + utilisateur.getEmail() + "', " + COLONNE_MDP
				+ "='" + utilisateur.getMdp() + "' WHERE " + COLONNE_IDENT + "=" + utilisateur.getIdent();
		try {
			Statement stmt = connexion.createStatement();
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			System.out.println("UserDAO#updateUser");
			e.printStackTrace();
			throw e;
		}
	}

	public User getUserByIdent(int ident) throws SQLException {
		String requete = "SELECT " + COLONNE_IDENT + "," + COLONNE_NOM + "," + COLONNE_PRENOM + "," + COLONNE_EMAIL
				+ "," + COLONNE_MDP + " FROM User WHERE " + COLONNE_IDENT + "=" + ident;
		try {
			Statement stmt = connexion.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			result.next();
			return fromResultSet(result);
		} catch (SQLException e) {
			System.out.println("UserDAO#getUserByIdent");
			e.printStackTrace();
			throw e;
		}
	}

	public void deleteUser(User utilisateur) throws SQLException {
		try {
			String requete = "DELETE FROM User WHERE " + COLONNE_IDENT + "=" + utilisateur.getIdent();
			Statement stmt = connexion.createStatement();
			stmt.executeUpdate(requete);
		} catch (SQLException e) {
			System.out.println("UserDAO#deleteUser");
			e.printStackTrace();
			throw e;
		}
	}

	public List<User> rechercherUser(boolean orderbyAsc) throws SQLException {
		String requete = "SELECT " + COLONNE_IDENT + "," + COLONNE_NOM + "," + COLONNE_PRENOM + "," + COLONNE_EMAIL
				+ "," + COLONNE_MDP + " FROM User ORDER BY " + COLONNE_IDENT;
		if (orderbyAsc) {
			requete += " ASC";
		} else {
			requete += " DESC";
		}
		try {
			Statement stmt = connexion.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			List<User> liste = new ArrayList<>();
			while (result.next()) {
				liste.add(fromResultSet(result));
			}
			return liste;
		} catch (SQLException e) {
			System.out.println("UserDAO#rechercherUser");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	protected User fromResultSet(ResultSet result) throws SQLException {
		return new User(result.getInt(COLONNE_IDENT), result.getString(COLONNE_NOM), result.getString(COLONNE_PRENOM),
				result.getString(COLONNE_EMAIL), result.getString(COLONNE_MDP));
	}

}
