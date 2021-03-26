package domein;

import java.util.ArrayList;
import java.util.List;

public class Speler {

	private String spelersnaam;
	private String wachtwoord;
	private List<Steen> stenen;
	private int score;

	/** Elke speler zal ook stenen hebben: ArrayList bij voorkeur te gebruiken bij veel opzoekingen */
	public Speler(String spelersnaam, String wachtwoord) {
		setSpelersnaam(spelersnaam);
		setWachtwoord(wachtwoord);
		
		this.stenen = new ArrayList<>();
	}

	public String getSpelersnaam() {
		return this.spelersnaam;
	}

	private void setSpelersnaam(String spelersnaam) {
		this.spelersnaam = spelersnaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	private void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	
	public void resetWachtwoord() {
		this.wachtwoord = "";
	}
	
	public void voegSteenToe(Steen steen) {
		this.stenen.add(steen);
	}
	
	public int berekenScore() {
		return 1;
	}
	
}

