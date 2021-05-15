package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import exceptions.SteenIsGeenJokerException;
import exceptions.VeldIsLeegException;
import talen.Language;

//UC3
public class GemeenschappelijkVeld {

	private List<Reeks> duplicaatGemeenschappelijkVeld;
	private List<Reeks> reeksen;
	//Voor vertaling
	private Language language = Language.getInstance();
	
	
	//UC3
	public GemeenschappelijkVeld() {
		this.reeksen = new ArrayList<>();
	}

	//UC3
	public void maakDuplicaat() {
		this.duplicaatGemeenschappelijkVeld = new ArrayList<>(this.reeksen);
	}
	
	//UC3
	public void resetGemeenschappelijkVeld() {
		this.reeksen = new ArrayList<>(this.duplicaatGemeenschappelijkVeld);
	}
	
	//UC3
	public List<Reeks> getDuplicaatGemeenschappelijkVeld(){
		return this.duplicaatGemeenschappelijkVeld;
	}
	
	//UC3
	public List<Reeks> getReeksen() {
		return this.reeksen;
	}
	
	
	//UC3
	public void setReeksen(List<Reeks> reeksen) {
		this.reeksen = reeksen;
	}

	//UC3
	public boolean bepaalGeldigeSpelsituatie() {
		boolean isGeldig = true;
		// loop over alle reeksen
		Iterator<Reeks> iterator = this.reeksen.iterator();
		
		int index = 0;
		while (isGeldig && iterator.hasNext()) {
			Reeks kandidaatReeks = iterator.next();
			// eerste proberen we een rij
			kandidaatReeks = new Rij(kandidaatReeks.getRijnummer(), kandidaatReeks.getStenen(), kandidaatReeks.getIsNieuw());
			isGeldig = kandidaatReeks.bepaalIsGeldig();
			
			// indien ongeldig, dan proberen we een serie
			if(!isGeldig) {
				kandidaatReeks = new Serie(kandidaatReeks.getRijnummer(), kandidaatReeks.getStenen(), kandidaatReeks.getIsNieuw());
				isGeldig = kandidaatReeks.bepaalIsGeldig();
				if(isGeldig) {
					this.reeksen.set(index,kandidaatReeks);
				}
			}
			else {
				this.reeksen.set(index,kandidaatReeks);
			}
			index++;
		}
		return isGeldig;
	}
	
	//UC3
	public void splitsRijOfSerie(int reeksnummer, int positieInReeks) throws Exception {
		if(positieInReeks == -1) {
			throw new Exception(language.getString("foutieveSplitsing"));
			//throw new Exception("De reeks kan niet gesplitst worden op deze positie");
		}
		// het GV wordt 1 index groter
		// omzetten naar array om dan de staart te kopieren
		Reeks[] reeksenArray = this.getReeksen().toArray(new Reeks[this.getReeksen().size() + 1]);
		// staart kopieren
		Reeks[] reeksenArrayCopyRange = Arrays.copyOfRange(reeksenArray, reeksnummer + 1, reeksenArray.length -1);
		// reeks splitsen
		List<Steen> eersteStenen = new ArrayList<>();
		List<Steen> tweedeStenen = new ArrayList<>();
		int counter = 0;
		for(Steen steen: this.getReeksen().get(reeksnummer).getStenen()) {
			if(counter < positieInReeks) {
				eersteStenen.add(steen);
			}
			else {
				tweedeStenen.add(steen);
			}
			counter++;
		}
		Reeks eersteReeks = new Reeks(reeksnummer, eersteStenen, false);
		Reeks tweedeReeks = new Reeks(reeksnummer+1, tweedeStenen, false);
		// reeksen terug aan GV hangen
		reeksenArray[reeksnummer] = eersteReeks;
		reeksenArray[++reeksnummer] = tweedeReeks;
		this.setReeksen(new ArrayList<>(Arrays.asList(reeksenArray)));
		for(Reeks reeks: reeksenArrayCopyRange) {
			++reeksnummer;
			reeks.setRijnummer(reeksnummer);
			this.getReeksen().set(reeksnummer, reeks);
		}
	}
	
	//UC3
	public void legSteenAan(Steen steen, int reeksnummer, int positieInReeks) throws Exception {
		// bestaat deze reeks al?
		if(reeksnummer < this.getReeksen().size()) {	// deze reeks bestaat al
			// maak backup
			Reeks backupReeks = this.getReeksen().get(reeksnummer);
			// if positieInReeks == -1 dan wordt de steen aan het begin toegevoegd
			if(positieInReeks == -1) { positieInReeks++; }
			// leg steen aan
			this.getReeksen().get(reeksnummer).legSteenAan(steen, positieInReeks);
			// valideer
			// Rij
			if(this.getReeksen().get(reeksnummer) instanceof Rij) {
				Rij valideerRij = (Rij)this.getReeksen().get(reeksnummer);
				try {
					valideerRij.valideerLegSteenAan();
				} catch (Exception e) {
					// zet de backup terug
					this.getReeksen().set(reeksnummer, backupReeks);
					// gooi de error verder (naar Spel)
					throw e;
				}
			}
			// Serie
			else if(this.getReeksen().get(reeksnummer) instanceof Serie) {
				Serie valideerSerie = (Serie)this.getReeksen().get(reeksnummer);
				try {
					valideerSerie.valideerLegSteenAan();
				} catch (Exception e) {
					// zet de backup terug
					this.getReeksen().set(reeksnummer, backupReeks);
					// gooi de error verder (naar Spel)
					throw e;
				}
			}	
			// nog niet bepaald
			else {
				// niets te doen
			}
		}
		else {	// deze reeks bestaat nog niet
			// maak de reeks
			List<Steen> steenLijst = new ArrayList<>();
			steenLijst.add(steen);
			this.getReeksen().add(new Reeks(reeksnummer, steenLijst, true));
			// validatie is niet nodig want er zit slechts 1 steen in
		}
	}
	
	//UC3
	public Steen vervangJoker(Steen steen, int reeksnummer, int positieInReeks) throws Exception, SteenIsGeenJokerException,VeldIsLeegException {
		
		Steen joker;
		if(positieInReeks == -1) {
			throw new VeldIsLeegException(language.getString("foutieveLocatieJoker"));

		}
		
		// maak backup
		Reeks backupReeks = this.getReeksen().get(reeksnummer);
		// vervang joker
		joker = this.getReeksen().get(reeksnummer).vervangJoker(steen, positieInReeks);
		// valideer
		// Rij
		if(this.getReeksen().get(reeksnummer) instanceof Rij) {
			Rij valideerRij = (Rij)this.getReeksen().get(reeksnummer);
			try {
				valideerRij.valideerVervangJoker();
			} catch (Exception e) {
				// zet de backup terug
				this.getReeksen().set(reeksnummer, backupReeks);
				// gooi de error verder (naar Spel)
				throw e;
			}
		}
		// Serie
		else {
			Serie valideerSerie = (Serie)this.getReeksen().get(reeksnummer);
			try {
				valideerSerie.valideerVervangJoker();
			} catch (Exception e) {
				// zet de backup terug
				this.getReeksen().set(reeksnummer, backupReeks);
				// gooi de error verder (naar Spel)
				throw e;
			}
		}
		// geef de joker aan Spel (moet naar Werkveld)
		return joker;
	}
	
	//UC3
	public Steen steenNaarWerkveld(int reeksnummer, int positieInReeks) throws Exception {
		if(positieInReeks == -1) {
			throw new Exception(language.getString("foutieveLocatieSteenWerkveld"));
			//throw new Exception("De steen op deze positie kan niet naar het werkveld");
		}
		
		// maak backup
		Reeks backupReeks = this.getReeksen().get(reeksnummer);
		// haal een Steen
		Steen steenVoorWerkveld = this.getReeksen().get(reeksnummer).steenNaarWerkveld(positieInReeks);
		// valideer
		// Rij
		if(this.getReeksen().get(reeksnummer) instanceof Rij) {
			Rij valideerRij = (Rij)this.getReeksen().get(reeksnummer);
			try {
				valideerRij.valideerSteenNaarWerkveld();
			} catch (Exception e) {
				// zet de backup terug
				this.getReeksen().set(reeksnummer, backupReeks);
				// gooi de error verder (naar Spel)
				throw e;
			}
		}
		// Serie
		else if(this.getReeksen().get(reeksnummer) instanceof Serie){
			Serie valideerSerie = (Serie)this.getReeksen().get(reeksnummer);
			try {
				valideerSerie.valideerSteenNaarWerkveld();
			} catch (Exception e) {
				// zet de backup terug
				this.getReeksen().set(reeksnummer, backupReeks);
				// gooi de error verder (naar Spel)
				throw e;
			}
		}
		else {
			// nog niet bepaald rij of serie
			// niets te doen
		}
		// geef de joker aan Spel (moet naar Werkveld)
		return steenVoorWerkveld;
	}

		
	
}
