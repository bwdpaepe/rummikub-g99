package talen;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

public class Language {
	private static final Language LANGUAGE_INSTANCE = new Language();
	
	private static ResourceBundle bundle = ResourceBundle.getBundle("talen.ApplicationMessage"); 
	
	public static String getString(String key) { 
		return bundle.getString(key);  
	}
	
	public static ResourceBundle getBundle() {
		return bundle;
	}
	
	public void setBundle(ResourceBundle bundle) {
        Language.bundle = bundle;
    }
	
	public Language() {
		
	}
	
	public static Language getInstance() {
		return LANGUAGE_INSTANCE; 
		
	}
	public static Locale selecteerTaal(String taal) {
		// weten uit welke ApplicatieMessage er moet worden gekozen
		String lang = "";
		String country = "";
		if (taal == "engels") { // kan je eventeel linken aan button
			lang = "eng"; //Moet gelijk zijn aan met er na _ staat in properties --> niet hoofdlettergevoelig
			country = "USA";
		} if (taal == "nl") { // kan je eventeel linken aan button
			lang = "nl"; //Moet gelijk zijn aan met er na _ staat in properties
			country = "BE";
		}
		Locale l = new Locale(lang, country);
		return l;
	}
	
/*
	public static void main(String[] args) {
		//handmating taal selecteren
		String taal = "engels";
		
		// weten uit welke ApplicatieMessage er moet worden gekozen
		String lang = "";
		String country = "";
		if (taal == "engels") {
			lang = "eng"; //Moet gelijk zijn aan met er na _ staat in properties --> niet hoofdlettergevoelig
			country = "USA";
		} if (taal == "nl") {
			lang = "nl"; //Moet gelijk zijn aan met er na _ staat in properties
			country = "BE";
		}
		Locale l = new Locale(lang, country);
		
		//algemene code om zin om te zetten
		ResourceBundle bundle = ResourceBundle.getBundle("talen.ApplicationMessage", l); // talen is package naam waar properties inzitten
		
		//wat er in de plaats moet van de zin -> tussen "" komt de variabele voor deze zin
		//System.out.println(bundle.getString("geefGebruikersnaam"));
		
		// Zelfde effect als lijn 65 hierboven maar met methode.
		System.out.printf(getString("vragenAantalSpelers"));

	}
	*/

}
