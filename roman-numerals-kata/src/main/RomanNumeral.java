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
		letterValues.put("X", 10);
		letterValues.put("L", 50);
		letterValues.put("C", 100);
		letterValues.put("D", 500);
		letterValues.put("M", 1000);
		return Collections.unmodifiableMap(letterValues);
	}
	
	String numeral;

	public void setNumeral(String numeral) {
		this.numeral = numeral;
	}

	public int getInt() {
		int value = 0;
		for (String letter : numeral.split("")) {
			value += LETTER_VALUES.get(letter);
		}
		return value;
	}

}
