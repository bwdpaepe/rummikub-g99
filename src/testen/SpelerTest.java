package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Kleur;
import domein.Speler;
import domein.Steen;

//UC2
class SpelerTest {
	
	private Speler testSpeler;
	
	//UC2
	@BeforeEach
	public void beforeEach() {
		this.testSpeler = new Speler("Bart", "wachtwoordbart");
	}

	//UC2
	@Test
	void testBerekenScore_speler_met_5_stenen_retourneert_strafpunten() {
		// Arrange
		this.testSpeler.voegSteenToe(new Steen(1, Kleur.ROOD, 2));
		this.testSpeler.voegSteenToe(new Steen(13, Kleur.ZWART, 1));
		this.testSpeler.voegSteenToe(new Steen(2, Kleur.ROOD, 1));
		this.testSpeler.voegSteenToe(new Steen(12, Kleur.GEEL, 1));
		this.testSpeler.voegSteenToe(new Steen(3, Kleur.BLAUW, 2));
		
		// Act
		this.testSpeler.berekenScore(0);
		
		// Assert
		Assertions.assertEquals(-31, this.testSpeler.getScore());
	}
	
	//UC2
	@Test
	void testBerekenScore_speler_met_0_stenen_retourneert_winpunten() {
		// Arrange
		
		// Act
		this.testSpeler.berekenScore(31);
		
		// Assert
		Assertions.assertEquals(31, this.testSpeler.getScore());
	}

}
