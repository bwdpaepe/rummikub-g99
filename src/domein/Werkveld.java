package domein;

import java.util.ArrayList;
import java.util.List;

public class Werkveld {
	// Werkveld bestaat uit lijst van stenen
	private List<Steen> stenenWerkveld;  // Definieren wat uw werkveld is
	
	//Constructor 
	public Werkveld() {
		this.stenenWerkveld = new ArrayList<Steen>(); // Bij aanroepen werkveld zal hij een lege lijst projecteren
	}
	
	public List<Steen> getStenenWerkveld() { // is in UML getStenen
		return stenenWerkveld;
	}

	public void setStenenWerkveld(List<Steen> stenenWerkveld) { // Mag weg want je moet enkel stenen kunnen toevoegen
		this.stenenWerkveld = stenenWerkveld;
	}
	
	
	public void voegSteenToeWerkveld(Steen steen) {
		this.stenenWerkveld.add(steen);
	}
	
	public void maakLeeg() { // ipv maakDuplicaat want is altijd leeg op eind/begin spelerAanZet
		this.stenenWerkveld.clear();
	}
	
}