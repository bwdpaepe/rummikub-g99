package domein;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import exceptions.AlleSpelersReedsAangemeldException;
import exceptions.BuitenBereikAantalSpelersException;
import exceptions.SpelerReedsAangemeldException;
import exceptions.SteenIsGeenJokerException;
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
	// UC3
	private Werkveld werkveld;
	private Reeks reeks;
	private Steen steen;
	private Speler speler;

	// UC1
	public Spel(int aantalSpelers) {
		setAantalSpelers(aantalSpelers);
//Joost aanmaak werkveld toegevoegd
		werkveld = new Werkveld();
//Joost aanmaak instantie toegevoegd
		gemeenschappelijkVeld = new GemeenschappelijkVeld();
	}

	public int getAantalSpelers() {
		return aantalSpelers;
	}

	// UC1
	/**
	 * Om aan het spel te kunnen meegeven hoeveel spelers er meedoen.
	 * Extra controle zodat het aantal tussen de twee mogelijke waarden ligt van minimaal en maximaal aantal spelers.
	 * 
	 * @param aantalSpelers
	 */
	private void setAantalSpelers(int aantalSpelers) {
		if (aantalSpelers < MINIMUM_SPELERS || aantalSpelers > MAXIMUM_SPELERS) {
			messageForm.applyPattern(language.getString("aantalBuitenBereik"));
			Object[] argSpelers = { Spel.MINIMUM_SPELERS, Spel.MAXIMUM_SPELERS };
			throw new BuitenBereikAantalSpelersException(String.format(messageForm.format(argSpelers)));
		}
		this.aantalSpelers = aantalSpelers;
	}

	// UC1
	/**
	 * Toevoegen van één speler met controle indien deze niet al reeds is aangemeld in dit specifiek spel.
	 * 
	 * @param speler
	 * @throws SpelerReedsAangemeldException
	 * @throws AlleSpelersReedsAangemeldException
	 */
	public void voegSpelerToe(Speler speler) throws SpelerReedsAangemeldException, AlleSpelersReedsAangemeldException {
		// if (spelers.size() == aantalSpelers)
		if (this.bepaalAlleSpelersAangemeld())
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
	/**
	 * Controle om na te gaan indien deze specifieke speler reeds in aangemeld.
	 * 
	 * @param spelersnaam
	 * @throws SpelerReedsAangemeldException
	 */
	private void checkReedsAangemeld(String spelersnaam) throws SpelerReedsAangemeldException {
		for (Speler speler : spelers) {
			if (speler.getSpelersnaam().equals(spelersnaam)) {
				throw new SpelerReedsAangemeldException(
						// String.format("De Speler/paswoord combinatie is reeds aangemeld in het spel!")
						String.format(language.getString("spelerReedsAanwezig")));
			}
		}
	}

	// UC1
	/**
	 * Om te kunnen weergeven welke spelers er meedoen in dit spel.
	 * 
	 * @return
	 */
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
		// maak het werkveld
		this.werkveld = new Werkveld();
		// maak het gemeenschappelijke veld
		this.gemeenschappelijkVeld = new GemeenschappelijkVeld();
		// bepaal de volgorde van de spelers
		this.randomizeVolgordeSpelers();
		// geef iedere speler 14 willekeurige stenen
//		this.bepaalStartStenen();
		bepaalStartStenenJoost();
		// initialiseer de speler aan zet
		this.spelerAanZet = 0;
		this.spelers.get(this.spelerAanZet).maakDuplicaatPersoonlijkeStenen();
		// initialiseer het werkveld (niets te doen, want is leeg)
		//initialiseer het GV
		this.gemeenschappelijkVeld.maakDuplicaat();
		
		

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
//joost methode herschreven omdat streams me niet toelieten de code na te zien tijdens debuggen
	private void bepaalStartStenenJoost() {
		for (Speler s : spelers) {
			for (int i = 0; i < AANTAL_STENEN_PER_SPELER_BIJ_AANVANG; i++) {
				Steen steen = pot.geefSteen();
				s.voegSteenToe(steen);
			}
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
	 * aan het einde van een beurt, het systeem bekijkt of er: </br>
	 * - een winnaar is en berekent vervolgens de scores </br>
	 * - ofwel bepaalt systeem de naam van de volgende speler aan zet </br> 
	 * al naargelang
	 */
	
//Joost Tijdelijk op public staan om te testen. Nog te wijzigen in finale versie!!!
	public void eindeBeurt() {
		// bepaalIsEindeSpel
		// na elke speelbeurt moeten we evalueren of het einde van het spel bereikt is
		if (this.bepaalIsEindeSpel()) {
			// ja: einde spel bereikt
			this.berekenScores();
			System.out.printf("eindespel ");
		}
		// nee: einde spel niet bereikt, we spelen volgende beurt
		// met de volgende speler aan de beurt: bepaalVolgendeSpelerAanZet
		else {
			this.bepaalVolgendeSpelerAanZet();
			this.startBeurt();
			// System.out.printf ("niet einde spel ");
		}
	}

	// UC2
	/**
	 * Controleer of de speler aan zet geen stenen meer heeft. Ja: dan is er een
	 * winnaar en eindigt het spel (return true)
	 * 
	 * @return
	 */
	private boolean bepaalIsEindeSpel() {
		return (this.spelers.get(this.spelerAanZet).hoeveelStenenHeeftDeSpeler() == 0);
	}

	// UC2
	/** het spel is ten einde, bereken de scores van alle spelers */
	private void berekenScores() {
		List<Speler> spelersGesorteerd = this.spelers.stream()
				.sorted(Comparator.comparing(Speler::hoeveelStenenHeeftDeSpeler)).collect(Collectors.toList());
		// de winnaar staat nu op de eerste plaats

		int somVanStenen = 0;
		int pluspunten = 0;

		for (Speler gesorteerdeSpeler : spelersGesorteerd) {
			somVanStenen = gesorteerdeSpeler.somVanStenen();
			pluspunten += somVanStenen;
			gesorteerdeSpeler.pasScoreAan(somVanStenen * (-1));
		}

		// we geven de winnaar alle pluspunten
		spelersGesorteerd.get(0).pasScoreAan(pluspunten);

	}

	/**
	 * Vraagt de score van alle spelers op en plaatst ze in een zin. 
	 * Hierna kan deze weergeven worden op het einde van het spel.
	 * 
	 * @return
	 */
	public List<String> geefScores() {
		List<String> scores = new ArrayList<>();
		for (Speler spelerMetScore : this.spelers) {
			scores.add(
					String.format(language.getString("speler") + " %s " + language.getString("heeftAlsScore") + " %d%n",
							spelerMetScore.getSpelersnaam(), spelerMetScore.getScore()));
		}
		return scores;
	}

	// UC3
	/**
	 * 3-dimensionele String die huidige spelsituatie weergeeft.
	 * - 1ste dimensie: Over welke locatie het gaat (PS/WV/GV) 
	 * - 2de dimensie: Bevat een getal dat het maximale aantal weergeeft dat de locatie kan hebben 
	 * - 3de dimensie: ??
	 * 
	 * @return
	 */
	public String[][][] geefSpelsituatie() {
		List<Steen> PS = this.spelers.get(this.spelerAanZet).vraagAllePersoonlijkeStenenOp();
		List<Steen> WV = this.werkveld.getStenenWerkveld();
		List<Reeks> GV = this.gemeenschappelijkVeld.getReeksen();
		/*
		 * int maxDimensie2 = 30; int maxDimensie3 = 10;
		 */
		int maxDimensie2 = Integer.MIN_VALUE;
		int maxDimensie3 = Integer.MIN_VALUE;

		// Berekenen max dimensies
		// 1ste dimensie kan 3 waarden bevatten : SP, Werkveld, GV
		// 2de dimensie
		maxDimensie2 = Math.max(PS.size(), Math.max(WV.size(), GV.size()));
		// 3de dimensie
		if(GV.size() > 0) {
			maxDimensie3 = GV.stream()
						 .mapToInt(Reeks::hoeveelStenenHeeftDeReeks)
						 .max()
						 .getAsInt();
		}
		

		
		if(maxDimensie2<=0) {
			maxDimensie2 = 1;	// we hebben er minstens 1 nodig om onze array op te bouwen 
		}
		if(maxDimensie3<=0) {
			maxDimensie3 = 1;	// we hebben er 1 nodig voor PS en WV
		}
		
		// opvullen van berekende aantallen
		String[][][] spelSituatie = new String[3][maxDimensie2][maxDimensie3];
		// opvullen met images
		int counter1 = 0;
		int counter2 = 0;
		// PS
		for (Steen steen : PS) {
			spelSituatie[0][counter1][0] = steen.getAfbeelding();
			counter1++;
		}
		// WV
		counter1 = 0;
		for (Steen steen : WV) {
			spelSituatie[1][counter1][0] = steen.getAfbeelding();
			counter1++;
		}
		// GV
		counter1 = 0;
		for (Reeks reeks : GV) {
			counter2 = 0;
			for (Steen steen : reeks.getStenen()) {
				spelSituatie[2][counter1][counter2] = steen.getAfbeelding();
				counter2++;
			}
			counter1++;
		}

		// array teruggeven
		return spelSituatie;
	}
//Joost dit is een alternatieve methode. 
	// spelsituatie.get(0) bevat stenen van spelers type: List<Steen>
	// spelsituatie.get(1) bevat stenen op werkveld type: List<Steen>
	// spelsituatie.get(2) bevat reeksen op gemeenschappelijk veld type: List<Reeks>
	public List<List<String>> geefSpelsituatieJoost() {
		List<List<String>> spelsituatie = new ArrayList<List<String>>();

		List<Steen> spelerStenen = spelers.get(spelerAanZet).vraagAllePersoonlijkeStenenOp();
		List<String> spelerStenenInfo = new ArrayList<String>();
		for (int i = 0; i < spelerStenen.size(); i++) {
			spelerStenenInfo.add(spelerStenen.get(i).getAfbeelding());
		}
		spelsituatie.add(spelerStenenInfo);

		List<Steen> werkveldStenen = spelers.get(spelerAanZet).vraagAllePersoonlijkeStenenOp();
		List<String> werkveldStenenInfo = new ArrayList<String>();
		for (int i = 0; i < werkveldStenen.size(); i++) {
			werkveldStenenInfo.add(werkveldStenen.get(i).getAfbeelding());
		}
		spelsituatie.add(werkveldStenenInfo);

		List<Reeks> veldStenen = gemeenschappelijkVeld.getReeksen();
		List<String> veldStenenInfo = new ArrayList<String>();
		for (Reeks r : veldStenen) {
			for (Steen s : r.getStenen()) {
				veldStenenInfo.add(s.getAfbeelding());
			}
		}
		spelsituatie.add(veldStenenInfo);

		return spelsituatie;
	}

	// UC3
	/**
	 * Bij begin van de beurt word een duplicaat gemaakt van zowel de persoonlijke stenen van de spelers
	 * als van de stenen die zich op het gemeenschappelijk veld bevinden.
	 */
	public void startBeurt() {
		this.spelers.get(this.spelerAanZet).maakDuplicaatPersoonlijkeStenen();
		// initialiseer het werkveld (niets te doen, want is leeg)
		//initialiseer het GV
		this.gemeenschappelijkVeld.maakDuplicaat();
	}

	// UC3
	/**
	 * Geeft een lijst weer van al de acties die kunnen uitgevoerd worden voor het spel.
	 * De opsomming van deze acties bevindt zich in een enum.
	 * @return
	 */
	public String[] geefMogelijkeActies() {
		// Opzoeken hoe ik van enum een arrayList maak of opties weergeef.
		// p 48, hoofdstuk 6, OOSD1
		String[] mogelijkeActiesArray = new String[6];
		int counter = 0;
		for (MogelijkeActies ma : MogelijkeActies.values()) {
			mogelijkeActiesArray[counter] = ma.name();
			counter++;
		}
		return mogelijkeActiesArray;
	}

	// UC3
	/**
	 * Er wordt gekeken als de huidige spelsituatie voldoet. 
	 * - Huidige spelsituatie voldoet niet: er wordt een exception gegooid
	 * - Huidige spelsituatie voldoet: De functie eindeBeurt kan opgeroepen worden. 
	 * @throws Exception
	 */
	public void beeindigBeurt() throws Exception {
		if (this.bepaalGeldigeSpelSituatie()) {
			this.eindeBeurt();
		}
	}

	// UC3
	/**
	 * Controleren als er nog stenen in werkveld liggen 
	 * JA: foutmelding.
	 * NEE: controleren als er stenen zijn afgelegd.
	 * 		JA: regels nakijken ivm joker, waarden en geldige spelsituatie ivm rij en serie.
	 * 		NEE: steen bijgeven aan speler.
	 * 
	 * @throws Exception
	 */
	private boolean bepaalGeldigeSpelSituatie() throws Exception {
		boolean isGeldig = true;
		Speler actieveSpeler = this.spelers.get(this.spelerAanZet);
		if (werkveld.getStenenWerkveld().size() == 0) { // GEEN stenen werkveld
			if (actieveSpeler.hoeveelStenenHeeftDeSpeler() != actieveSpeler.getDuplicaatPersoonlijkeStenen().size()) { // stenen
																														// afgelegt
				if (this.gemeenschappelijkVeld.bepaalGeldigeSpelsituatie()) {
					int nieuweReeksCounter = 0;
					int somStenen = 0;
					for (Reeks actieveReeks : this.gemeenschappelijkVeld.getReeksen()) {
						if (actieveSpeler.getEersteUitleg() && actieveReeks.getIsNieuw()) {
							nieuweReeksCounter++;
							for (Steen s : actieveReeks.getStenen()) {
								if (s.getWaarde() == 25) { // joker in nieuwe reeks --> Waar staat joker gedefinieerd??
									throw new Exception(language.getString("jokerBijEersteAfleg"));
									//throw new Exception("Bij de eerste afleg mag er geen gebruik gemaakt worden van een Joker.");
								} else { // geen joker in nieuwe reeks
									somStenen += s.getWaarde();
								}
							}
							
						} else {
							isGeldig = true;
						}
						actieveReeks.setIsNieuw(false);
					}
					if(actieveSpeler.getEersteUitleg()) {
						if(nieuweReeksCounter == 0) {
							throw new Exception(language.getString("eersteUitlegNieuweReeks"));
							//throw new Exception("Bij een eerste uitleg moet minstens 1 van de reeksen op het GV nieuw zijn.");	
						}
						else if (somStenen >= 30) {
							actieveSpeler.setEersteUitleg(false);
						} else { // somStenen < 30
							throw new Exception(language.getString("somEersteUitlegTeLaag"));
							//throw new Exception("Bij een eerste uitleg moet de som van de gelegde stenen minimaal 30 zijn.");
						}
					}
				} else { // indien geen geldigeSpelsituatie
					throw new Exception(language.getString("stenenVoldoetNietAanRijOfSerie"));
					//throw new Exception("De stenen op het werkveld voldoen niet aan de eisen van een rij of serie.");
				}
			} else { // geen stenen afgelegd
				actieveSpeler.voegSteenToe(this.pot.geefSteen());
				isGeldig = true;
			}
		} else { // Er liggen nog stenen op het werkveld !!
			isGeldig = false;
			throw new Exception(language.getString("nogStenenOpWerkVeld"));
			//throw new Exception("Er mogen geen stenen meer in uw werkveld liggen!"); // indien werkveld niet leeg is
		}
		return isGeldig;
	}

	// UC3
	/**
	 * Oproepen van de functie splitsRijOfSerie uit het gemeenschappelijkVeld.
	 * 
	 * @param reeksnummer
	 * @param positieInReeks
	 * @throws Exception
	 */
	public void splitsRijOfSerie(int reeksnummer, int positieInReeks) throws Exception {
		this.gemeenschappelijkVeld.splitsRijOfSerie(reeksnummer, positieInReeks);
	}

	// UC3
	/**
	 * Oproepen van de functie legSteenAan uit het gemeenschappelijkVeld.
	 * Extra controle om te kijken van waaruit de steen komt. 
	 * Deze steen kan uit de persoonlijkeStenen komen of uit het werkVeld.
	 * Er word een exception gegooid indien de functie legSteenAan uit gemeenschappelijkVeld niet kan worden opgeroepen.
	 * 
	 * 
	 * @param nummerInInput
	 * @param positieInInput
	 * @param reeksnummer
	 * @param positieInReeks
	 * @throws Exception
	 */
	public void legSteenAan(int nummerInInput, int positieInInput, int reeksnummer, int positieInReeks)
			throws Exception {
		// pak de steen
		Steen steenOmAanTeLeggen;
		// nummerInInput '0': PS
		// nummerInInput '1': Werkveld
		switch (nummerInInput) {
		case 0:
			steenOmAanTeLeggen = this.spelers.get(this.spelerAanZet).vraagAllePersoonlijkeStenenOp()
					.remove(positieInInput);
			break;
		default:
			steenOmAanTeLeggen = this.werkveld.getStenenWerkveld().remove(positieInInput);
		}

		try {
			this.gemeenschappelijkVeld.legSteenAan(steenOmAanTeLeggen, reeksnummer, positieInReeks);
		} catch (Exception e) {
			// we kunnen de steen niet aanleggen
			// nu moeten we hem terugleggen vanwaar hij kwam
			switch (nummerInInput) {
			case 0:
				List<Steen> psLijst = this.spelers.get(this.spelerAanZet).vraagAllePersoonlijkeStenenOp();
				this.legSteenTerug(psLijst, positieInInput, steenOmAanTeLeggen);
				break;
			default:
				List<Steen> werkveldLijst = this.werkveld.getStenenWerkveld();
				this.legSteenTerug(werkveldLijst, positieInInput, steenOmAanTeLeggen);
			}

			// We gooien de exception verder
			throw e;
		}
	}
	
	
	// UC3
	/**
	 * 
	 * @param teruglegLijst
	 * @param positieInInput
	 * @param steenOmAanTeLeggen
	 */
	private void legSteenTerug(List<Steen> teruglegLijst, int positieInInput, Steen steenOmAanTeLeggen) {
		// de lijst wordt 1 index groter
		teruglegLijst.add(steenOmAanTeLeggen);
		// omzetten naar array om dan de staart te kopieren
		Steen[] stenenArray = teruglegLijst.toArray(new Steen[teruglegLijst.size()]);
		// staart kopieren
		Steen[] stenenArrayCopyRange = Arrays.copyOfRange(stenenArray, positieInInput, stenenArray.length - 1);
		// steen aanleggen
		teruglegLijst.set(positieInInput, steenOmAanTeLeggen);
		// staart terug aan de reeks hangen
		IntStream.range(positieInInput + 1, teruglegLijst.size())
				.forEach(x -> teruglegLijst.set(x, stenenArrayCopyRange[x - positieInInput - 1]));
	}

	// UC3
	/**
	 * Oproepen van de functie vervangJoker uit het gemeenschappelijkVeld.
	 * Extra controle om te kijken van waaruit de steen komt. 
	 * Deze steen kan uit de persoonlijkeStenen komen of uit het werkVeld.
	 * Er word een exception gegooid indien de functie vervangJoker uit gemeenschappelijkVeld niet kan worden opgeroepen.
	 * 
	 * @param nummerInInput
	 * @param positieInInput
	 * @param reeksnummer
	 * @param positieInReeks
	 * @throws Exception
	 * @throws SteenIsGeenJokerException
	 */
	public void vervangJoker(int nummerInInput, int positieInInput, int reeksnummer, int positieInReeks)
			throws Exception, SteenIsGeenJokerException {
		// pak de steen
		Steen steenOmJokerTeVervangen;
		Steen tijdelijkejoker;
		// nummerInInput '0': PS
		// nummerInInput '1': Werkveld
		switch (nummerInInput) {
		case 0:
			steenOmJokerTeVervangen = this.spelers.get(this.spelerAanZet).vraagAllePersoonlijkeStenenOp()
					.remove(positieInInput);
			break;
		default:
			steenOmJokerTeVervangen = this.werkveld.getStenenWerkveld().remove(positieInInput);
		}

		try {
/*jcr*/		tijdelijkejoker = this.gemeenschappelijkVeld.vervangJoker(steenOmJokerTeVervangen, reeksnummer, positieInReeks);
			werkveld.voegSteenToeWerkveld(tijdelijkejoker);
		} catch (Exception e) {
			// we kunnen de steen niet aanleggen
			// nu moeten we hem terugleggen vanwaar hij kwam
			switch (nummerInInput) {
			case 0:
				List<Steen> psLijst = this.spelers.get(this.spelerAanZet).vraagAllePersoonlijkeStenenOp();
				this.legSteenTerug(psLijst, positieInInput, steenOmJokerTeVervangen);
				break;
			default:
				List<Steen> werkveldLijst = this.werkveld.getStenenWerkveld();
				this.legSteenTerug(werkveldLijst, positieInInput, steenOmJokerTeVervangen);
			}

			// We gooien de exception verder
			throw e;
		}
	}

	// UC3
	/**
	 * Toevoegen van een steen in het werkveld.
	 * De steen wordt gehaald uit het gemeenschappelijkVeld.
	 * 
	 * @param reeksnummer
	 * @param positieInReeks
	 * @throws Exception
	 */
	public void steenNaarWerkveld(int reeksnummer, int positieInReeks) throws Exception {
		// in geval van problemen moeten we hier niets terugleggen, we kunnen de
		// exception gewoon verder gooien
		this.werkveld.voegSteenToeWerkveld(this.gemeenschappelijkVeld.steenNaarWerkveld(reeksnummer, positieInReeks));
	}
	
	// UC3
	/**
	 * Bij elk veld wordt een functie reset of maakLeeg opgeroepen
	 */
	public void resetBeurt() {
		// PS
		this.spelers.get(this.spelerAanZet).resetPersoonlijkeStenen();
		
		// WV
		this.werkveld.maakLeeg();
		
		// GV
		this.gemeenschappelijkVeld.resetGemeenschappelijkVeld();
	}
	
	// UC3
	public void fictiefEinde() {
		this.spelers.get(this.spelerAanZet).verwijderAllePersoonlijkeStenen();
		this.eindeBeurt();
	}

	// tijdelijk om vlug te testen
	public void startspel2() {
		if(pot == null)this.pot = new Pot();
		this.werkveld = new Werkveld();
		this.gemeenschappelijkVeld = new GemeenschappelijkVeld();
		this.randomizeVolgordeSpelers();
		this.spelerAanZet = 0;
		this.spelers.get(this.spelerAanZet).maakDuplicaatPersoonlijkeStenen();
		this.gemeenschappelijkVeld.maakDuplicaat();
	}
	
	// tijdelijk om vlug te testen
	public void normaleStenen(Speler s) {
		if(pot == null)this.pot = new Pot();
		for (int i = 0; i < AANTAL_STENEN_PER_SPELER_BIJ_AANVANG; i++) {
			Steen steen = pot.geefSteen();
			s.voegSteenToe(steen);
		}
	}

}
