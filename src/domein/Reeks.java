package domein;

public abstract class Reeks {
	private int rijnummer;
	private boolean isGewijzigd;
	
	
	public Reeks() {
		
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
	
	public void legSteenAan(Steen steen, int positieInReeks) {
		
	}
	private void valideerLegSteenAan(int positieInReeks) {
		
	}
	
	public Steen vervangJoker(Steen steen, int positieInReeks) {
		
	}
	private void valideerVervangJoker(Steen steen, int positieInReeks) {
		
	}
	
	public Steen steenNaarWerkveld(int positieInReeks) {
		
	}
	private void valideerSteenNaarWerkveld(int positieInReeks) {
		
	}

}
