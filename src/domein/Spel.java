package domein;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import exceptions.AlleSpelersReedsAangemeldException;
import exceptions.BuitenBereikAantalSpelersException;
import exceptions.SpelerReedsAangemeldException;
import talen.Language;

public class Spel {

	private int aantalSpelers;
	private List<Speler> spelers = new ArrayList<>();
	public static final int MAXIMUM_SPELERS = 4;
	public static final int MINIMUM_SPELERS = 2;
	private final int AANTAL_STENEN_PER_SPELER_BIJ_AANVANG = 14;
	private Language language = Language.getInstance();
	private MessageFormat messageForm = new MessageFormat("");
	// UC2
	private Pot pot;
	private GemeenschappelijkVeld gemeenschappelijkVeld;
	private int spelerAanZet;
	//UC3
	private Werkveld werkveld;
	private List<Steen> duplicaatStenen; // bijhouden van de aangemaakt duplicaten. Speler maak enkel duplicaat van de Lijst.

	
	// UC1
	public Spel(int aantalSpelers) {
		setAantalSpelers(aantalSpelers);
	}

	public int getAantalSpelers() {
		return aantalSpelers;
	}

	// UC1
	private void setAantalSpelers(int aantalSpelers) {
		if (aantalSpelers < MINIMUM_SPELERS || aantalSpelers > MAXIMUM_SPELERS) {
			messageForm.applyPattern(language.getString("aantalBuitenBereik"));
			Object[] argSpelers = { Spel.MINIMUM_SPELERS, Spel.MAXIMUM_SPELERS };
			throw new BuitenBereikAantalSpelersException(String.format(messageForm.format(argSpelers)));
		}
		this.aantalSpelers = aantalSpelers;
	}

	// UC1
	public void voegSpelerToe(Speler speler) throws SpelerReedsAangemeldException, AlleSpelersReedsAangemeldException {
		//if (spelers.size() == aantalSpelers)
		if(this.bepaalAlleSpelersAangemeld())
			throw new AlleSpelersReedsAangemeldException(String.format(language.getString("spelersReedsAangemeld")));
		checkReedsAangemeld(speler.getSpelersnaam());
		speler.resetWachtwoord();
		spelers.add(speler);
	}

	/*
	 * oude versie reedsAangemeld private boolean reedsAangemeld(String spelersnaam)
	 * { for(Speler speler:spelers) { if
	 * (speler.getSpelersnaam().equals(spelersnaam)) { return true; } } return
	 * false; }
	 */

	// UC1
	private void checkReedsAangemeld(String spelersnaam) throws SpelerReedsAangemeldException {
		for (Speler speler : spelers) {
			if (speler.getSpelersnaam().equals(spelersnaam)) {
				throw new SpelerReedsAangemeldException(
						// String.format("De Speler/paswoord combinatie is reeds aangemeld in het
						// spel!")
						String.format(language.getString("spelerReedsAanwezig")));
			}
		}
	}

	// UC1
	public List<String> geefSpelersnamen() {
		List<String> spelersnamen = new ArrayList<>();
		for (Speler speler : spelers) {
			spelersnamen.add(speler.getSpelersnaam());
		}
		return spelersnamen;
	}

	// feedback docent was om hier exception toe te voegen indien alle spelers reeds
	// aangemeld maar exception werd gedaan in voegspelertoe()
	public boolean bepaalAlleSpelersAangemeld() {
		return (spelers.size() == this.aantalSpelers);
	}

	// UC2
	/**
	 * Iemand heeft op de knop 'start spel' gedrukt, we beginnen het spel. 
	 */
	public void startSpel() {
		// maak de pot
		this.pot = new Pot();
		// maak het gemeenschappelijke veld
		this.gemeenschappelijkVeld = new GemeenschappelijkVeld();
		// bepaal de volgorde van de spelers
		this.randomizeVolgordeSpelers();
		// geef iedere speler 14 willekeurige stenen
		this.bepaalStartStenen();
		// initialiseer de speler aan zet
		this.spelerAanZet = 0;
		
	}

	// UC2
	/**
	 * We schudden éénmalig de spelers door elkaar zodat ze in een willekeurige
	 * volgorde staan en in die volgorde hun beurt spelen
	 */
	private void randomizeVolgordeSpelers() {
		Collections.shuffle(this.spelers);
	}
	
	// UC2
	/** Geef iedere speler 14 willekeurige stenen */
	private void bepaalStartStenen() {
		// we gaan de pot eerst schudden
		this.pot.randomizePot();
		for (Speler spelerDieStenenKrijgt : this.spelers) {
			IntStream.rangeClosed(1, this.AANTAL_STENEN_PER_SPELER_BIJ_AANVANG)
					.forEach(x -> spelerDieStenenKrijgt.voegSteenToe(this.pot.geefSteen()));// ter info: x gaat van 1
																							// tem 14, maar we hebben
																							// dat niet nodig
		}
	}

	// UC2
	/** Het systeem toont de gebruikersnaam van de speler aan de beurt */
	public String geefNaamSpelerAanBeurt() {
		// retourneer string met de naam van de speler aan zet
		return this.spelers.get(this.spelerAanZet).getSpelersnaam();
	}
			
	// UC2
	/**
	 * Aan het einde van een beurt, indien er geen winnaar is, bepalen we hier de
	 * volgende speler aan zet
	 */
	private void bepaalVolgendeSpelerAanZet() {
		this.spelerAanZet = (this.spelerAanZet + 1) % this.aantalSpelers;
	}

	// UC2
	/**
	 * aan het einde van een beurt, het systeem kijkt of er een winnaar is,
	 * en berekent de scores of bepaalt de naam van de volgende speler aan zet al
	 * naargelang
	 */
	private void eindeBeurt() {
		// bepaalIsEindeSpel
		// na elke speelbeurt moeten we evalueren of het einde van het spel bereikt is
		if (this.bepaalIsEindeSpel()) {
			// ja: einde spel bereikt
			this.berekenScores();
		}
		// nee: einde spel niet bereikt, we spelen volgende beurt
		// met de volgende speler aan de beurt: bepaalVolgendeSpelerAanZet
		else {
			this.bepaalVolgendeSpelerAanZet();	
		}
	}

	// UC2
	/**
	 * controleer of de speler aan zet geen stenen meer heeft. Ja: dan is er een
	 * winnaar en eindigt het spel (return true)
	 */
	private boolean bepaalIsEindeSpel() {
		return (this.spelers.get(this.spelerAanZet).hoeveelStenenHeeftDeSpeler() == 0);
	}

	// UC2
	/** het spel is ten einde, bereken de scores van alle spelers */
	private void berekenScores() {
		List<Speler> spelersGesorteerd = this.spelers.stream()
				                                     .sorted(Comparator.comparing(Speler::hoeveelStenenHeeftDeSpeler))
				                                     .collect(Collectors.toList());
		// de winnaar staat nu op de eerste plaats
		
		int somVanStenen = 0;
		int pluspunten = 0;
		
		for(Speler gesorteerdeSpeler: spelersGesorteerd) {
			somVanStenen = gesorteerdeSpeler.somVanStenen();
			pluspunten += somVanStenen;
			gesorteerdeSpeler.pasScoreAan(somVanStenen * (-1));
		}
		
		// we geven de winnaar alle pluspunten
		spelersGesorteerd.get(0).pasScoreAan(pluspunten);
		
	}
	
	public List<String> geefScores() {
		List<String> scores = new ArrayList<>();
		for (Speler spelerMetScore : this.spelers) {
			scores.add(String.format(language.getString("speler") + " %s " + language.getString("heeftAlsScore") + " %d%n", spelerMetScore.getSpelersnaam(),
					spelerMetScore.getScore()));
		}
		return scores;
	}
	
	//UC3
	public void startBeurt() {
		this.duplicaatStenen = this.spelers.get(this.spelerAanZet).maakDuplicaatPersoonlijkeStenen();
	}
	
	//UC3
	public String[] geefMogelijkeActies() {
		//Opzoeken hoe ik van enum een arrayList maak of opties weergeef.
	}
	
	//UC3
	public void geldigeSpelSituatie() {
		// if structuur nog uitwerken
	}

}
