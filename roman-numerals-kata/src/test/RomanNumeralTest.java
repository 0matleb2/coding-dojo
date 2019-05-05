package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.RomanNumeral;

class RomanNumeralTest {
	
	RomanNumeral romanNumeral;

	@Test
	void givenRomanNumeral_I_whenConvertToInt_thenReturn1() {
		romanNumeral = new RomanNumeral("I");
		
		int result = romanNumeral.toInt();
		
		assertEquals(1, result);
	}
	
	@Test
	void givenRomanNumeral_V_whenConvertToInt_thenReturn5() {
		romanNumeral = new RomanNumeral("V");
		
		int result = romanNumeral.toInt();
		
		assertEquals(5, result);
	}
	
	@Test
	void givenRomanNumeral_X_whenConvertToInt_thenReturn10() {
		romanNumeral = new RomanNumeral("X");
		
		int result = romanNumeral.toInt();
		
		assertEquals(10, result);
	}
	
	@Test
	void givenRomanNumeral_L_whenConvertToInt_thenReturn50() {
		romanNumeral = new RomanNumeral("L");
		
		int result = romanNumeral.toInt();
		
		assertEquals(50, result);
	}
	
	@Test
	void givenRomanNumeral_C_whenConvertToInt_thenReturn100() {
		romanNumeral = new RomanNumeral("C");
		
		int result = romanNumeral.toInt();
		
		assertEquals(100, result);
	}
	
	@Test
	void givenRomanNumeral_D_whenConvertToInt_thenReturn500() {
		romanNumeral = new RomanNumeral("D");
		
		int result = romanNumeral.toInt();
		
		assertEquals(500, result);
	}
	
	@Test
	void givenRomanNumeral_M_whenConvertToInt_thenReturn1000() {
		romanNumeral = new RomanNumeral("M");
		
		int result = romanNumeral.toInt();
		
		assertEquals(1000, result);
	}
	
	@Test
	void givenRomanNumeral_XX_whenConvertToInt_thenReturn20() {
		romanNumeral = new RomanNumeral("XX");
		
		int result = romanNumeral.toInt();
		
		assertEquals(20, result);
	}
	
	@Test
	void givenRomanNumeral_CCC_whenConvertToInt_thenReturn300() {
		romanNumeral = new RomanNumeral("CCC");
		
		int result = romanNumeral.toInt();
		
		assertEquals(300, result);
	}
	
	@Test
	void givenRomanNumeral_IV_whenConvertToInt_thenReturn4() {
		romanNumeral = new RomanNumeral("IV");
		
		int result = romanNumeral.toInt();
		
		assertEquals(4, result);
	}
	
	@Test
	void givenRomanNumeral_VI_whenConvertToInt_thenReturn6() {
		romanNumeral = new RomanNumeral("VI");
		
		int result = romanNumeral.toInt();
		
		assertEquals(6, result);
	}
	
	@Test
	void givenRomanNumeral_XCIX_whenConvertToInt_thenReturn99() {
		romanNumeral = new RomanNumeral("XCIX");
		
		int result = romanNumeral.toInt();
		
		assertEquals(99, result);
	}
	
	@Test
	void givenRomanNumeral_MMMDCCCLXXXVIII_whenConvertToInt_thenReturn3888() {
		romanNumeral = new RomanNumeral("MMMDCCCLXXXVIII");
		
		int result = romanNumeral.toInt();
		
		assertEquals(3888, result);
	}
	
	@Test
	void givenRomanNumeral_MDCCCCLXXXXVIIII_whenConvertToInt_thenReturn1999() {
		romanNumeral = new RomanNumeral("MDCCCCLXXXXVIIII");
		
		int result = romanNumeral.toInt();
		
		assertEquals(1999, result);
	}
	
	@Test
	void givenRomanNumeral_MIM_whenConvertToInt_thenReturn1999() {
		romanNumeral = new RomanNumeral("MIM");
		
		int result = romanNumeral.toInt();
		
		assertEquals(1999, result);
	}
	
	@Test
	void givenRomanNumeral_XVI_WhenConvertToString_ThenReturnXVI() {
		romanNumeral = new RomanNumeral("XVI");
		
		String result = romanNumeral.toString();
		
		assertEquals("XVI", result);		
	}
}
