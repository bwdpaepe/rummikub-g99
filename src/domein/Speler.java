package domein;

public class Speler {

	private String spelersnaam;
	private String wachtwoord;

	public Speler(String spelersnaam, String wachtwoord) {
		setSpelersnaam(spelersnaam);
		setWachtwoord(wachtwoord);
	}

	public String getSpelersnaam() {
		return this.spelersnaam;
	}

	public void setSpelersnaam(String spelersnaam) {
		this.spelersnaam = spelersnaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	private void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	
}

