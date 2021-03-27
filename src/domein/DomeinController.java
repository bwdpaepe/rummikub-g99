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
	
	
}
