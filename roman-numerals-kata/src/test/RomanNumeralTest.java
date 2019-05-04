package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.RomanNumeral;

class RomanNumeralTest {
	
	RomanNumeral romanNumeral;
	
	static final String input = "XVI";

	@Test
	void givenI_whenGetInt_thenReturn1() {
		romanNumeral = new RomanNumeral("I");
		
		int result = romanNumeral.getInt();
		
		assertEquals(1, result);
	}
	
	@Test
	void givenV_whenGetInt_thenReturn5() {
		romanNumeral = new RomanNumeral("V");
		
		int result = romanNumeral.getInt();
		
		assertEquals(5, result);
	}
	
	@Test
	void givenX_whenGetInt_thenReturn10() {
		romanNumeral = new RomanNumeral("X");
		
		int result = romanNumeral.getInt();
		
		assertEquals(10, result);
	}
	
	@Test
	void givenL_whenGetInt_thenReturn50() {
		romanNumeral = new RomanNumeral("L");
		
		int result = romanNumeral.getInt();
		
		assertEquals(50, result);
	}
	
	@Test
	void givenC_whenGetInt_thenReturn100() {
		romanNumeral = new RomanNumeral("C");
		
		int result = romanNumeral.getInt();
		
		assertEquals(100, result);
	}
	
	@Test
	void givenD_whenGetInt_thenReturn500() {
		romanNumeral = new RomanNumeral("D");
		
		int result = romanNumeral.getInt();
		
		assertEquals(500, result);
	}
	
	@Test
	void givenM_whenGetInt_thenReturn1000() {
		romanNumeral = new RomanNumeral("M");
		
		int result = romanNumeral.getInt();
		
		assertEquals(1000, result);
	}
	
	@Test
	void givenXX_whenGetInt_thenReturn20() {
		romanNumeral = new RomanNumeral("XX");
		
		int result = romanNumeral.getInt();
		
		assertEquals(20, result);
	}
	
	@Test
	void givenCCC_whenGetInt_thenReturn300() {
		romanNumeral = new RomanNumeral("CCC");
		
		int result = romanNumeral.getInt();
		
		assertEquals(300, result);
	}
	
	@Test
	void givenIV_whenGetInt_thenReturn4() {
		romanNumeral = new RomanNumeral("IV");
		
		int result = romanNumeral.getInt();
		
		assertEquals(4, result);
	}
	
	@Test
	void givenVI_whenGetInt_thenReturn6() {
		romanNumeral = new RomanNumeral("VI");
		
		int result = romanNumeral.getInt();
		
		assertEquals(6, result);
	}
	
	@Test
	void givenXCIX_whenGetInt_thenReturn99() {
		romanNumeral = new RomanNumeral("XCIX");
		
		int result = romanNumeral.getInt();
		
		assertEquals(99, result);
	}
	
	@Test
	void givenMMMDCCCLXXXVIII_whenGetInt_thenReturn3888() {
		romanNumeral = new RomanNumeral("MMMDCCCLXXXVIII");
		
		int result = romanNumeral.getInt();
		
		assertEquals(3888, result);
	}
	
	@Test
	void givenMDCCCCLXXXXVIIII_whenGetInt_thenReturn1999() {
		romanNumeral = new RomanNumeral("MDCCCCLXXXXVIIII");
		
		int result = romanNumeral.getInt();
		
		assertEquals(1999, result);
	}
	
	@Test
	void givenMIM_whenGetInt_thenReturn1999() {
		romanNumeral = new RomanNumeral("MIM");
		
		int result = romanNumeral.getInt();
		
		assertEquals(1999, result);
	}
	
	@Test
	void givenANumeralIsConstructed_whenGetNumeral_ThenReturnTheNumeral() {
		romanNumeral = new RomanNumeral(input);
		
		String result = romanNumeral.getNumeral();
		
		assertEquals(input, result);		
	}
}
