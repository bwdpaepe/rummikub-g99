package domein;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

//UC3
public class Serie extends Reeks{
	
	//UC3
	public Serie(int rijnummer, List<Steen> stenen) {
		super(rijnummer, stenen);
	}
	
	//UC3
	protected boolean bepaalIsGeldig() {
		// minimaal 3 stenen voor zowel Rij als Serie
		boolean isGeldig = super.bepaalIsGeldig();
		// maximaal 13 stenen
		if(isGeldig && super.getStenen().size() > 13) {
			isGeldig = false;
		}
				
		// verschillende cijferwaarde
		if(isGeldig) {
			isGeldig = this.bepaalVerschillendeCijferwaardes();
		}
		
		// zelfde kleur
		if(isGeldig) {
			isGeldig = this.bepaalZelfdeKleur();
		}
						
		// aaneensluitende cijferwaardes
		if(isGeldig) {
			isGeldig = this.bepaalAaneensluitendeCijferwaardes();			
		}
						
		return isGeldig;
	}
	
	//UC3
	private boolean bepaalVerschillendeCijferwaardes() {
		if(super.getStenen().stream()
                .map(x->x.getWaarde())
                .collect(Collectors.toSet())
                .size() != super.getStenen().size()) {
					return false;
		}
		return true;
	}
	
	//UC3
	private boolean bepaalZelfdeKleur() {
		if(super.getStenen().stream()
                .map(x->x.getKleur())
                .collect(Collectors.toSet())
                .size() > 1) {
					return false;
		}
		return true;
	}
	
	//UC3
	private boolean bepaalAaneensluitendeCijferwaardes() {
		boolean isGeldig = true;
		List<Integer> cijferwaardes = super.getStenen().stream()
                .map(x->x.getWaarde())
                .sorted()
                .collect(Collectors.toList());
		
		ListIterator<Integer> iterator = cijferwaardes.listIterator();
		int referentiewaarde = iterator.next();
		int nieuweWaarde;
		
		while (isGeldig && iterator.nextIndex() < cijferwaardes.size()) {
			nieuweWaarde = iterator.next();
			if(referentiewaarde != nieuweWaarde - 1) {
				isGeldig = false;
			}
			else {
				referentiewaarde = nieuweWaarde;
			}
		}
		return isGeldig;
	}
	
	
	//UC3
	private boolean valideerSerie() {
		/*if(positieInReeks == 0) {//eerste positie
		
		}
		else if(positieInReeks == this.getStenen().size()-1) {//laatste positie
			
		}
		else {//ergens tussenin
			
		}*/
		// in een serie doet het er WEL toe waar de steen aangelegd wordt, belangrijk is
		// verschillende cijferwaardes,
		// zelfde kleur,
		// aaneensluitende cijferwaardes,
		// max 13
		if(!this.bepaalVerschillendeCijferwaardes() && !this.bepaalZelfdeKleur() && !this.bepaalAaneensluitendeCijferwaardes() && super.getStenen().size() > 13) {
			return false;
		}
		return true;
	}
	
	//UC3
	public  void valideerLegSteenAan() throws Exception {
		if(!this.valideerSerie()) {
			throw new Exception("Je kan de steen hier niet aanleggen, de serie is ongeldig.");
		}
	}
	
	//UC3
	public  void valideerVervangJoker() throws Exception {
		if(!this.valideerSerie()) {
			throw new Exception("Je kan de joker hier niet vervangen, de serie is ongeldig.");
		}
	}
	
	//UC3
	public  void valideerSteenNaarWerkveld() throws Exception {
		if(!this.valideerSerie()) {
			throw new Exception("Je kan deze steen niet naar het werkveld verplaatsen, de serie is ongeldig.");
		}
	}

}
