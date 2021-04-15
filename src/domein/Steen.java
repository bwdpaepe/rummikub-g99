package domein;

//UC2
public class Steen {
	private int waarde;
	private Kleur kleur;
	
	//UC2
	/** Constructor van Steen: argumenten waarde, kleur en reeksnummer */
	public Steen(int waarde, Kleur kleur) {
		this.setWaarde(waarde);
		this.setKleur(kleur);
	}

	//UC2
	public int getWaarde() {
		return waarde;
	}

	//UC2
	private void setWaarde(int waarde) {
		this.waarde = waarde;
	}

	//UC2
	public Kleur getKleur() {
		return kleur;
	}

	//UC2
	private void setKleur(Kleur kleur) {
		this.kleur = kleur;
	}
	
}
