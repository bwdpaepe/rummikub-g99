package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import exceptions.AlleSpelersReedsAangemeldException;
import exceptions.BuitenBereikAantalSpelersException;
import exceptions.SpelerReedsAangemeldException;

public class Spel {

	private int aantalSpelers;
	private List<Speler> spelers = new ArrayList<>();
	public static final int MAXIMUM_SPELERS = 4;
	public static final int MINIMUM_SPELERS = 2;
	private final int AANTAL_STENEN_PER_SPELER_BIJ_AANVANG = 14;
	//UC2
	private Pot pot;
	//UC2
	private int spelerAanZet;

	
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
	/** Iemand heeft op de knop 'start spel' gedrukt, we beginnen het spel.
	 * We geven naam van de volgende speler terug, of alle spelers met hun score als het spel gedaan is. */
	public String startSpel() {
		// maak de pot
		this.pot = new Pot();
		// geef iedere speler 14 willekeurige stenen
		this.bepaalStartStenen();
		// bepaal de volgorde van de spelers
		this.randomizeVolgorderSpelers();
		// initialiseer de speler aan zet
		this.spelerAanZet = 0;
		// retourneer de naam van de speler aan zet
		return this.spelers.get(this.spelerAanZet).getSpelersnaam();
	}
	
	//UC2
	/** Geef iedere speler 14 willekeurige stenen */
	private void bepaalStartStenen() {
		// we gaan de pot eerst schudden
		this.pot.randomizePot();
		for(Speler spelerDieStenenKrijgt: this.spelers) {
			IntStream.rangeClosed(1, this.AANTAL_STENEN_PER_SPELER_BIJ_AANVANG)
			         .forEach(x->spelerDieStenenKrijgt.voegSteenToe(this.pot.geefSteen()));//ter info: x gaat van 1 tem 14, maar we hebben dat niet nodig
		}
		
	}
	
	//UC2
	/** We schudden éénmalig de spelers door elkaar zodat ze in een willekeurige volgorde staan en in die volgorde hun beurt spelen */
	private void randomizeVolgorderSpelers() {
		Collections.shuffle(this.spelers);
	}
	
	//UC2
	/** Aan het einde van een beurt, indien er geen winnaar is, bepalen we hier de volgende speler aan zet */
	private void bepaalVolgendeSpelerAanZet() {
		if(this.spelerAanZet == this.aantalSpelers - 1) {
			this.spelerAanZet = 0;
		}
		else {
			++this.spelerAanZet;
		}
	}	
	
	//UC2
	/** De speler aan zet speelt een beurt, het systeem kijkt of er een winnaar is, en retourneert de scores of de naam van de volgende speler aan zet al naargelang  */
	public String speelBeurt() {
		//het spel weet wie aan de beurt is, namelijk this.spelerAanZet
		
		//die speelt => UC3
		
		//bepaalIsEindeSpel
		//na elke speelbeurt moeten we evalueren of het einde van het spel bereikt is
		if(this.bepaalIsEindeSpel()) {
			//ja: einde spel bereikt
			//berekenScores
			this.berekenScores();
			//retourneer scores
			String output = "";
			for(Speler spelerMetScore: this.spelers) {
				output += String.format("Speler %s heeft als score %d%n", spelerMetScore.getSpelersnaam(), spelerMetScore.getScore());
			}
			return output;
			
		}
		//nee: einde spel niet bereikt, we spelen verder
		//aan het einde van de beurt: bepaalVolgendeSpelerAanZet
		this.bepaalVolgendeSpelerAanZet();
		//retourneer naam van volgende speler
		return this.spelers.get(this.spelerAanZet).getSpelersnaam();
		
	}
	
	//UC2
	/** controleer of er een speler is die geen stenen meer heeft. Ja: dan is er een winnaar en eindigt het spel (return true) */
	private boolean bepaalIsEindeSpel() {
		Predicate<Speler> winnaar = 
				s -> (s.hoeveelStenenHeeftDeSpeler() == 0);
		return this.spelers.stream()
		            .anyMatch(winnaar);
		
	}
	
	//UC2
	/** het spel is ten einde, bereken de scores van alle spelers */
	public void berekenScores() {
		//we sorteren de spelers van meeste naar minste (0) stenen
		//zo kunnen we de strafpunten bijhouden en meegeven aan de laatste speler (de winnaar)
		//we zetten de list om naar een array (voor de sort)
		Speler[] arraySpelers = new Speler[this.aantalSpelers];
		arraySpelers = this.spelers.toArray(arraySpelers);
		//sorteren, reverse, want we willen de grootste eerst => descending
		Arrays.sort(arraySpelers, Collections.reverseOrder());
		
		int strafpunten = 0;
		//we itereren over alle geordende spelers, behalve de laatste (de winaar) 
		for(int i = 0; i < arraySpelers.length - 1; i++) {
			arraySpelers[i].berekenScore(0);
			//we houden alle strafpunten bij en tellen ze op
			strafpunten += Math.abs(arraySpelers[i].getScore());
		}
		//we geven alle strafpunten mee aan de winnaar
		arraySpelers[arraySpelers.length - 1].berekenScore(strafpunten);
		
		//todo: schrijf test voor bereken scores
	}
	
	
}
