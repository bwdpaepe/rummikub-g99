package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

//UC3
public class GemeenschappelijkVeld {

	private GemeenschappelijkVeld duplicaatGemeenschappelijkVeld;
	private List<Reeks> reeksen;
	
	
	
	//UC3
	public GemeenschappelijkVeld() {
		this.reeksen = new ArrayList<>();
	}

	//UC3

	public void maakDuplicaat() {
		
	}
	
	//UC3
	public List<Reeks> getReeksen() {
		return this.reeksen;
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
			kandidaatReeks = new Rij(kandidaatReeks.getRijnummer(), kandidaatReeks.getStenen());
			isGeldig = kandidaatReeks.bepaalIsGeldig();
			
			
			// indien ongeldig, dan proberen we een serie
			if(!isGeldig) {
				kandidaatReeks = new Serie(kandidaatReeks.getRijnummer(), kandidaatReeks.getStenen());
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
	public void splitsRijOfSerie(int reeksnummer, int positieInReeks) {
		// het GV wordt 1 index groter
		this.getReeksen().add(new Reeks(this.getReeksen().size() + 1, new ArrayList<Steen>()));
		// omzetten naar array om dan de staart te kopieren
		Reeks[] reeksenArray = this.getReeksen().toArray(new Reeks[this.getReeksen().size()]);
		// staart kopieren
		Reeks[] reeksenArrayCopyRange = Arrays.copyOfRange(reeksenArray, reeksnummer + 1, reeksenArray.length);
		// asList
		List<Reeks> listReeksenArrayCopyRange = new ArrayList<>(Arrays.asList(reeksenArrayCopyRange));
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
		Reeks eersteReeks = new Reeks(reeksnummer, eersteStenen);
		Reeks tweedeReeks = new Reeks(reeksnummer+1, tweedeStenen);
		// reeksen terug aan GV hangen
		this.getReeksen().set(reeksnummer, eersteReeks);
		this.getReeksen().set(++reeksnummer, tweedeReeks);
		for(Reeks reeks: listReeksenArrayCopyRange) {
			this.getReeksen().set(++reeksnummer, reeks);
		}
		
	}
	
	//UC3
	public void legSteenAan(Steen steen, int reeksnummer, int positieInReeks) throws Exception {
		// maak backup
		Reeks backupReeks = this.getReeksen().get(reeksnummer);
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
		else {
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
	}
	
	//UC3
	public Steen vervangJoker(Steen steen, int reeksnummer, int positieInReeks) throws Exception {
		// maak backup
		Reeks backupReeks = this.getReeksen().get(reeksnummer);
		// vervang joker
		Steen joker = this.getReeksen().get(reeksnummer).vervangJoker(steen, positieInReeks);
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
		else {
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
		// geef de joker aan Spel (moet naar Werkveld)
		return steenVoorWerkveld;
	}

		
	
}
