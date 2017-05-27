package fr.fiegel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.fiegel.objects.Menu;
import fr.fiegel.objects.Produit;

public class MenuDAO extends AbstractDAO<Menu> {

	private static final String COLONNE_MENU_IDENT = "ident";
	private static final String COLONNE_MENU_DATE = "date";

	// table compo_menu
	private static final String COLONNE_COMPO_MENU = "ident_menu";
	private static final String COLONNE_COMPO_PRODUIT = "ident_produit";

	public MenuDAO() {
		super();
	}

	public Menu getMenuByIdent(int ident) throws SQLException {
		String requeteEntete = "SELECT " + COLONNE_MENU_IDENT + "," + COLONNE_MENU_DATE + " from menu where "
				+ COLONNE_MENU_IDENT + " = " + ident;
		try {
			Statement stmt = connexion.createStatement();
			ResultSet result = stmt.executeQuery(requeteEntete);
			if (result.next()) {
				Menu menu = fromResultSet(result);
				ProduitDAO dao = new ProduitDAO();
				ArrayList<Produit> produits = new ArrayList<>(dao.rechercherProduitByMenu(menu.getIdent()));
				menu.setProduits(produits);
				dao.closeConnection();
				return menu;
			}

			return null;
		} catch (SQLException e) {
			System.out.println("MenuDAO#getMenuByIdent");
			e.printStackTrace();
			throw e;
		}
	}

	public List<Menu> getMenus(boolean orderbyAsc) throws SQLException {
		String requete = "SELECT " + COLONNE_MENU_IDENT + "," + COLONNE_MENU_DATE + " from menu order by "
				+ COLONNE_MENU_DATE;
		if (orderbyAsc) {
			requete += " ASC";
		} else {
			requete += " DESC";
		}
		try {
			ArrayList<Menu> menus = new ArrayList<>();
			ProduitDAO dao = new ProduitDAO();
			Statement stmt = connexion.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				Menu menu = fromResultSet(result);
				ArrayList<Produit> produits = new ArrayList<>(dao.rechercherProduitByMenu(menu.getIdent()));
				menu.setProduits(produits);
				menus.add(menu);
			}
			dao.closeConnection();
			return menus;
		} catch (SQLException e) {
			System.out.println("MenuDAO#getMenus");
			e.printStackTrace();
			throw e;
		}
	}

	public List<Menu> getMenusByDate(boolean orderbyAsc, LocalDate date) throws SQLException {
		String requete = "SELECT " + COLONNE_MENU_IDENT + "," + COLONNE_MENU_DATE + " from menu where "
				+ COLONNE_MENU_DATE + " = '" + date.toString() + "' order by " + COLONNE_MENU_DATE;
		if (orderbyAsc) {
			requete += " ASC";
		} else {
			requete += " DESC";
		}
		System.out.println(requete);
		try {
			ArrayList<Menu> menus = new ArrayList<>();
			ProduitDAO dao = new ProduitDAO();
			Statement stmt = connexion.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				Menu menu = fromResultSet(result);
				ArrayList<Produit> produits = new ArrayList<>(dao.rechercherProduitByMenu(menu.getIdent()));
				menu.setProduits(produits);
				menus.add(menu);
			}
			dao.closeConnection();
			return menus;
		} catch (SQLException e) {
			System.out.println("MenuDAO#getMenusByDate");
			e.printStackTrace();
			throw e;
		}
	}

	public void insertMenu(LocalDate date, String[] produits) throws SQLException {
		String requeteEntete = "INSERT INTO menu(" + COLONNE_MENU_DATE + ") " + " VALUE (?);";
		String requeteIdent = "SELECT " + COLONNE_MENU_IDENT + " from menu ORDER BY " + COLONNE_MENU_IDENT
				+ " DESC LIMIT 1";
		String requeteCompo = "insert into compo_menu (" + COLONNE_COMPO_MENU + "," + COLONNE_COMPO_PRODUIT
				+ ") values (?,?)";

		PreparedStatement insertMenu = null;
		PreparedStatement selectIdent = null;
		PreparedStatement insertCompo = null;

		try {
			connexion.setAutoCommit(false);

			insertMenu = connexion.prepareStatement(requeteEntete);
			insertMenu.setString(1, date.toString());
			insertMenu.executeUpdate();

			selectIdent = connexion.prepareStatement(requeteIdent);
			ResultSet result = selectIdent.executeQuery();
			result.next();
			int ident = result.getInt(COLONNE_MENU_IDENT);

			insertCompo = connexion.prepareStatement(requeteCompo);
			insertCompo.setInt(1, ident);
			int length = produits.length;
			for (int i = 0; i < length; i++) {
				insertCompo.setInt(2, Integer.parseInt(produits[i].trim()));
				insertCompo.executeUpdate();
			}

			connexion.commit();

		} catch (SQLException e) {
			connexion.rollback();
			System.out.println("ProduitDAO#insertProduit");
			e.printStackTrace();
			throw e;
		} finally {
			if (insertMenu != null)
				insertMenu.close();
			if (selectIdent != null)
				selectIdent.close();
			if (insertCompo != null)
				insertCompo.close();
		}
	}

	@Override
	protected Menu fromResultSet(ResultSet result) throws SQLException {
		return new Menu(result.getInt(COLONNE_MENU_IDENT), LocalDate.parse(result.getString(COLONNE_MENU_DATE)));
	}

}
