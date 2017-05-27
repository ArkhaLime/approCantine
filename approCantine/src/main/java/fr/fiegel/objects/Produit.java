package fr.fiegel.objects;

import java.time.LocalDate;
import java.time.Period;

import fr.fiegel.utils.CalUtils;

public class Produit {

	protected int ident;
	protected String libelle;
	protected String marque;
	protected String conditionnement;
	protected String reference;
	protected double prix_achat;
	protected int min_rupture=1;
	protected LocalDate date_peremption;
	protected int quantite=1;
	
	protected static final int COEF_RUPTURE=2;

	
	public Produit(){
		this.date_peremption=LocalDate.now();
	}
	
	public Produit(int ident, String libelle, String marque, String conditionnement, String ref, double prix_achat, int rupture, LocalDate peremption,int quantite){
		this.ident=ident;
		this.libelle=libelle;
		this.marque=marque;
		this.conditionnement=conditionnement;
		this.reference=ref;
		this.prix_achat=prix_achat;
		this.min_rupture=rupture;
		this.date_peremption=peremption;
		this.quantite=quantite;
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

	public String getConditionnement() {
		return conditionnement;
	}

	public void setConditionnement(String conditionnement) {
		this.conditionnement = conditionnement;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public double getPrixAchat() {
		return prix_achat;
	}

	public void setPrixAchat(double prix_achat) {
		this.prix_achat = prix_achat;
	}

	public int getMinRupture() {
		return min_rupture;
	}

	public void setMinRupture(int min_rupture) {
		this.min_rupture = min_rupture;
	}

	public LocalDate getDatePeremption() {
		return date_peremption;
	}
	
	public String getFrDatePeremption(){
		return CalUtils.toDMYString(this.date_peremption);
	}

	public void setDatePeremption(LocalDate date_peremption) {
		this.date_peremption = date_peremption;
	}
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	//ne donne pas le nb de jours entre les deux dates mais juste le champ day de la période mais permet au moins de savoir si la date est dépassée ou non
	public int getNbJoursAvantPeremption(){
		Period interval = Period.between(LocalDate.now(), date_peremption);
		return interval.getDays();
	}
	
	public boolean isPerime(){
		int comp=date_peremption.compareTo(LocalDate.now());
		if(comp<0)return true;
		return false;
	}
	
	public boolean isRupture(){
		return (quantite<=min_rupture);
	}
	
	public boolean isBientotRupture(){
		return (quantite<=min_rupture*COEF_RUPTURE && quantite>min_rupture);
	}
	
	public String getIntervalAvantPeremption(){
		Period interval = Period.between(LocalDate.now(), date_peremption); 
		String res= "";
		if(interval.getDays()!=0) res += interval.getDays()+"j ";
		if(interval.getMonths()!=0) res+= interval.getMonths()+"m ";
		if(interval.getYears()!=0) res += interval.getYears()+"a";
		return res.trim();
	}

	@Override
	public String toString() {
		return "Produit [ident=" + ident + ", libelle=" + libelle + ", marque=" + marque + ", contionnement="
				+ conditionnement + ", reference=" + reference + ", prix_achat=" + prix_achat + ", min_rupture="
				+ min_rupture + ", date_peremption=" + date_peremption + "]";
	}
	
	
	
}
