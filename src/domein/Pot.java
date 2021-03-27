package domein;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

//UC2
public class Pot {
	
	private final int AANTALJOKERS = 2;
	private final Kleur[] KLEUREN = {Kleur.ZWART,Kleur.ROOD,Kleur.BLAUW,Kleur.GEEL};
	private final int MAXIMUMNUMMERSTEEN = 13;
	private final int MINIMUMNUMMERSTEEN = 1;
	private final int AANTALREEKSEN = 2;
	
	private List<Steen> stenen;

	//UC2
	/** LinkedList bij voorkeur te gebruiken bij veel invoegen/verwijderen van elementen. */
	public Pot() {
		this.stenen = new LinkedList<>();
		/*for(Kleur steenKleur: this.KLEUREN) {
			for(int steenWaarde = this.MINIMUMNUMMERSTEEN; steenWaarde <= this.MAXIMUMNUMMERSTEEN; steenWaarde ++) {
				//IntStream
			}
		}*/
		
		/* we vullen onze pot met 4 kleuren
		                        x 13 waarden
		                        x 2 reeksen
		*/
		Arrays.stream(this.KLEUREN)
		      .forEach(steenKleur->IntStream.rangeClosed(this.MINIMUMNUMMERSTEEN, this.MAXIMUMNUMMERSTEEN)
		    		                        .forEach(steenWaarde->IntStream.rangeClosed(1,this.AANTALREEKSEN)
		    		                        		.forEach(steenReeksnummer->this.stenen.add(new Steen(steenWaarde, steenKleur, steenReeksnummer)))));
		
		/* tenslotte voegen we de 2 jokers toe aan onze pot
		 
		*/
		IntStream.rangeClosed(1, this.AANTALJOKERS)
		         .forEach(steenReeksnummer->this.stenen.add(new Steen(25,Kleur.JOKER,steenReeksnummer)));
		
		//ToDo: test of er 106 stenen in de pot zitten
		
		      
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
