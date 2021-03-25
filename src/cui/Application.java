package cui;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import domein.Spel;
import exceptions.BuitenBereikAantalSpelersException;
import exceptions.SpelerNietInDBException;
import exceptions.SpelerReedsAangemeldException;

import java.util.Locale;
import java.util.ResourceBundle;

public class Application {
	private DomeinController dc;
	private Scanner input = new Scanner(System.in);
	private Locale l;
	private ResourceBundle bundle;
	MessageFormat messageForm = new MessageFormat("");
	Object[] argSpelers = {Spel.MINIMUM_SPELERS, Spel.MAXIMUM_SPELERS}; // bij dynamische getallen nieuw object aanmaken

	public Application(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		banner();
		selecteerTaal();
		aanmelden();
		//Console.clear();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
		banner();
		toonSpelerslijst();
		toonKeuzemenu();
	}
	

	//UC1
	private void selecteerTaal() {
		System.out.print("kies taal/choose language (NL/ENG):");
		String lang = "";
		String country = "";
		boolean lang_nok = true;
		while(lang_nok) {
			String taal = input.next();
			if (taal.equals("ENG")) { 
				lang = "en"; 
				country = "US";
				lang_nok = false;
			} else if (taal.equals("NL")) { 
				lang = "nl"; 
				country = "BE";
				lang_nok = false;
			} else {
				System.out.printf("Incorrecte taal ingegeven. \nkies taal/choose language (NL/ENG):");
			}
		}
		
		this.l = new Locale(lang, country);
		this.bundle = ResourceBundle.getBundle("talen.ApplicationMessage", l);
	}
	
	//UC1
	private void aanmelden() {
		System.out.printf("\n\n");
		String spelersnaam ="";
		String wachtwoord = "";
		Boolean iniOK = false;
		do {
			try {
				dc.initialiseerSpel(bepaalAantalSpelers());
				iniOK=true;
			} 
			catch (BuitenBereikAantalSpelersException e){ 
				  System.out.println(e.getMessage());
				}
			}
		while (!iniOK);
		
		System.out.printf(bundle.getString("geregistreerdeSpelers") + "%d\n", dc.geefAantalSpelers());
		
		for(int i=1; i<=dc.geefAantalSpelers(); i++) {
				try {
						System.out.printf(bundle.getString("geefGebruikersnaam") + " %d:\t",i);
						spelersnaam = input.nextLine();
						System.out.printf(bundle.getString("geefWachtwoord") + " %d:\t",i);
						wachtwoord = input.nextLine();
						dc.meldAan(spelersnaam, wachtwoord);
				} catch (SpelerNietInDBException|SpelerReedsAangemeldException e) {
					System.out.printf("\n%s\n", e.getMessage());
					i--;
				}	
		}	
		
	}
	
	//UC1
	private void toonSpelerslijst() {
		List<String> spelerslijst = dc.geefSpelersnamen(); 
		System.out.printf("\n\n" + bundle.getString("aangemeldeSpelers") + "\n");
		int teller=1;
		for(String naam:spelerslijst){
            System.out.printf("\t"+ bundle.getString("speler") + "%d: %s \n",teller++, naam);
        }
	}
	
	//UC1
	private void banner() {
		System.out.printf("***************************************************************************\n");
		System.out.printf("*                                                                         *\n");
		System.out.printf("*   $$$$$$    $     $  $      $  $      $  $  $   $    $     $  $$$$$     *\n");
		System.out.printf("*   $     $   $     $  $ $  $ $  $ $  $ $  $  $  $     $     $  $    $    *\n");
		System.out.printf("*   $     $   $     $  $   $  $  $   $  $  $  $$$      $     $  $    $    *\n");
		System.out.printf("*   $$$$$$    $     $  $      $  $      $  $  $  $     $     $  $$$$$$    *\n");
		System.out.printf("*   $     $   $     $  $      $  $      $  $  $   $    $     $  $     $   *\n");
		System.out.printf("*   $      $  $$$$$$$  $      $  $      $  $  $    $   $$$$$$$  $$$$$$    *\n");
		System.out.printf("*                                                                         *\n");
		System.out.printf("***************************************************************************\n");
	}
	
	//UC1
	private int bepaalAantalSpelers() {
		boolean aantalNOK = true;
		int aantalSpelers = 0;
		do {
			try {messageForm.applyPattern(bundle.getString("vragenAantalSpelers"));
				System.out.printf(messageForm.format(argSpelers));
				 aantalSpelers = input.nextInt();
				 aantalNOK = false;
				 //uitzoeken want volgende regel toegevoegd om een bug op te lossen
				 input.nextLine();
			} catch (InputMismatchException inputMismatch) {
				input.nextLine();
				System.out.printf(bundle.getString("verkeerdeInputAantalSpelers"),Spel.MINIMUM_SPELERS,Spel.MAXIMUM_SPELERS);}
			  //catch (BuitenBereikAantalSpelersException e){ 
				//  System.out.println(e.getMessage());
				//}
			}
		while (aantalNOK);
		return aantalSpelers;
	}
	
	//UC1
	private void toonKeuzemenu(){
		System.out.printf("\n" + bundle.getString("keuzemenu"));
		System.out.printf("\n\t" +bundle.getString("speelSpel"));
		System.out.printf("\n\t" + bundle.getString("toonOverzicht"));
		System.out.printf("\n\t" + bundle.getString("keuze"));
		
	}
	
}
