package cui;

import domein.DomeinController;

public class Application {
	private DomeinController dc;

	public Application(DomeinController dc) {
		this.dc = dc;
		aanmelden();
	}

	public void start() {
		System.out.printf("startmethode");
	}
	
	private void aanmelden() {
		System.out.printf("We beginnen met aanmelden\n");
		//nog nadenken logica
		//vraag # spelers
		//dc.initialiseerSpel(aantal);
		//spelers toevoegen
		//toonspelerslijst
	}
}
