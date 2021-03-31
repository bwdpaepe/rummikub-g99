package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Kleur;
import domein.Spel;
import domein.Speler;
import domein.Steen;
import exceptions.AlleSpelersReedsAangemeldException;
import exceptions.SpelerReedsAangemeldException;

//UC2
class SpelTest {
	
	private Spel testSpel;
	
	//UC2
	@BeforeEach
	public void beforeEach() {
		this.testSpel = new Spel(3);
	}

	//UC2
	@Test
	void testBerekenScores_3_spelers_retourneert_juiste_scores() {
		// Arrange
		Speler testSpeler1 = new Speler("Bart", "wachtwoordbart");
		testSpeler1.voegSteenToe(new Steen(11, Kleur.BLAUW, 1));
		testSpeler1.voegSteenToe(new Steen(4, Kleur.ZWART, 2));
		try {
			this.testSpel.voegSpelerToe(testSpeler1);
		} catch (SpelerReedsAangemeldException | AlleSpelersReedsAangemeldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Speler testSpeler2 = new Speler("Joost", "wachtwoordjoost");
		try {
			this.testSpel.voegSpelerToe(testSpeler2);
		} catch (SpelerReedsAangemeldException | AlleSpelersReedsAangemeldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Speler testSpeler3 = new Speler("Lynn", "wachtwoordlynn");
		testSpeler3.voegSteenToe(new Steen(1, Kleur.ROOD, 2));
		testSpeler3.voegSteenToe(new Steen(13, Kleur.ZWART, 1));
		testSpeler3.voegSteenToe(new Steen(2, Kleur.ROOD, 1));
		testSpeler3.voegSteenToe(new Steen(12, Kleur.GEEL, 1));
		testSpeler3.voegSteenToe(new Steen(3, Kleur.BLAUW, 2));
		try {
			this.testSpel.voegSpelerToe(testSpeler3);
		} catch (SpelerReedsAangemeldException | AlleSpelersReedsAangemeldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Act
		this.testSpel.berekenScores();
		
		
		// Assert
		Assertions.assertEquals(46, testSpeler2.getScore());
		Assertions.assertEquals(-15, testSpeler1.getScore());
		Assertions.assertEquals(-31, testSpeler3.getScore());
	}

}
