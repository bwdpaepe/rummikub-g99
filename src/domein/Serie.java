package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Serie extends Reeks{
	public Serie(int rijnummer, boolean isGewijzigd, ArrayList<Steen> stenen) {
		super(rijnummer, isGewijzigd, stenen);
	}
	
	protected boolean bepaalIsGeldig() {
		// minimaal 3 stenen voor zowel Rij als Serie
		boolean isGeldig = super.bepaalIsGeldig();
		// maximaal 13 stenen
				if(isGeldig && super.getStenen().size() > 13) {
					isGeldig = false;
				}
				
				// verschillende cijferwaarde
				if(isGeldig) {
					if(super.getStenen().stream()
					                 .map(x->x.getWaarde())
					                 .collect(Collectors.toSet())
					                 .size() != super.getStenen().size()) {
						isGeldig = false;
					}
				}
				
				// zelfde kleur
						if(isGeldig) {
							if(super.getStenen().stream()
							                 .map(x->x.getKleur())
							                 .collect(Collectors.toSet())
							                 .size() > 1) {
								isGeldig = false;
							}
						}
						
				// aaneensluitende cijferwaardes
						if(isGeldig) {
							List<Integer> cijferwaardes = super.getStenen().stream()
					                 .map(x->x.getWaarde())
					                 .sorted()
					                 .collect(Collectors.toList());
							
							ListIterator<Integer> iterator = cijferwaardes.listIterator();
							
							while (isGeldig && iterator.nextIndex() < cijferwaardes.size()-1) {
								if(iterator.next() != cijferwaardes.get(iterator.nextIndex()) - 1) {
									isGeldig = false;
								}
							}
							
							
						}
						
		return isGeldig;
	}
	
	private  void valideerLegSteenAan(int positieInReeks) {
		
	}
	
	private  void valideerVervangJoker(int positieInReeks) {
		
	}
	
	private  void valideerSteenNaarWerkveld(int positieInReeks) {
	
	}

}
