package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Speler;
	
public class SpelerMapper {
	
	private List<Speler> spelers;
	
	public SpelerMapper() {
		// tijdelijk de methode laadSpelers gemaakt en aangeroepen om DB te simuleren 
		laadSpelers();
	} 
	
	// tijdelijke een lijst aangemaakt met spelers tot de databank link aanwezig is.
	public void laadSpelers(){
		System.out.printf("initialiseer tijdelijk een databank in de mapper te verwijderen ooit\n");
		List<Speler> spelerstemp = new ArrayList<Speler>();
		spelerstemp.add(new Speler("Joost", "test"));
		spelerstemp.add(new Speler("Bart", "Hogent"));
		spelerstemp.add(new Speler("Lynn", "Ugent"));
		spelerstemp.add(new Speler("Svetlana", "weg"));
		this.spelers = spelerstemp;
	}
	
	public Speler geefSpeler(String gebruikersnaam, String wachtwoord) {
		for(Speler s:spelers) {
			// te wissen enkel voor demo
			//System.out.printf("test %s afgelopen via spelersmapper voor %s \n",s.getGebruikersnaam(), gebruikersnaam);
			if(s.getGebruikersnaam().equals(gebruikersnaam) && s.getWachtwoord().equals(wachtwoord)) return s;
		}
		return null;
	}

}