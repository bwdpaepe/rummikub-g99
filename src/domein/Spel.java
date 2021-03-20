package domein;

import java.util.ArrayList;
import java.util.List;

import exceptions.BuitenBereikAantalSpelersException;
import exceptions.SpelerNietInDBException;
import exceptions.SpelerReedsAangemeldException;

public class Spel {

	private int aantalSpelers;
	private List<Speler> spelers = new ArrayList<>();
	public static final int maximumSpelers = 4;
	public static final int minimumSpelers = 2;
	
	public Spel() {
		
	}
	
	public Spel(int aantalSpelers) {
		setAantalSpelers(aantalSpelers);
		// te wissen enkel om te testen zonder repo
	}

	public int getAantalSpelers() {
		return aantalSpelers;
	}

/* vorige versie setter Aantalspelers
	private void setAantalSpelers(int aantalSpelers) {
		this.aantalSpelers = aantalSpelers;
	}
*/
	private void setAantalSpelers(int aantalSpelers){
        if (aantalSpelers < minimumSpelers || aantalSpelers > maximumSpelers)
            throw new BuitenBereikAantalSpelersException
                (String.format("Het aantal spelers moet in het "
                + "interval [%d,%d] liggen!", minimumSpelers, maximumSpelers));
        this.aantalSpelers = aantalSpelers;
    }
	
	//public void stelAantalSpelersIn(int aantalSpelers){
	//setAantalSpelers(aantalSpelers);
	//}
	
	//UC1
	public void voegSpelerToe(Speler speler) throws SpelerReedsAangemeldException   {
		checkReedsAangemeld(speler.getSpelersnaam());
		spelers.add(speler);
	}
	
	/*oude versie reedsAangemeld
	 * private boolean reedsAangemeld(String spelersnaam) {
		for(Speler speler:spelers) {
			if (speler.getSpelersnaam().equals(spelersnaam)) {
				return true;
			} 
		}
		return false;
	}
	*/
	
	//UC1
	private void checkReedsAangemeld(String spelersnaam) throws SpelerReedsAangemeldException {
		for(Speler speler:spelers) {
			if (speler.getSpelersnaam().equals(spelersnaam)) {
				throw new SpelerReedsAangemeldException(
							String.format("De Speler/paswoord combinatie is reeds in aangemeld in het spel!"));			
				} 	
		}
	}
	
	//UC1
	public List<String> geefSpelersnamen() {
		List<String> spelersnamen = new ArrayList<>();
		for (Speler speler: spelers) {
			spelersnamen.add(speler.getSpelersnaam());
		}
		return spelersnamen;
	} 
	
	public boolean bepaalAlleSpelersAangemeld() {
		if(spelers.size() == this.aantalSpelers) {
			return true;
		}
		return false;
	}
	//UC1
	
	public void resetWachtwoord(){
		for (Speler speler: spelers) {
			speler.resetWachtwoord();
		}
	}
	
}
