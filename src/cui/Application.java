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
				 System.out.printf("Aantal spelers geregistreerd is: %d\n", aantalSpelers);
				 aantalNOK = false;
				 //uitzoeken want volgende regel toegevoegd om een bug op te lossen
				 input.nextLine();
			} catch (InputMismatchException inputMismatch) {
				input.nextLine();
				System.out.printf("gelieve een GETAL (2, 3 of 4) te kiezen \n");}
			}
		while (aantalNOK);
		
		dc.initialiseerSpel(aantalSpelers);
		
		for(int i=1; i<=aantalSpelers; i++) {
				while(!dc.meldAan(spelersnaam,wachtwoord)) {
					System.out.printf("\nGeef naam speler %d: ",i);
					spelersnaam = input.nextLine();
					System.out.printf("Geef paswoord speler %d: ",i);
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

		//toonspelerslijst
	}
	
	private void toonSpelerslijst() {
		List<String> spelerslijst = dc.geefSpelersnamen();
		System.out.printf("De aangemelde spelers zijn: \n");
		for(int i=1; i <= spelerslijst.size(); i++){
            System.out.printf("speler %d: %s \n", i,spelerslijst.get(i-1) );
        }
		
		
	}
	
	private void banner() {
		System.out.printf("***************************************************************************\n");
		System.out.printf("*                                                                         *\n");
		System.out.printf("*   $$$$$$    $     $  $      $  $      $  $  $$$$$$$  $     $  $$$$$     *\n");
		System.out.printf("*   $     $   $     $  $ $  $ $  $ $  $ $  $  $        $     $  $    $    *\n");
		System.out.printf("*   $     $   $     $  $   $  $  $   $  $  $  $        $     $  $    $    *\n");
		System.out.printf("*   $$$$$$    $     $  $      $  $      $  $  $        $     $  $$$$$$    *\n");
		System.out.printf("*   $     $   $     $  $      $  $      $  $  $        $     $  $     $   *\n");
		System.out.printf("*   $      $  $$$$$$$  $      $  $      $  $  $$$$$$$  $$$$$$$  $$$$$$    *\n");
		System.out.printf("*                                                                         *\n");
		System.out.printf("***************************************************************************\n");
	}
	
	
}
