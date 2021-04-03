package talen;

import java.util.ResourceBundle;

public class Language {
	private static final Language LANGUAGE_INSTANCE = new Language();

	private ResourceBundle bundle;

	public String getString(String key) {
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
