package domein;

import java.util.ArrayList;
import java.util.List;

public class Spel {

	private int aantalSpelers;
	private List<Speler> spelers = new ArrayList<>();
	
	public Spel(int aantalSpelers) {
		setAantalSpelers(aantalSpelers);
		// te wissen enkel om te testen zonder repo
	}

	public int getAantalSpelers() {
		return aantalSpelers;
	}

	private void setAantalSpelers(int aantalSpelers) {
		this.aantalSpelers = aantalSpelers;
	}
	
	public boolean voegSpelerToe (Speler speler)  {
		if (!reedsAangemeld(speler.getGebruikersnaam())) {
			spelers.add(speler);
			return true;
		}
		return false;
	}
	

	private boolean reedsAangemeld (String spelersnaam) {
		for(int i=0; i<spelers.size();i++) {
			if (spelers.get(i).getGebruikersnaam().equals(spelersnaam)) {
				return true;
			} 
		}
		return false;
	}

	public List<String> geefSpelersnamen() {
		int i;
		List<String> spelersnamen = new ArrayList<>();
		for (i=0; i<spelers.size(); i++) {
			spelersnamen.add(spelers.get(i).getGebruikersnaam());
		}
		return spelersnamen;
	} 
	
}
