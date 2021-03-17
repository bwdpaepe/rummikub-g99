package cui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import domein.Spel;

public class Application {
	private DomeinController dc;
	private Scanner input = new Scanner(System.in);

	public Application(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		banner();
		aanmelden();
		//Console.clear();
		//banner();
		toonSpelerslijst();
		toonKeuzemenu();
	}
	
	//UC1
	private void aanmelden() {
		System.out.printf("\n\n");
		String spelersnaam ="";
		String wachtwoord = "";
		dc.initialiseerSpel(bepaalAantalSpelers());
		for(int i=1; i<=dc.geefAantalSpelers(); i++) {
				while(!dc.meldAan(spelersnaam,wachtwoord)) {
					System.out.printf("\nGeef naam speler %d:\t",i);
					spelersnaam = input.nextLine();
					System.out.printf("Geef paswoord speler %d:\t",i);
					wachtwoord = input.nextLine();
				};
		}				
	}
	
	//UC1
	private void toonSpelerslijst() {
		List<String> spelerslijst = dc.geefSpelersnamen();
		System.out.printf("\n\nDe aangemelde spelers zijn: \n");
		int teller=1;
		for(String naam:spelerslijst){
            System.out.printf("\tSpeler %d: %s \n",teller++, naam);
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
			try {System.out.printf("Geef het aantal spelers (min=%d, max=%d): ",Spel.maximumSpelers, Spel.minimumSpelers);
				 aantalSpelers = input.nextInt();
				 System.out.printf("Aantal geregistreerde spelers is: %d\n", aantalSpelers);
				 aantalNOK = false;
				 //uitzoeken want volgende regel toegevoegd om een bug op te lossen
				 input.nextLine();
			} catch (InputMismatchException inputMismatch) {
				input.nextLine();
				System.out.printf("ERROR: Gelieve een GETAL (min=%d max=%d) te kiezen \n",Spel.minimumSpelers,Spel.maximumSpelers);}
			}
		while (aantalNOK);
		return aantalSpelers;
	}
	
	//UC1
	private void toonKeuzemenu(){
		System.out.printf("\nKeuzemenu:");
		System.out.printf("\n\t1: Speel spel");
		System.out.printf("\n\t2: Toon overzicht");
		System.out.printf("\n\tMaak uw keuze (1/2): ");
		
	}
	
}
