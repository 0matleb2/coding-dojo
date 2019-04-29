package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {
	
	private static final Map<String, Integer> LETTER_VALUES = initLetterValues();
	
	private static Map<String, Integer> initLetterValues() {
		Map<String, Integer> letterValues = new HashMap<>();
		letterValues.put("I", 1);
		letterValues.put("V", 5);
		return Collections.unmodifiableMap(letterValues);
	}
	
	String numeral;

	public void setNumeral(String numeral) {
		this.numeral = numeral;
	}

	public int getInt() {
		return LETTER_VALUES.get(numeral);
	}

}
