package fr.fiegel.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalUtils {

	public static final String DATE_FR_PATTERN="dd'/'MM'/'yyyy";
	//public static final String DATE_FR_PATTERN="dd/MM/uuuu";
	public static final DateTimeFormatter FR_FORMATTER = DateTimeFormatter.ofPattern(DATE_FR_PATTERN);
	
	public static String toDMYString(LocalDate date){
		return date.format(FR_FORMATTER);
	}
	
	public static LocalDate fromDMYString(String dateDMY){
		return LocalDate.parse(dateDMY, FR_FORMATTER);
	}
	
	
	//partie prévue au début avec l'utilisation du Calendar avant de faire connaissance avec l'API java.time du SE8
	/*public static Calendar fromYMDString(String date){
		String[] parties = decoupeDate(date);
		if(parties.length!=3) throw new IllegalArgumentException("La date doit être au format 'yyyy-MM-dd'");
		int annee = Integer.parseInt(parties[0]);
		int mois = Integer.parseInt(parties[1]);
		int jour = Integer.parseInt(parties[2]);
		Calendar cal = Calendar.getInstance();
		cal.set(annee, mois, jour);
		return cal;	
	}
	
	public static Calendar fromDMYString(String date){
		String[] parties = decoupeDate(date);
		if(parties.length!=3) throw new IllegalArgumentException("La date doit être au format 'dd-MM-yyyy'");
		int annee = Integer.parseInt(parties[2]);
		int mois = Integer.parseInt(parties[1]);
		int jour = Integer.parseInt(parties[0]);
		Calendar cal = Calendar.getInstance();
		cal.set(annee, mois, jour);
		return cal;	
	}
	
	private static String[] decoupeDate(String date){
		if(date.contains("-")) return date.split("-");
		if(date.contains("/")) return date.split("/");
		return new String[0];
	}*/
	

}
