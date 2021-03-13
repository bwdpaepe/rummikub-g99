package domein;

import java.util.List;

public class DomeinController {

	private Spel spel;
	private SpelerRepository spelerRepo;

	public DomeinController() {
		spelerRepo = new SpelerRepository();
	}
	
	public void initialiseerSpel(int aantalSpelers) {
		this.spel = new Spel(aantalSpelers);
	}
	
	public boolean meldAan( String spelersnaam, String wachtwoord) {
		Speler nieuweSpeler = spelerRepo.zoekSpeler(spelersnaam, wachtwoord); 
		if (nieuweSpeler == null) return false;
		else return (spel.voegSpelerToe(nieuweSpeler));
	} 
	
	public List<String> geefSpelersnamen() {
		return spel.geefSpelersnamen();
	}
}
