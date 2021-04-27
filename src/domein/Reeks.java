package domein;

import java.util.ArrayList;
import java.util.List;

public class Reeks {
	private int rijnummer;
	private boolean isGewijzigd;
	private List<Steen> stenen;
	
	
	public Reeks(int rijnummer, boolean isGewijzigd, List<Steen> stenen) {
		this.setRijnummer(rijnummer);
		this.setGewijzigd(isGewijzigd);
		this.setStenen(stenen);
	}
	
	public int getRijnummer() {
		return rijnummer;
	}
	private void setRijnummer(int rijnummer) {
		this.rijnummer = rijnummer;
	}
	public boolean isGewijzigd() {
		return isGewijzigd;
	}
	private void setGewijzigd(boolean isGewijzigd) {
		this.isGewijzigd = isGewijzigd;
	}
	
	
	
	public List<Steen> getStenen() {
		return this.stenen;
	}

	public void setStenen(List<Steen> stenen) {
		this.stenen = stenen;
	}

	protected boolean bepaalIsGeldig() {
		// minimaal 3 stenen voor zowel Rij als Serie
		if(this.stenen.size() < 3) {
			return false;
		}
		return true;
	}
	
	public void legSteenAan(Steen steen, int positieInReeks) {
		
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
