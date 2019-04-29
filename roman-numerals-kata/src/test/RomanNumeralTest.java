package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RomanNumeralTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void givenI_whenGetInt_thenReturn1() {
		romanNumeral.setNumeral("I");
		
		int result = romanNumeral.getInt();
		
		assertEquals(1, result);
	}

}
