package domein;

import java.util.List;
import java.util.stream.Collectors;

//UC3
public class Rij extends Reeks{
	
	//UC3
	public Rij(int rijnummer, List<Steen> stenen, boolean isNieuw) {
		super(rijnummer, stenen, isNieuw);
	}
	
	//UC3
	public boolean bepaalIsGeldig() {
		// minimaal 3 stenen voor zowel Rij als Serie
		boolean isGeldig = super.bepaalIsGeldig();
		
		// maximaal 4 stenen
		if(isGeldig && super.getStenen().size() > 4) {
			isGeldig = false;
		}
		
		// zelfde cijferwaarde
		if(isGeldig) {
			isGeldig = this.bepaalZelfdeCijferwaardes();
		}
		
		// verschillende kleur
		if(isGeldig) {
			isGeldig = this.bepaalVerschillendeKleur();
		}
		return isGeldig;
	}
	
	//UC3
	
	//UC3
	private boolean bepaalZelfdeCijferwaardes() {
		if(super.getStenen().stream()
				.filter(x->x.getKleur() != Kleur.JOKER)	//jokers hebben een cijferwaarde 25 en kunnen we niet gebruiken in deze controle, jokers zijn sowieso goed en kunnen we dus uitsluiten voor verdere controle
                .map(x->x.getWaarde())
                .collect(Collectors.toSet())
                .size() > 1) {
					return false;
		}
		return true;
	}
	
	//UC3
	private boolean bepaalVerschillendeKleur() {
		int aantalKleuren = super.getStenen().stream()
				.filter(x->x.getKleur() != Kleur.JOKER)	//jokers hebben een kleur JOKER en kunnen we niet gebruiken in deze controle, jokers zijn sowieso goed en kunnen we dus uitsluiten voor verdere controle
                .map(x->x.getKleur())
                .collect(Collectors.toSet()) //unieke kleuren
                .size();
		int aantalJokers =super.getStenen().stream()
				.filter(x->x.getKleur() == Kleur.JOKER)
                .collect(Collectors.toList()) //aantal jokers
                .size();
		if(aantalKleuren + aantalJokers != super.getStenen().size()) {
			return false;
		}
		return true;
	}
	
	//UC3
	public void legSteenAan(Steen steen, int positieInReeks) {
		super.legSteenAan(steen, positieInReeks);
	}
	
	//UC3
	private boolean valideerRij() {
		// in een rij doet het er niet toe waar de steen aangelegd wordt, belangrijk is
		// zelfde cijferwaarde,
		// andere kleur,
		// max 4
		if(!this.bepaalZelfdeCijferwaardes() && !this.bepaalVerschillendeKleur() && super.getStenen().size() > 4) {
			return false;
		}
		return true;
	}
	
	//UC3
	public  void valideerLegSteenAan() throws Exception {
		if(!this.valideerRij()) {
			throw new Exception("Je kan de steen hier niet aanleggen, de rij is ongeldig.");
		}
	}
	
	//UC3
	public  void valideerVervangJoker() throws Exception {
		if(!this.valideerRij()) {
			throw new Exception("Je kan de joker hier niet vervangen, de rij is ongeldig.");
		}
	}
	
	//UC3
	public  void valideerSteenNaarWerkveld() throws Exception {
		if(!this.valideerRij()) {
			throw new Exception("Je kan deze steen niet naar het werkveld verplaatsen, de rij is ongeldig.");
		}
	}

}
