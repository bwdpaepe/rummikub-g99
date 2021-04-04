package talen;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
	private static final Language LANGUAGE_INSTANCE = new Language();

	private ResourceBundle bundle;
	
	public void stelTaalIn(String lang, String country) { //Methode 1: Juiste resourcebundle gecreerd en bijgehouden
		Locale l = new Locale(lang, country);
		ResourceBundle bundle = ResourceBundle.getBundle("talen.ApplicationMessage", l);
		setBundle(bundle);
	}

	public String getString(String key) { //Methode 2: String wordt meegegeven met sleutel
		return bundle.getString(key);
	}

	public ResourceBundle getBundle() {
		return bundle;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	public static Language getInstance() {
		return LANGUAGE_INSTANCE; 
		
	}

}
