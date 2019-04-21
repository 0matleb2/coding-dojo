package test;
import static main.Books.I;
import static main.Books.II;
import static main.Books.III;
import static main.Books.IV;
import static main.Books.V;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.BookDiscountCalculator;
import main.Books;

class BookDiscountCalculatorTest {
	
	public static final double EPSILON = 0.0001;
	
	BookDiscountCalculator calculator;

	@BeforeEach
	void setUp() throws Exception {
		calculator = new BookDiscountCalculator();
	}

	@Test
	void given0Books_whenCalculateCost_returnZero() {
		
		List<Books> books = Arrays.asList();
		
		calculator.setBooks(books);
		
		double result = calculator.calculateTotalCost();
		
		assertEquals(0, result, EPSILON);
	}
	
	@Test
	void given1Book_whenCalculateCost_returnBookCost() {
		
		List<Books> books = Arrays.asList(I);
		
		calculator.setBooks(books);
		
		double result = calculator.calculateTotalCost();
		
		assertEquals(BookDiscountCalculator.BOOK_COST, result, EPSILON);
	}
	
	@Test
	void given2UniqueBooks_whenCalculateCost_returnCostWithDiscount() {
		
		List<Books> books = Arrays.asList(I, II);
		
		calculator.setBooks(books);

		double expected = getSetCost(2);
		double actual = calculator.calculateTotalCost();
		
		assertEquals(expected, actual, EPSILON);
	}
	
	@Test
	void given3UniqueBooks_whenCalculateCost_returnCostWithDiscount() {
		
		List<Books> books = Arrays.asList(I, II, III);
		
		calculator.setBooks(books);

		double expected = getSetCost(3);
		double actual = calculator.calculateTotalCost();
		
		assertEquals(expected, actual, EPSILON);
	}
	
	@Test
	void given3UniqueBooksAnd1Duplicate_whenCalculateCost_returnCostWithDiscountForFirstSetAndNoDiscountForDuplicate() {
		
		List<Books> books = Arrays.asList(I, II, III, III);
		
		calculator.setBooks(books);

		double expected = getSetCost(3) + getSetCost(1);
		double actual = calculator.calculateTotalCost();
		
		assertEquals(expected, actual, EPSILON);
	}
	
	@Test
	void given12Books_whenCalculateCost_returnCostWithOptimalDiscount() {
			
			List<Books> books = Arrays.asList(
					I, II, III, IV,
					I, II, III, V,
					I, II, III, IV
					);
			
			calculator.setBooks(books);

			double expected = getSetCost(4) * 3;
			double actual = calculator.calculateTotalCost();
			
			assertEquals(expected, actual, EPSILON);
	}
	
	@Test
	void given13Books_whenCalculateCost_returnCostWithApproximateOptimalDiscount() {
			
			List<Books> books = Arrays.asList(
					I, II, III, IV,
					I, II, III, V,
					I, II, III, IV, V
					);
			
			calculator.setBooks(books);

			double expected = getSetCost(4) * 2
					+ getSetCost(5);
			double actual = calculator.calculateTotalCost();
			
			assertEquals(expected, actual, EPSILON);
	}
	
	@Test
	void givenManyBooks_andBooksAreMostlyDuplicates_whenCalculateCost_returnCostWithApproximateOptimalDiscount() {
			
			List<Books> books = Arrays.asList(
					I, I, I, I,
					I, I, I, I,
					I, I, I, I,
					II, II, II, II,
					II, II, II, II,
					III, III, III, III,
					III, III, IV, IV,
					IV, IV, V, V
					);
			
			calculator.setBooks(books);

			double expected = getSetCost(5) * 2 
					+ getSetCost(4) * 2
					+ getSetCost(3) * 2
					+ getSetCost(2) * 2
					+ getSetCost(1) * 4;
			double actual = calculator.calculateTotalCost();
			
			assertEquals(expected, actual, EPSILON);
	}
	
	double getSetCost(int setSize) {
		return BookDiscountCalculator.BOOK_COST * setSize * BookDiscountCalculator.DISCOUNTS[setSize];
	}

}
