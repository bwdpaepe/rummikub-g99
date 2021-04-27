package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Reeks {
	private int rijnummer;
	private boolean isNieuw;
	private List<Steen> stenen;
	
	
	public Reeks(int rijnummer, boolean isNieuw, List<Steen> stenen) {
		this.setRijnummer(rijnummer);
		this.setIsNieuw(isNieuw);
		this.setStenen(stenen);
	}
	
	public int getRijnummer() {
		return this.rijnummer;
	}
	private void setRijnummer(int rijnummer) {
		this.rijnummer = rijnummer;
	}
	public boolean isNieuw() {
		return this.isNieuw;
	}
	private void setIsNieuw(boolean isNieuw) {
		this.isNieuw = isNieuw;
	}
	
	
	
	public List<Steen> getStenen() {
		return this.stenen;
	}

	public void setStenen(List<Steen> stenen) {
		this.stenen = stenen;
	}

	protected boolean bepaalIsGeldig() {
		// minimaal 3 stenen voor zowel Rij als Serie
		if(this.getStenen().size() < 3) {
			return false;
		}
		return true;
	}
	
	public void legSteenAan(Steen steen, int positieInReeks) {
		
		Steen[] stenenArray = this.getStenen().toArray(new Steen[this.getStenen().size()]);
		Steen[] stenenArrayCopyRange = Arrays.copyOfRange(stenenArray, positieInReeks-1, stenenArray.length);
		stenenArrayCopyRange[0] = steen;
		IntStream.rangeClosed(positieInReeks, this.getStenen().size()+1)
		         .forEach(x -> this.getStenen().set(x, stenenArrayCopyRange[x-positieInReeks]));
		this.valideerLegSteenAan(positieInReeks);
		
	}
	
	private void valideerLegSteenAan(int positieInReeks) {
		
	}
	
	public Steen vervangJoker(Steen steen, int positieInReeks) {
		return this.getStenen().remove(positieInReeks);
	}
	private void valideerVervangJoker(Steen steen, int positieInReeks) {
		
	}
	
	public Steen steenNaarWerkveld(int positieInReeks) {
		return this.getStenen().remove(positieInReeks);
	}
	private void valideerSteenNaarWerkveld(int positieInReeks) {
		
	}

}
