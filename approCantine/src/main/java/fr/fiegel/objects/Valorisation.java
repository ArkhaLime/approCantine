package fr.fiegel.objects;

public class Valorisation {
	
	private double valeurTotale;
	private double valeurPerime;
	
	public Valorisation() {}
	
	public Valorisation(double valeurTotale, double valeurPerime){
		this.valeurTotale=valeurTotale;
		this.valeurPerime=valeurPerime;
	}

	public double getValeurTotale() {
		return valeurTotale;
	}

	public void setValeurTotale(double valeurTotale) {
		this.valeurTotale = valeurTotale;
	}

	public double getValeurPerime() {
		return valeurPerime;
	}

	public void setValeurPerime(double valeurPerime) {
		this.valeurPerime = valeurPerime;
	}
	
	
}
