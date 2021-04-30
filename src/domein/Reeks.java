package domein;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//UC3
public class Reeks {
	private int rijnummer;
	private boolean isNieuw;
	private List<Steen> stenen;
	
	
	//UC3
	public Reeks(int rijnummer, List<Steen> stenen) {
		this.setRijnummer(rijnummer);
		this.setIsNieuw(true);
		this.setStenen(stenen);
	}
	
	//UC3
	public int getRijnummer() {
		return this.rijnummer;
	}
	
	//UC3
	private void setRijnummer(int rijnummer) {
		this.rijnummer = rijnummer;
	}
	
	//UC3
	public boolean isNieuw() {
		return this.isNieuw;
	}
	
	//UC3
	public void setIsNieuw(boolean isNieuw) {
		this.isNieuw = isNieuw;
	}
	
	//UC3
	public List<Steen> getStenen() {
		return this.stenen;
	}

	//UC3
	public void setStenen(List<Steen> stenen) {
		this.stenen = stenen;
	}

	//UC3
	protected boolean bepaalIsGeldig() {
		// minimaal 3 stenen voor zowel Rij als Serie
		if(this.getStenen().size() < 3) {
			return false;
		}
		return true;
	}
	
	//UC3
	public void legSteenAan(Steen steen, int positieInReeks) {
		// de reeks wordt 1 index groter
		// omzetten naar array om dan de staart te kopieren
		Steen[] stenenArray = this.getStenen().toArray(new Steen[this.getStenen().size()]);
		// staart kopieren
		Steen[] stenenArrayCopyRange = Arrays.copyOfRange(stenenArray, positieInReeks-1, stenenArray.length);
		// steen aanleggen
		stenenArrayCopyRange[0] = steen;
		// staart terug aan de reeks hangen
		IntStream.rangeClosed(positieInReeks, this.getStenen().size()+1)
		         .forEach(x -> this.getStenen().set(x, stenenArrayCopyRange[x-positieInReeks]));
		
	}
	
	//UC3
	public Steen vervangJoker(Steen steen, int positieInReeks) {
		// de reeks blijft even groot
		// pak de joker
		Steen joker = this.getStenen().get(positieInReeks);
		// voeg de steen in op die positie
		this.getStenen().set(positieInReeks, steen);
		// retourneer de joker (moet naar het werkveld)
		return joker;
	}
	
	//UC3
	public Steen steenNaarWerkveld(int positieInReeks) {
		// de reeks wordt 1 index kleiner
		return this.getStenen().remove(positieInReeks);
	}

}
