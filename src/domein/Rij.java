package domein;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Rij extends Reeks{
	public Rij(int rijnummer, boolean isGewijzigd, ArrayList<Steen> stenen) {
		super(rijnummer, isGewijzigd, stenen);
	}
	
	protected boolean bepaalIsGeldig() {
		// minimaal 3 stenen voor zowel Rij als Serie
		boolean isGeldig = super.bepaalIsGeldig();
		
		// maximaal 4 stenen
		if(isGeldig && super.getStenen().size() > 4) {
			isGeldig = false;
		}
		
		// zelfde cijferwaarde
		if(isGeldig) {
			if(super.getStenen().stream()
			                 .map(x->x.getWaarde())
			                 .collect(Collectors.toSet())
			                 .size() > 1) {
				isGeldig = false;
			}
		}
		
		// verschillende kleur
				if(isGeldig) {
					if(super.getStenen().stream()
					                 .map(x->x.getKleur())
					                 .collect(Collectors.toSet())
					                 .size() != super.getStenen().size()) {
						isGeldig = false;
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
