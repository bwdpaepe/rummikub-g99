package domein;

import java.util.List;

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
	public boolean meldAan( String spelersnaam, String wachtwoord) {
		Speler nieuweSpeler = spelerRepo.zoekSpeler(spelersnaam, wachtwoord); 
		if (nieuweSpeler == null) return false;
		else return (spel.voegSpelerToe(nieuweSpeler));
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
}
