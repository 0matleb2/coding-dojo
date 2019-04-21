package main;

public enum Books implements Comparable<Books> {
	I, II, III, IV, V;
	
	public static int size() {
		return Books.values().length;
	}
}
