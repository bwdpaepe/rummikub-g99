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
	
	//tijdelijke constructor om vlugger een spelsituatie op te zetten (via StartUp2)
	public DomeinController(Spel spel) {
		spelerRepo = new SpelerRepository();
		this.spel = spel;
	}

	//tijdelijke methode voor test GUI!!!!
	public void testvolgende()  {
		spel.eindeBeurt();
	}
	
	//UC1
	/**
	 * Maakt een instantie aan van klasse Spel </br> 
	 * Een Spel met een Gemeenschappelijkveld (met een lijst voor reeksen) en een werkveld (met een lijst voor stenen).
	 * @param aantalSpelers geeft het aantalspelers mee die aangemeld zullen worden
	 */
	public void initialiseerSpel(int aantalSpelers) {
		
		this.spel = new Spel(aantalSpelers);
		
	}
	
	//UC1
	/**
	 * Zoekt een speler met spelersnaam en wachtwoord op in de repository. </br>
	 * Indien deze aanwezig is, wordt hij aangemeld in het spel
	 * @param spelersnaam
	 * @param wachtwoord
	 * @throws SpelerNietInDBException
	 * @throws SpelerReedsAangemeldException
	 * @throws AlleSpelersReedsAangemeldException
	 */
	public void meldAan( String spelersnaam, String wachtwoord) throws SpelerNietInDBException, SpelerReedsAangemeldException, AlleSpelersReedsAangemeldException {
		Speler nieuweSpeler = spelerRepo.zoekSpeler(spelersnaam, wachtwoord); 
		spel.voegSpelerToe(nieuweSpeler);
	} 
	
	//UC1
	
	/**
	 * Haalt de namen op van de spelers die aangemeld zijn in het spel
	 * @return een lijst met de namen van de aangemeldde spelers
	 */
	public List<String> geefSpelersnamen() {
		return spel.geefSpelersnamen();
	}
	
	//UC1
	/**
	 * Geeft het aantal aangemeldde spelers in het spel
	 * @return int (aantal spelers)
	 */
	public int geefAantalSpelers () {
		return spel.getAantalSpelers();
	} 
	
	//UC1
	/**
	 * informeert indien de het aantal aangemeldde spelers gelijk is aan het opgegeven aantal deelnemers tijdens initialisatie spel.
	 * @return boolean (true = aangemeldde spelers is gelijk aan geïnitialiseerd aantal spelers)
	 */
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
	/** Het systeem toont de gebruikersnaam van de speler aan de beurt 
	 * @return int [0..3] Waarbij 0 de 1ste speler is. 
	 */
	public String geefNaamSpelerAanBeurt() {
		return this.spel.geefNaamSpelerAanBeurt();
	}
	
	//UC2
	/** Het systeem toont de scores van de spelers */
	/**
	 * 
	 * @return Arraylist van strings. De lijst bevat voor iedere speler een string met een informatiezin over één spelersnaam en zijn score.
	 */
	public List<String> geefScores() {
		return this.spel.geefScores();
	}
	
	//UC3
	public void startBeurt() {
		this.spel.startBeurt();
	}
	
	//UC3
	//
	/**
	 * @return 3 dimensionale array waarbij betekenis van de 1ste dimensie is: 0 = PS, 1 = WV, 2 = GV
	 */
	public String[][][] geefSpelsituatie(){
		return this.spel.geefSpelsituatie();
	}
	//UC3
	/**
	 * Extra testmethode om op een alternatieve methode geefspelsituatie op te kunnen roepen.
	 * Momenteel niet in gebruik.
	 * @return list van lists van strings
	 */
	public List<List<String>> geefSpelsituatieJoost() {
		return spel.geefSpelsituatieJoost();
	}
	
	
	//UC3
	/**
	 * roept methode geefMogelijkeActies() in klasse spel aan. </br>
	 * Geeft de mogelijke acties tekstueel weer. Teksten worden gebruikt om knoppen te voorzien van tekst
	 * @return string[] met size=6. Iedere string levert de naam van een actie
	 */
	public String[] geefMogelijkActies() {
		return this.spel.geefMogelijkeActies();
	}
	
	/**
	 * Methode bekijkt of er een geldige situatie is in GV en WV om de beurt te beëindigen.</br>
	 * Hij doet dit aan de hand van bepaalGeldigeSpelSituatie() uit spel. 
	 * @throws Exception Informeert indien er geen geldige spelsituatie is en beëindigt zo de beurt niet
	 */
	//UC3
	public void beeindigBeurt() throws Exception {
		this.spel.beeindigBeurt();
	}
	
	
	//UC3
	/**
	 * Splits een rij of reeks in het gemeenschappelijk veld. </br>
	 * De aangeroepen methode in Spel is splitsRijOfSerie(). </br>
	 * Deze roept op zich de relevante methode in gemeenscahppelijk veld aan.
	 * @param reeksnummer int die bepaalt de hoeveelste reeks in het gemeenschappelijk veld
	 * @param positieInReeks int die bepaalt vanaf welke steen in de reeks we willen splitsen in een andere reeks.
	 * @throws Exception deze exception is afkomstig uit gemeenschappelijk veld en indiceert dat er gepoogd wordt te splitsen op een locatie die geen steenpositie is.
	 */
	public void splitsRijOfSerie(int reeksnummer, int positieInReeks) throws Exception {
		this.spel.splitsRijOfSerie(reeksnummer, positieInReeks);
	}
	
	//UC3
	/**
	 * 
	 * @param nummerInInput
	 * @param positieInInput
	 * @param reeksnummer
	 * @param positieInReeks
	 * @throws Exception
	 */
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
	
	//UC3
	public void resetBeurt() {
		this.spel.resetBeurt();
	}
	
	//presentatie
	public void fictiefEinde() {
		this.spel.fictiefEinde();
	}
	//extra shortcut voor presentatie
	public void startSpel2() {
		spel.startspel2();
	}
}
