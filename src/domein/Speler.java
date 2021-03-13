package domein;

public class Speler {

	private String spelersnaam;
	private String wachtwoord;

	public Speler(String gebruikersnaam, String wachtwoord) {
		setGebruikersnaam(gebruikersnaam);
		setWachtwoord(wachtwoord);
	}

	public String getGebruikersnaam() {
		return this.spelersnaam;
	}

	public void setGebruikersnaam(String spelersnaam) {
		this.spelersnaam = spelersnaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	private void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
		
}

