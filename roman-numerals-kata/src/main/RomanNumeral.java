package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * RomanNumeral is an entity that enscapsulates a roman numeral and 
 * provides an interface to convert it to decimal numbers.
 * 
 * @author Mathieu Leblanc <0mat.leb2@gmail.com>
 * 
 */
public class RomanNumeral {
	
	private static final Map<Character, Integer> LETTER_VALUES;
	
	static {
		Map<Character, Integer> letterValues = new HashMap<>();
		letterValues.put('I', 1);
		letterValues.put('V', 5);
		letterValues.put('X', 10);
		letterValues.put('L', 50);
		letterValues.put('C', 100);
		letterValues.put('D', 500);
		letterValues.put('M', 1000);
		LETTER_VALUES = Collections.unmodifiableMap(letterValues);
	}
	
	private String numeral;
	
	public RomanNumeral() {
		
	}
	
	public RomanNumeral(String numeral) {
		this.numeral = numeral;
	}
	
	public void setNumeral(String numeral) {
		this.numeral = numeral;
	}
	
	/**
	 * Converts the roman numeral into the corresponding integer value.
	 * 
	 * @return The integer value of the roman numeral.
	 */
	public int getInt() {
		
		List<Character> letters = numeral.chars().mapToObj(i -> (char)i).collect(Collectors.toList());
		Collections.reverse(letters);
		
		return letters.stream().mapToInt((new LetterValueCalculator())::getLetterValue).sum();
	}
	
	/**
	 * LetterValueCalculator encapsulates the state and logic required for
	 * calculating the values of letters in a single RomanNumeral.
	 *
	 */
	private class LetterValueCalculator {
		
		private static final char DEFAULT_CHAR = '\u0000';
		
		private char lastLetter;
		
		/**
		 * Calculates the value of a letter in a roman numeral. This method expects the letters 
		 * to be passed in reverse sequential order as parsed from the roman numeral string.
		 * 
		 * @param letter The next letter in the roman numeral, parsed in reverse order.
		 * @return The value of the letter.
		 */
		public int getLetterValue(char letter) {
			
			int letterValue = LETTER_VALUES.get(letter);
			char tmpLastLetter = lastLetter;
			lastLetter = letter;
			
			if ( tmpLastLetter == DEFAULT_CHAR || letterValue >= LETTER_VALUES.get(tmpLastLetter) ) {
				return letterValue;
			}
			
			return -letterValue;
		}
	}

}
