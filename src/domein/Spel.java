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
	private Reeks reeks;
	private Steen steen;
	private Speler speler;
	
	
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
	 * We schudden ��nmalig de spelers door elkaar zodat ze in een willekeurige
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
		// p 48, hoofdstuk 6, OOSD1
		String [] mogelijkeActiesArray = new String [6];
		int counter = 0;
		for(MogelijkeActies ma: MogelijkeActies.values()) {
			mogelijkeActiesArray[counter] = ma.name();
			counter++;
		}
		return mogelijkeActiesArray;
	}
	
	//UC3
	/** 
	 * Controleren als er nog stenen in werkveld liggen 
	 * JA: foutmelding
	 * NEE: controleren als er stenen zijn afgelegd
	 * 		JA: regels nakijken ivm joker, waarden en geldige spelsituatie ivm rij en serie
	 * 		NEE: steen bijgeven aan speler
	 */
	public void geldigeSpelSituatie() {	
		Speler actieveSpeler = this.spelers.get(this.spelerAanZet);
		if (werkveld.getStenenWerkveld().size() == 0) { //GEEN stenen werkveld
			if(actieveSpeler.hoeveelStenenHeeftDeSpeler() != this.duplicaatStenen.size()){ // stenen afgelegt
				for(Reeks geldig: this.gemeenschappelijkVeld.getReeksen()){
					if(this.gemeenschappelijkVeld.bepaalGeldigeSpelsituatie()){
						if(this.reeks.isNieuw() == true){
							for(Steen s: this.reeks.getStenen()){
								if(s.getWaarde() == 25){ //joker in nieuwe reeks --> Waar staat joker gedefinieerd??
									throw new IllegalArgumentException("Bij de eerste afleg mag er geen gebruik gemaakt worden van een Joker.");
								} else { // geen joker in nieuwe reeks
									int somStenen = 0;
									somStenen += s.getWaarde();
									if(somStenen >= 30){ // controleren som
										reeks.setIsNieuw(false);
									}else { //somStenen < 30
										throw new IllegalArgumentException("De som van de gelegde stenen moet minimaal 30 zijn.");
									} 
								}	
							}
						}else {
							this.eindeBeurt();
						}
					speler.setEersteUitleg(false);	
					} else { //geen stenen afgelegd
						actieveSpeler.voegSteenToe(this.pot.geefSteen());
						this.eindeBeurt();
					}
				}
			} else { //Er liggen nog stenen op het werkveld !! 
				throw new IllegalArgumentException("Er mogen geen stenen meer in uw werkveld liggen!"); // indien werkveld niet leeg is
			}
		}
	}
	
	//UC3
	public void splitsRijOfSerie(int reeksnummer, int positieInReeks) {
		this.gemeenschappelijkVeld.splitsRijOfSerie(reeksnummer, positieInReeks);
	}
	
	//UC3
	public void legSteenAan(int nummerInInput, int positieInInput, int reeksnummer, int positieInReeks) throws Exception {
		//pak de steen
		Steen steenOmAanTeLeggen;
		//nummerInInput '0': PS
		//nummerInInput '1': Werkveld
		switch(nummerInInput) {
		case 0: 
			steenOmAanTeLeggen = this.spelers.get(this.spelerAanZet).vraagAllePersoonlijkeStenenOp().remove(positieInInput);
			break;
		default:
			steenOmAanTeLeggen = this.werkveld.getStenenWerkveld().remove(positieInInput);
		}
		
		try {
			this.gemeenschappelijkVeld.legSteenAan(steenOmAanTeLeggen, reeksnummer, positieInReeks);
		} catch (Exception e) {
			// we kunnen de steen niet aanleggen
			// nu moeten we hem terugleggen vanwaar hij kwam
			switch(nummerInInput) {
			case 0: 
				List<Steen> psLijst = this.spelers.get(this.spelerAanZet).vraagAllePersoonlijkeStenenOp();
				this.legSteenTerug(psLijst, positieInInput, steenOmAanTeLeggen);
				break;
			default:
				List<Steen> werkveldLijst = this.werkveld.getStenenWerkveld();
				this.legSteenTerug(werkveldLijst, positieInInput, steenOmAanTeLeggen);
			}
			
			//We gooien de exception verder
			throw e;
		}
	}
	
	//UC3
	private void legSteenTerug(List<Steen> teruglegLijst, int positieInInput, Steen steenOmAanTeLeggen) {
		// omzetten naar array om dan de staart te kopieren
		Steen[] stenenArray = teruglegLijst.toArray(new Steen[teruglegLijst.size()]);
		// staart kopieren
		Steen[] stenenArrayCopyRange = Arrays.copyOfRange(stenenArray, positieInInput-1, stenenArray.length);
		// steen aanleggen
		stenenArrayCopyRange[0] = steenOmAanTeLeggen;
		// staart terug aan de reeks hangen
		IntStream.rangeClosed(positieInInput, teruglegLijst.size()+1)
		         .forEach(x -> teruglegLijst.set(x, stenenArrayCopyRange[x-positieInInput]));
	}
	
	//UC3
	public void vervangJoker(int nummerInInput, int positieInInput, int reeksnummer, int positieInReeks) throws Exception {
		//pak de steen
		Steen steenOmJokerTeVervangen;
		//nummerInInput '0': PS
		//nummerInInput '1': Werkveld
		switch(nummerInInput) {
		case 0: 
			steenOmJokerTeVervangen = this.spelers.get(this.spelerAanZet).vraagAllePersoonlijkeStenenOp().remove(positieInInput);
			break;
		default:
			steenOmJokerTeVervangen = this.werkveld.getStenenWerkveld().remove(positieInInput);
		}
		
		try {
			this.gemeenschappelijkVeld.vervangJoker(steenOmJokerTeVervangen, reeksnummer, positieInReeks);
		} catch (Exception e) {
			// we kunnen de steen niet aanleggen
			// nu moeten we hem terugleggen vanwaar hij kwam
			switch(nummerInInput) {
			case 0: 
				List<Steen> psLijst = this.spelers.get(this.spelerAanZet).vraagAllePersoonlijkeStenenOp();
				this.legSteenTerug(psLijst, positieInInput, steenOmJokerTeVervangen);
				break;
			default:
				List<Steen> werkveldLijst = this.werkveld.getStenenWerkveld();
				this.legSteenTerug(werkveldLijst, positieInInput, steenOmJokerTeVervangen);
			}
			
			//We gooien de exception verder
			throw e;
		}			
	}
	
	//UC3
	public void steenNaarWerkveld(int reeksnummer, int positieInReeks) throws Exception {
		// in geval van problemen moeten we hier niets terugleggen, we kunnen de exception gewoon verder gooien
		this.werkveld.voegSteenToeWerkveld(this.gemeenschappelijkVeld.steenNaarWerkveld(reeksnummer, positieInReeks));
	}

}
