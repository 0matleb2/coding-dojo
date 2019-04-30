package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
	
	String numeral;

	public void setNumeral(String numeral) {
		this.numeral = numeral;
	}

	public int getInt() {
		int totalValue = 0;
		Optional<Character> lastLetter = Optional.empty();
		
		for (int i = numeral.length(); i-- > 0;) {
			char letter = numeral.charAt(i);
			totalValue += getLetterValue(letter, lastLetter);
			lastLetter = Optional.of(letter);			
		}
		
		return totalValue;
	}
	
	private int getLetterValue(char letter, Optional<Character> lastLetter) {
		
		int letterValue = LETTER_VALUES.get(letter);
		
		if ( !lastLetter.isPresent() || letterValue >= LETTER_VALUES.get(lastLetter.get()) ) {
			return letterValue;
		}
		
		return -letterValue;	
	}

}
