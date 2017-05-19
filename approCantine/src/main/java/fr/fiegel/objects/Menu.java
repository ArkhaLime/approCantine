package fr.fiegel.objects;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Menu {

	protected int ident;
	protected Calendar date;
	protected Set<Produit> produits;
	
	public Menu(){
		produits = new HashSet<>();
		date = Calendar.getInstance();
	}
	
	public Menu(int ident, Calendar date){
		this.ident=ident;
		this.date=date;
	}
	
	public Menu(int ident, Calendar date, Set<Produit> produits){
		this.ident=ident;
		this.date=date;
		this.produits=produits;
	}
	
}
