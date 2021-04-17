package talen;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

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

	private void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	private static Language getInstance() { // heb dit prive gezet, andere klassen moeten hier niet mee werken
		return LANGUAGE_INSTANCE; 
		
	}

}
