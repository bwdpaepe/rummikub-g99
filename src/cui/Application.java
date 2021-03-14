package cui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;

public class Application {
	private DomeinController dc;
	
	public Application(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		banner();
		aanmelden();
	}
	
	private void aanmelden() {
		System.out.printf("\n\n");
		Scanner input = new Scanner(System.in);
		boolean aantalNOK = true;
		int aantalSpelers = 0;
		String spelersnaam ="";
		String wachtwoord = "";
		do {
			try {System.out.printf("Geef het aantal spelers (min=2, max=4): ");
				 aantalSpelers = input.nextInt();
				 System.out.printf("Aantal geregistreerde spelers is: %d\n", aantalSpelers);
				 aantalNOK = false;
				 //uitzoeken want volgende regel toegevoegd om een bug op te lossen
				 input.nextLine();
			} catch (InputMismatchException inputMismatch) {
				input.nextLine();
				System.out.printf("ERROR: Gelieve een GETAL (2, 3 of 4) te kiezen \n");}
			}
		while (aantalNOK);
		
		dc.initialiseerSpel(aantalSpelers);
		//aantal spelers zouden we ook kunnen ophalen in spel. te bespreken
		for(int i=1; i<=aantalSpelers; i++) {
				while(!dc.meldAan(spelersnaam,wachtwoord)) {
					System.out.printf("\nGeef naam speler %d:\t",i);
					spelersnaam = input.nextLine();
					System.out.printf("Geef paswoord speler %d:\t",i);
					wachtwoord = input.nextLine();
				};
		}			
			
//			eerste oplossing maar fout
//				do {
//				//vraag gebruikersnaam en wachtwoord
//				System.out.printf("\nGeef naam speler %d: ",i);
//				spelersnaam = input.nextLine();
//				System.out.printf("Geef paswoord speler %d: ",i);
//				wachtwoord = input.nextLine();
//				System.out.printf("%s %s: ",wachtwoord,spelersnaam);
//				dc.meldAan(spelersnaam,wachtwoord);
//			}
//			while(!dc.meldAan(spelersnaam,wachtwoord));
				
		toonSpelerslijst();
	}
	
	private void toonSpelerslijst() {
		List<String> spelerslijst = dc.geefSpelersnamen();
		System.out.printf("\n\nDe aangemelde spelers zijn: \n");
		for(int i=1; i <= spelerslijst.size(); i++){
            System.out.printf("\t speler %d: %s \n", i,spelerslijst.get(i-1) );
        }
	}
	
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
	
	
}
