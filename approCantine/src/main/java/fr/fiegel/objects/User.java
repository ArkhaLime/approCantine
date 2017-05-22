package fr.fiegel.objects;

public class User {

	protected int ident;
	protected String nom;
	protected String prenom;
	protected String email;
	protected String mdp;

	public User() {
	}

	public User(int ident, String nom, String prenom, String email, String mdp) {
		this.ident = ident;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getIdentite() {
		return prenom + " " + nom;
	}

	@Override
	public String toString() {
		return "User [ident=" + ident + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}

}
