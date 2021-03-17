package domein;

import java.util.ArrayList;
import java.util.List;

public class Spel {

	private int aantalSpelers;
	private List<Speler> spelers = new ArrayList<>();
	public static final int maximumSpelers = 4;
	public static final int minimumSpelers = 2;
	
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
	
	//UC1
	public boolean voegSpelerToe(Speler speler)  {
		if (!reedsAangemeld(speler.getSpelersnaam())) {
			spelers.add(speler);
			return true;
		}
		return false;
	}
	
	//UC1
	private boolean reedsAangemeld(String spelersnaam) {
		for(Speler speler:spelers) {
			if (speler.getSpelersnaam().equals(spelersnaam)) {
				return true;
			} 
		}
		return false;
	}
	
	//UC1
	public List<String> geefSpelersnamen() {
		List<String> spelersnamen = new ArrayList<>();
		for (Speler speler: spelers) {
			spelersnamen.add(speler.getSpelersnaam());
		}
		return spelersnamen;
	} 
	
}
