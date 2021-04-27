package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rij extends Reeks{
	public Rij(int rijnummer, boolean isGewijzigd, List<Steen> stenen) {
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
	
	public void legSteenAan(Steen steen, int positieInReeks) {
		super.legSteenAan(steen, positieInReeks);
	}
	
	private  void valideerLegSteenAan(int positieInReeks) throws Exception {
		//in een rij doet het er niet toe waar de steen aangelegd wordt, belangrijk is andere kleur en max 4
		//dus bepalen of de rij geldig is
		if(!this.bepaalIsGeldig()) {
			throw new Exception();
		}
	}
	
	private  void valideerVervangJoker(int positieInReeks) {
		
	}
	
	private  void valideerSteenNaarWerkveld(int positieInReeks) {
	
	}

}
