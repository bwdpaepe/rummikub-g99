package domein;

import java.util.List;

import exceptions.AlleSpelersReedsAangemeldException;
import exceptions.SpelerNietInDBException;
import exceptions.SpelerReedsAangemeldException;

public class DomeinController {

	private Spel spel;
	private SpelerRepository spelerRepo;

	public DomeinController() {
		spelerRepo = new SpelerRepository();
	}
	
	//UC1
	public void initialiseerSpel(int aantalSpelers) {
		
		this.spel = new Spel(aantalSpelers);
	}
	
	//UC1
	public void meldAan( String spelersnaam, String wachtwoord) throws SpelerNietInDBException, SpelerReedsAangemeldException, AlleSpelersReedsAangemeldException {
		Speler nieuweSpeler = spelerRepo.zoekSpeler(spelersnaam, wachtwoord); 
		spel.voegSpelerToe(nieuweSpeler);
	} 
	
	//UC1
	public List<String> geefSpelersnamen() {
		return spel.geefSpelersnamen();
	}
	
	//UC1
	public int geefAantalSpelers () {
		return spel.getAantalSpelers();
	} 
	
	//UC1
	public boolean bepaalAlleSpelersAangemeld() {
		return this.spel.bepaalAlleSpelersAangemeld();
	}
	//UC1
	//public void BepaalAantalSpelers (int aantalSpelers) {
	//	spel.stelAantalSpelersIn(aantalSpelers);
	//} 
	
	//UC2
	/** Iemand heeft op de knop 'start spel' gedrukt, we vragen de klasse spel om een spel te starten.
	 * We krijgen naam van de volgende speler terug, of alle spelers met hun score als het spel gedaan is. */
	public void startSpel() {
		this.spel.startSpel();
	}
	
	//UC2
	/** Het systeem toont de gebruikersnaam van de speler aan de beurt */
	public String geefNaamSpelerAanBeurt() {
		return this.spel.geefNaamSpelerAanBeurt();
	}
	
	//UC2
	/** Het systeem toont de scores van de spelers */
	public List<String> geefScores() {
		return this.spel.geefScores();
	}
	
	//UC3
	public void startBeurt() {
		this.spel.startBeurt();
	}
	
	//UC3
	/*ToDo
	public List<Integer> geefSpelsituatie(){
		return this.spel.geefSpelsituatie();
	}
	*/
	
	//UC3
	public String[] geefMogelijkActies() {
		return this.spel.geefMogelijkeActies();
	}
	
	
	//UC3
	/*ToDo
	public void beeindigBeurt() {
		this.spel.beeindigBeurt();
	}
	*/
	
	//UC3
	public void splitsRijOfSerie(int reeksnummer, int positieInReeks) {
		this.spel.splitsRijOfSerie(reeksnummer, positieInReeks);
	}
	
	//UC3
	public void legSteenAan(int nummerInInput, int positieInInput, int reeksnummer, int positieInReeks) throws Exception {
		this.spel.legSteenAan(nummerInInput, positieInInput, reeksnummer, positieInReeks);
	}
	
	//UC3
	public void vervangJoker(int nummerInInput, int positieInInput, int reeksnummer, int positieInReeks) throws Exception {
		this.spel.vervangJoker(nummerInInput, positieInInput, reeksnummer, positieInReeks);
	}
	
	//UC3
	public void steenNaarWerkveld(int reeksnummer, int positieInReeks) throws Exception {
		this.spel.steenNaarWerkveld(reeksnummer, positieInReeks);
	}
}
