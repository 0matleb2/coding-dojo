package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	void givenExpandedRomanNumeral_MDCCCCLXXXXVIIII_whenConvertToInt_thenReturn1999() {
		romanNumeral = new RomanNumeral("MDCCCCLXXXXVIIII");
		
		int result = romanNumeral.toInt();
		
		assertEquals(1999, result);
	}
	
	@Test
	void givenExpandedRomanNumeral_MDCCCCLXXXXVIIII_whenConvertToString_thenReturnReduction_MDCDLXLVIV() {
		romanNumeral = new RomanNumeral("MDCCCCLXXXXVIIII");
		
		String result = romanNumeral.toString();
		
		assertEquals("MDCDLXLVIV", result);
	}
	
	@Test
	void givenInvalidRomanNumeral_DM_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("DM"));
	}
	
	@Test
	void givenInvalidRomanNumeral_LM_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("LM"));
	}
	
	@Test
	void givenInvalidRomanNumeral_XM_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("XM"));
	}
	
	@Test
	void givenInvalidRomanNumeral_VM_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("VM"));
	}
	
	@Test
	void givenInvalidRomanNumeral_IM_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("IM"));
	}
	
	@Test
	void givenInvalidRomanNumeral_LD_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("LD"));
	}
	
	@Test
	void givenInvalidRomanNumeral_XD_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("XD"));
	}
	
	@Test
	void givenInvalidRomanNumeral_VD_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("VD"));
	}
	
	@Test
	void givenInvalidRomanNumeral_ID_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("ID"));
	}
	
	@Test
	void givenInvalidRomanNumeral_LC_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("LC"));
	}
	
	@Test
	void givenInvalidRomanNumeral_VC_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("VC"));
	}
	
	@Test
	void givenInvalidRomanNumeral_IC_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("IC"));
	}
	
	@Test
	void givenInvalidRomanNumeral_VL_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("VL"));
	}
	
	@Test
	void givenInvalidRomanNumeral_IL_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("IL"));
	}
	
	@Test
	void givenInvalidRomanNumeral_VX_thenThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> romanNumeral = new RomanNumeral("VX"));
	}
	
	@Test
	void givenRomanNumeral_XVI_WhenConvertToString_ThenReturnXVI() {
		romanNumeral = new RomanNumeral("XVI");
		
		String result = romanNumeral.toString();
		
		assertEquals("XVI", result);		
	}
}
