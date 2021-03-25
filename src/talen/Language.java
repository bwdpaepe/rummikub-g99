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
	
	private ResourceBundle bundle = ResourceBundle.getBundle("talen.ApplicationMessage"); 
	
	public String getString(String key) { 
		return bundle.getString(key); 
	}
	
	public ResourceBundle getBundle() {
		return bundle;
	}
	
	public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }
	
	public Language() {
		
	}
	
	public static Language getInstance() {
		return LANGUAGE_INSTANCE; 
		
	}
	

}
