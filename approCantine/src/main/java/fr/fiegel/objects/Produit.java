package fr.fiegel.objects;

import java.util.Calendar;

public class Produit {

	protected int ident;
	protected String libelle;
	protected String marque;
	protected String conditionnement;
	protected String reference;
	protected double prix_achat;
	protected int min_rupture;
	protected Calendar date_peremption;

	
	public Produit(){
		this.date_peremption=Calendar.getInstance();
	}
	
	public Produit(int ident, String libelle, String marque, String conditionnement, String ref, double prix_achat, int rupture, Calendar peremption){
		this.ident=ident;
		this.libelle=libelle;
		this.marque=marque;
		this.conditionnement=conditionnement;
		this.reference=ref;
		this.prix_achat=prix_achat;
		this.min_rupture=rupture;
		this.date_peremption=peremption;
	}

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getContionnement() {
		return conditionnement;
	}

	public void setContionnement(String contionnement) {
		this.conditionnement = contionnement;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public double getPrix_achat() {
		return prix_achat;
	}

	public void setPrix_achat(double prix_achat) {
		this.prix_achat = prix_achat;
	}

	public int getMin_rupture() {
		return min_rupture;
	}

	public void setMin_rupture(int min_rupture) {
		this.min_rupture = min_rupture;
	}

	public Calendar getDate_peremption() {
		return date_peremption;
	}

	public void setDate_peremption(Calendar date_peremption) {
		this.date_peremption = date_peremption;
	}

	@Override
	public String toString() {
		return "Produit [ident=" + ident + ", libelle=" + libelle + ", marque=" + marque + ", contionnement="
				+ conditionnement + ", reference=" + reference + ", prix_achat=" + prix_achat + ", min_rupture="
				+ min_rupture + ", date_peremption=" + date_peremption + "]";
	}
	
	
	
}
