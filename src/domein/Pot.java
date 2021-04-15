package domein;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

//UC2
public class Pot {
	
	private final int AANTALJOKERS = 2;
	private final int MAXIMUMNUMMERSTEEN = 13;
	private final int MINIMUMNUMMERSTEEN = 1;
	private final int AANTALREEKSEN = 2;
	private final int WAARDEJOKER = 25;
	
	private List<Steen> stenen;

	//UC2
	/** LinkedList bij voorkeur te gebruiken bij veel invoegen/verwijderen van elementen. */
	public Pot() {
		     this.genereerStenen();
		     this.randomizePot();
	}
	
	//UC2
	private void genereerStenen() {
		this.stenen = new LinkedList<>();
		//klassieke implementatie
		/*for(Kleur steenKleur: this.KLEUREN) {
			for(int steenWaarde = this.MINIMUMNUMMERSTEEN; steenWaarde <= this.MAXIMUMNUMMERSTEEN; steenWaarde++) {
				for(int steenReeksnummer = 1; steenReeksnummer < this.AANTALREEKSEN; steenReeksnummer++) {
				
				}
			}
		}*/
		
		//streams implementatie
		/* we vullen onze pot met 4 kleuren
		                        x 13 waarden
		                        x 2 reeksen
		*/
		EnumSet.range(Kleur.ZWART,Kleur.GEEL)
		      .forEach(steenKleur->IntStream.rangeClosed(this.MINIMUMNUMMERSTEEN, this.MAXIMUMNUMMERSTEEN)
		    		                        .forEach(steenWaarde->IntStream.rangeClosed(1,this.AANTALREEKSEN)
		    		                        		.forEach(steenReeksnummer->this.stenen.add(new Steen(steenWaarde, steenKleur)))));
		
		/* tenslotte voegen we de 2 jokers toe aan onze pot
		   joker krijgt waarde 25
		*/
		IntStream.rangeClosed(1, this.AANTALJOKERS)
		         .forEach(steenReeksnummer->this.stenen.add(new Steen(this.WAARDEJOKER,Kleur.JOKER)));
		
	}
	
	
	//UC2
	/** We schudden de volgorde van de stenen willekeurig door elkaar. */
	public void randomizePot() {
		Collections.shuffle(this.stenen);
	}
	
	//UC2
	//We geven altijd de eerste steen uit de pot (performant voor LinkedList
	//We zullen de pot eerst moeten schudden alvorens de eerste steen te geven, zodat dit een willekeurig steen is
	/** Als het spel dat vriendelijk vraagt, dan geven we een steen uit de pot. Deze steen wordt dan ook verwijderd uit de pot. */
	public Steen geefSteen() {
		return this.stenen.remove(0);
	}
	
	
	
	
	
	
	

}