package testen;

import static org.junit.jupiter.api.Assertions.fail;

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
		
		fail("Er is geen publieke methode meer in klasse Spel om scores te testen");
		
//		// Arrange
//		Speler testSpeler1 = new Speler("Bart", "wachtwoordbart");
//		testSpeler1.voegSteenToe(new Steen(11, Kleur.BLAUW));
//		testSpeler1.voegSteenToe(new Steen(4, Kleur.ZWART));
//		this.testSpel.voegSpelerToe(testSpeler1);
//				
//		Speler testSpeler2 = new Speler("Joost", "wachtwoordjoost");
//		this.testSpel.voegSpelerToe(testSpeler2);
//				
//		Speler testSpeler3 = new Speler("Lynn", "wachtwoordlynn");
//		testSpeler3.voegSteenToe(new Steen(1, Kleur.ROOD));
//		testSpeler3.voegSteenToe(new Steen(13, Kleur.ZWART));
//		testSpeler3.voegSteenToe(new Steen(2, Kleur.ROOD));
//		testSpeler3.voegSteenToe(new Steen(12, Kleur.GEEL));
//		testSpeler3.voegSteenToe(new Steen(3, Kleur.BLAUW));
//		this.testSpel.voegSpelerToe(testSpeler3);	
//		
//		// Act
		// Er is geen publieke methode meer in klasse Spel om scores te testen
//		this.testSpel.berekenScores();
//		
//		// Assert
//		Assertions.assertEquals(46, testSpeler2.getScore());
//		Assertions.assertEquals(-15, testSpeler1.getScore());
//		Assertions.assertEquals(-31, testSpeler3.getScore());
	}

}
