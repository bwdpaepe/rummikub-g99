package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Speler;
	
public class SpelerMapper {
	
	List<Speler> spelers;
	
	public SpelerMapper() {
		// tijdelijk de methode laadSpelers aangeroepen om DB te simuleren 
		laadSpelers();
	} 
	
	// tijdelijke een lijst aangemaakt met spelers tot de databank link aanwezig is.
	public void laadSpelers(){
		List<Speler> spelers = new ArrayList<Speler>();
		spelers.add(new Speler("Joost", "test"));
		spelers.add(new Speler("Bart", "Hogent"));
		spelers.add(new Speler("Lynn", "Ugent"));
		spelers.add(new Speler("Svetlana", "weg"));
		this.spelers = spelers;
	}
	
	public Speler geefSpeler(String gebruikersnaam, String wachtwoord) {
		for(Speler s:spelers) {
			if(s.getGebruikersnaam().equals(gebruikersnaam) && s.getWachtwoord().equals(wachtwoord)) return s;
		}
		return null;
	}

}