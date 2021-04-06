package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Speler{

	private String spelersnaam;
	private String wachtwoord;
	private List<Steen> stenen;
	private int score;

	/** Elke speler zal ook stenen hebben: ArrayList bij voorkeur te gebruiken bij veel opzoekingen */
	public Speler(String spelersnaam, String wachtwoord) {
		setSpelersnaam(spelersnaam);
		setWachtwoord(wachtwoord);
		
		this.stenen = new ArrayList<>();
		this.setScore(0);
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
	
	public int getScore() {
		return score;
	}

	private void setScore(int score) {
		this.score = score;
	}

	public void resetWachtwoord() {
		this.wachtwoord = "";
	}
	
	//UC2
	/** bij de start van het spel krijgt iedere speler 14 stenen, 1 per keer, via deze methode */
	public void voegSteenToe(Steen steen) {
		this.stenen.add(steen);
	}
	
	//UC2
	/** om te bepalen of het spel beëindigd is moeten we kunnen opvragen hoeveel stenen elke speler nog heeft */
	public int hoeveelStenenHeeftDeSpeler() {
		return this.stenen.size();
	}
	
	//UC2
	public int somVanStenen() {
		return (this.stenen.stream()
	                       .mapToInt(Steen::getWaarde)
	                       .sum());
	}
	
	//UC2
	public void pasScoreAan(int waarde) {
		this.score += waarde;
	}
	
	
	
}

