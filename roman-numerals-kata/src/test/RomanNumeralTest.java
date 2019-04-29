package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.RomanNumeral;

class RomanNumeralTest {
	
	RomanNumeral romanNumeral;

	@BeforeEach
	void setUp() throws Exception {
		romanNumeral = new RomanNumeral();
	}

	@Test
	void givenI_whenGetInt_thenReturn1() {
		romanNumeral.setNumeral("I");
		
		int result = romanNumeral.getInt();
		
		assertEquals(1, result);
	}

}
