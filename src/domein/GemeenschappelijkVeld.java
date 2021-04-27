package domein;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//UC3
public class GemeenschappelijkVeld {
	private GemeenschappelijkVeld duplicaatGemeenschappelijkVeld;
	private List<Reeks> reeksen;
	
	
	
	public GemeenschappelijkVeld() {
		
	}

	public void maakDuplicaat() {
		
	}
	
	public Reeks[] getReeksen() {
		
	}
	
	public boolean bepaalGeldigeSpelsituatie() {
		boolean isGeldig = true;
		// loop over alle reeksen
		Iterator<Reeks> iterator = this.reeksen.iterator();
		
		int index = 0;
		while (isGeldig && iterator.hasNext()) {
			Reeks kandidaatReeks = iterator.next();
			// eerste proberen we een rij
			kandidaatReeks = new Rij(kandidaatReeks.getRijnummer(), kandidaatReeks.isGewijzigd(), kandidaatReeks.getStenen());
			isGeldig = kandidaatReeks.bepaalIsGeldig();
			
			
			// indien ongeldig, dan proberen we een serie
			if(!isGeldig) {
				kandidaatReeks = new Serie(kandidaatReeks.getRijnummer(), kandidaatReeks.isGewijzigd(), kandidaatReeks.getStenen());
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
	
	public void splitsRijOfSerie(int reeksnummer, int positieInReeks) {
		
	}
	
	public void legSteenAan(Steen steen, int reeksnummeer, int positieInReeks) {
		
	}
	
	public Steen vervangJoker(Steen steen, int reeksnummer, int positieInReeks) {
		
	}
	
	public Steen steenNaarWerveld(int reeknummer, int positieInReeks) {
		
	}

		
	
}
