package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Speler{

	//UC2 
	private String spelersnaam;
	private String wachtwoord;
	private int score;
	//UC3
	private List<Steen> persoonlijkeStenen; // Vervangt constructor persoonlijkeStenen
	private boolean eersteUitleg;

	/** Elke speler zal ook stenen hebben: ArrayList bij voorkeur te gebruiken bij veel opzoekingen */
	public Speler(String spelersnaam, String wachtwoord) {
		setSpelersnaam(spelersnaam);
		setWachtwoord(wachtwoord);
		
		this.persoonlijkeStenen = new ArrayList<>();
		this.setScore(0);
		this.setEersteUitleg(true);
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
	
	// UC2
	/** bij de start van het spel krijgt iedere speler 14 stenen, 1 per keer, via deze methode */
	public void voegSteenToe(Steen steen) {
		this.persoonlijkeStenen.add(steen);
	}
	
	// UC2
	/** om te bepalen of het spel beëindigd is moeten we kunnen opvragen hoeveel stenen elke speler nog heeft */
	public int hoeveelStenenHeeftDeSpeler() {
		return this.persoonlijkeStenen.size();
	}
	
	// UC2
	public int somVanStenen() {
		return (this.persoonlijkeStenen.stream()
	                       .mapToInt(Steen::getWaarde)
	                       .sum());
	}
	
	//UC2
	public void pasScoreAan(int waarde) {
		this.score += waarde;
	}
	
	//UC3
	/*
	 * Link met stenen om lijst op te vragen. Hoeft hiervoor geen aparte klasse te definiëren. NIET aantal maar lijst
	 * Plus duplicaat van de stenen van deze speler worden hier gemaakt. 
	 */
	public List<Steen> vraagAllePersoonlijkeStenenOp(){ //Vervangt getStenen uit PS
		return persoonlijkeStenen;
	}
	
	public List<Steen> maakDuplicaatPersoonlijkeStenen(){ //Vervangt methode maakDuplicaat uit PS
		List<Steen> duplicaat = new ArrayList<>();
		for(Steen persoonlijkeSteen: this.persoonlijkeStenen) {
			duplicaat.add(persoonlijkeSteen);
		}
		return duplicaat;
	}
	
	//UC3
	public boolean getEersteUitleg() {
		return eersteUitleg;
	} 
	
	//UC3
	// EersteUitleg: Zijn eerste uitleg  van stenen naar GemVeld moet nog gebeuren
	public void setEersteUitleg(boolean eersteUitleg) {  
		this.eersteUitleg = eersteUitleg;
	}
	
}

