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
	void testSomVanStenen_speler_met_5_stenen_retourneert_som() {
		// Arrange
		this.testSpeler.voegSteenToe(new Steen(1, Kleur.ROOD, "src\\images\\R1.png"));
		this.testSpeler.voegSteenToe(new Steen(13, Kleur.ZWART, "src\\images\\G13.png"));
		this.testSpeler.voegSteenToe(new Steen(2, Kleur.ROOD, "src\\images\\R2.png"));
		this.testSpeler.voegSteenToe(new Steen(12, Kleur.GEEL, "src\\images\\O12.png"));
		this.testSpeler.voegSteenToe(new Steen(3, Kleur.BLAUW, "src\\images\\B3.png"));
		
		// Act
		int somVanStenen = this.testSpeler.somVanStenen();
		
		// Assert
		Assertions.assertEquals(31, somVanStenen);
	}
	
	//UC2
	@Test
	void testBerekenScore_speler_met_0_stenen_retourneert_nul() {
		// Arrange
		
		// Act
		int somVanStenen = this.testSpeler.somVanStenen();
		
		// Assert
		Assertions.assertEquals(0, somVanStenen);
	}

}
