package i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class i18nExample {

	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("i18n.ApplicationMessage_NL");
		ResourceBundle bundleENG = ResourceBundle.getBundle("i18n.ApplicationMessage_ENG", Locale.ENGLISH);
			
		System.out.println(bundle.getString("geefGebruikersnaam"));
		System.out.println(bundleENG.getString("geefGebruikersnaam"));

	}

}
