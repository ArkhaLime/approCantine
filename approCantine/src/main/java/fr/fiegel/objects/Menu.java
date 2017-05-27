package fr.fiegel.objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.fiegel.utils.CalUtils;

public class Menu {

	protected int ident;
	protected LocalDate date;
	protected ArrayList<Produit> produits;
	
	public Menu(){
		produits = new ArrayList<>();
		date = LocalDate.now();
	}
	
	public Menu(int ident, LocalDate date){
		this.ident=ident;
		this.date=date;
	}
	
	public Menu(int ident, LocalDate date, ArrayList<Produit> produits){
		this.ident=ident;
		this.date=date;
		this.produits=produits;
	}

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getFrDate() {
		return CalUtils.toDMYString(this.date);
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}
	
	
	
}
