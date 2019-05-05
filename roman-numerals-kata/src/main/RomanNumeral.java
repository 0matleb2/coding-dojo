package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
	
	private final String numeral;
	private final int value;
	
	public RomanNumeral(String numeral) {
		validateNumeral(numeral);
		this.numeral = reduceNumeral(numeral);
		this.value = calculateValue(numeral);
	}
	
	private void validateNumeral(String numeral) throws IllegalArgumentException {
		boolean containsInvalidSubtractions = Pattern.matches("[DLXVI]M|[LXVI]D|[LVI]C|[VI]L|VX", numeral);
		
		if (containsInvalidSubtractions) {
			throw new IllegalArgumentException();
		}
	}
	
	private String reduceNumeral(String numeral) {
		Pattern fourOfAKind = Pattern.compile("([IXC])\\1{3}");
		Matcher matcher = fourOfAKind.matcher(numeral);
		StringBuffer reducedNumeral = new StringBuffer();
		while (matcher.find()) {
			String letter = matcher.group(1);
			String higherDenominationLetter = getHigherDenomination(letter);
			matcher.appendReplacement(reducedNumeral, letter + higherDenominationLetter);
		}
		matcher.appendTail(reducedNumeral);
		return reducedNumeral.toString();
	}
	
	private String getHigherDenomination(String letter) {
		List<String> letters = Arrays.asList("I", "V", "X", "L", "C", "D", "M");
		return letters.get(letters.indexOf(letter) + 1);
	}
	
	/**
	 * Converts the string representation of a roman numeral into the corresponding integer value.
	 * 
	 * @return The integer value of the roman numeral.
	 */
	private int calculateValue(String numeral) {
		List<Character> letters = numeral.chars().mapToObj(i -> (char)i).collect(Collectors.toList());
		Collections.reverse(letters);
		return letters.stream().mapToInt((new LetterValueCalculator())::calculateLetterValue).sum();
	}
	
	/**
	 * LetterValueCalculator encapsulates the state and logic for
	 * calculating the values of letters in a single RomanNumeral.
	 */
	private class LetterValueCalculator {
		
		private static final char DEFAULT_CHAR = '\u0000';
		
		private char lastLetter = DEFAULT_CHAR;
		
		/**
		 * Calculates the value of a letter in a roman numeral. This method expects the letters 
		 * to be passed in reverse sequential order as parsed from the roman numeral string.
		 * 
		 * @param letter The next letter in the roman numeral, parsed in reverse order.
		 * @return The value of the letter.
		 */
		public int calculateLetterValue(char letter) {
			
			int letterValue = LETTER_VALUES.get(letter);
			char tmpLastLetter = lastLetter;
			lastLetter = letter;
			
			if ( tmpLastLetter == DEFAULT_CHAR || letterValue >= LETTER_VALUES.get(tmpLastLetter) ) {
				return letterValue;
			}
			
			return -letterValue;
		}
	}
	
	public String toString() {
		return numeral;
	}

	public int toInt() {
		return value;
	}
	

}
