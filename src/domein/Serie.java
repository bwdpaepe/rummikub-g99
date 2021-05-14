package domein;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

//UC3
public class Serie extends Reeks{
	
	//UC3
	public Serie(int rijnummer, List<Steen> stenen, boolean isNieuw) {
		super(rijnummer, stenen, isNieuw);
	}
	
	//UC3
	public boolean bepaalIsGeldig() {
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
		int aantalCijferwaardes = super.getStenen().stream()
				.filter(x->x.getKleur() != Kleur.JOKER)	//jokers hebben een cijferwaarde 25 en kunnen we niet gebruiken in deze controle, jokers zijn sowieso goed en kunnen we dus uitsluiten voor verdere controle
				.map(x->x.getWaarde())
                .collect(Collectors.toSet()) //unieke cijferwaardes
                .size();
		int aantalJokers =super.getStenen().stream()
				.filter(x->x.getKleur() == Kleur.JOKER)
                .collect(Collectors.toList()) //aantal jokers
                .size();
		if(aantalCijferwaardes + aantalJokers != super.getStenen().size()) {
			return false;
		}
		return true;
	}
	
	//UC3
	private boolean bepaalZelfdeKleur() {
		if(super.getStenen().stream()
				.filter(x->x.getKleur() != Kleur.JOKER)	//jokers hebben een kleur JOKER en kunnen we niet gebruiken in deze controle, jokers zijn sowieso goed en kunnen we dus uitsluiten voor verdere controle
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
		
		// is er een joker(s)? 
		// bepaal zijn positie(s)
		List<Kleur> steenKleurLijst = super.getStenen().stream()
				.map(x->x.getKleur())
				.collect(Collectors.toList());
		List<Integer> jokerPosities = new ArrayList<>();
		int positieJoker = 0;
		int offset = 0;
		do {
			positieJoker = this.zoekJoker(steenKleurLijst.subList(positieJoker, steenKleurLijst.size()));
			if(positieJoker != -1) {
				jokerPosities.add(positieJoker + offset);
				offset += positieJoker;
				positieJoker++;
			}
		}while(positieJoker != -1);
		
		if(jokerPosities.size() > 0) {	//joker(s)
			List<Integer> cijferwaardes = super.getStenen().stream()
	                .map(x->x.getWaarde())
	                .collect(Collectors.toList());
			
			Iterator<Integer> iterator = jokerPosities.iterator();
			int old_index = 0;
			while (isGeldig && iterator.hasNext()) {	
				int new_index = iterator.next();
				List<Integer> subCijferwaardes = cijferwaardes.subList(old_index, new_index);
				isGeldig = this.checkAaneensluitendeCijferwaardes(subCijferwaardes);
				old_index = new_index + 1;
			}
			List<Integer> subCijferwaardes = cijferwaardes.subList(old_index, cijferwaardes.size());
			isGeldig = this.checkAaneensluitendeCijferwaardes(subCijferwaardes);
		}
		else {	//geen joker
		
			List<Integer> cijferwaardes = super.getStenen().stream()
                .map(x->x.getWaarde())
                .collect(Collectors.toList());
		
			isGeldig = this.checkAaneensluitendeCijferwaardes(cijferwaardes);
		}
		return isGeldig;
	}
	
	//UC3
	private int zoekJoker(List<Kleur> inputLijst) {
		return inputLijst.indexOf(Kleur.JOKER);
	}
	
	
	//UC3
	private boolean checkAaneensluitendeCijferwaardes(List<Integer> cijferwaardes) {
		boolean isGeldig = true;
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
