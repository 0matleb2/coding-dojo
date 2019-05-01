package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RomanNumeral {
	
	private static final Map<Character, Integer> LETTER_VALUES = initLetterValues();
	
	private static Map<Character, Integer> initLetterValues() {
		Map<Character, Integer> letterValues = new HashMap<>();
		letterValues.put('I', 1);
		letterValues.put('V', 5);
		letterValues.put('X', 10);
		letterValues.put('L', 50);
		letterValues.put('C', 100);
		letterValues.put('D', 500);
		letterValues.put('M', 1000);
		return Collections.unmodifiableMap(letterValues);
	}
	
	private String numeral;

	public void setNumeral(String numeral) {
		this.numeral = numeral;
	}

	public int getInt() {
		
		List<Character> letters = numeral.chars().mapToObj(i -> (char)i).collect(Collectors.toList());
		Collections.reverse(letters);
		
		return letters.stream().mapToInt((new LetterValueCalculator())::getLetterValue).sum();
	}
	
	private class LetterValueCalculator {
		
		private static final char DEFAULT_CHAR = '\u0000';
		
		private char lastLetter;
		
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
