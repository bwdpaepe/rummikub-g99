package testen;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domein.Pot;
import domein.Steen;

class PotTest {

	@Test
	void maakPot_bevat_106_stenen_retourneert_true() {
		// Arrange
		Pot testPot = new Pot();
		List<Steen> testLijst = new ArrayList<>();
		
		// Act
		try {
			while(true) {
				testLijst.add(testPot.geefSteen());
			}
		}
		catch(IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		finally{
			// Assert
			Assertions.assertTrue(testLijst.size() == 106);
		}
		
	}

}
