package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exceptions.AlleSpelersReedsAangemeldException;
import exceptions.BuitenBereikAantalSpelersException;
import exceptions.SpelerReedsAangemeldException;

public class Spel {

	private int aantalSpelers;
	private List<Speler> spelers = new ArrayList<>();
	public static final int MAXIMUM_SPELERS = 4;
	public static final int MINIMUM_SPELERS = 2;
	private Pot pot;
	private int spelerAanZet;
	
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
        if (aantalSpelers < MINIMUM_SPELERS || aantalSpelers > MAXIMUM_SPELERS)
            throw new BuitenBereikAantalSpelersException
                (String.format("Het aantal spelers moet in het "
                + "interval [%d,%d] liggen!", MINIMUM_SPELERS, MAXIMUM_SPELERS));
        this.aantalSpelers = aantalSpelers;
    }
	
	//public void stelAantalSpelersIn(int aantalSpelers){
	//setAantalSpelers(aantalSpelers);
	//}
	
	//UC1
	public void voegSpelerToe(Speler speler) throws SpelerReedsAangemeldException, AlleSpelersReedsAangemeldException   {
		if (spelers.size() == aantalSpelers) throw new AlleSpelersReedsAangemeldException(String.format("Het aantal deelnemers was reeds aangemeld!"));
		checkReedsAangemeld(speler.getSpelersnaam());
		speler.resetWachtwoord();
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
							String.format("De Speler/paswoord combinatie is reeds aangemeld in het spel!"));			
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
	//feedbcak was om hier exception toevoegen indien alle spelers reeds aangemeld maar gedaan in voegspelertoe
	public boolean bepaalAlleSpelersAangemeld() {
		return (spelers.size() == this.aantalSpelers);
	}
	
	//UC2
	/** Iemand heeft op de knop 'start spel' gedrukt, we beginnen het spel. */
	public String startSpel() {
		// maak de pot
		// geef iedere speler 14 willekeurige stenen
		// bepaal de volgorde van de spelers
		// initialiseer de speler aan zet
		// retourneer de naam van de speler
		return "toto";
	}
	
	private void bepaalStartStenen() {
		
	}
	
	private void randomizeVolgorderSpelers() {
		
	}
	
	public void speelBeurt() {
		
	}
	
	private boolean bepaalIsEindeSpel() {
		return false;
	}
	
	public List<int[]> berekenScores() {
		int[] scores = {1,2,3};
		return Arrays.asList(scores);
		
	}
	
	
}
