package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.RomanNumeral;

class RomanNumeralTest {
	
	RomanNumeral romanNumeral;

	@BeforeEach
	void setUp() {
		romanNumeral = new RomanNumeral();
	}

	@Test
	void givenI_whenGetInt_thenReturn1() {
		romanNumeral.setNumeral("I");
		
		int result = romanNumeral.getInt();
		
		assertEquals(1, result);
	}
	
	@Test
	void givenV_whenGetInt_thenReturn5() {
		romanNumeral.setNumeral("V");
		
		int result = romanNumeral.getInt();
		
		assertEquals(5, result);
	}
	
	@Test
	void givenX_whenGetInt_thenReturn10() {
		romanNumeral.setNumeral("X");
		
		int result = romanNumeral.getInt();
		
		assertEquals(10, result);
	}
	
	@Test
	void givenL_whenGetInt_thenReturn50() {
		romanNumeral.setNumeral("L");
		
		int result = romanNumeral.getInt();
		
		assertEquals(50, result);
	}
	
	@Test
	void givenC_whenGetInt_thenReturn100() {
		romanNumeral.setNumeral("C");
		
		int result = romanNumeral.getInt();
		
		assertEquals(100, result);
	}
	
	@Test
	void givenD_whenGetInt_thenReturn500() {
		romanNumeral.setNumeral("D");
		
		int result = romanNumeral.getInt();
		
		assertEquals(500, result);
	}
	
	@Test
	void givenM_whenGetInt_thenReturn1000() {
		romanNumeral.setNumeral("M");
		
		int result = romanNumeral.getInt();
		
		assertEquals(1000, result);
	}

}
