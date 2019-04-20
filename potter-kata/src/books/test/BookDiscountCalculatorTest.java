package books.test;
import static books.Books.I;
import static books.Books.II;
import static books.Books.III;
import static books.Books.IV;
import static books.Books.V;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import books.BookDiscountCalculator;
import books.Books;

class BookDiscountCalculatorTest {
	
	public static final double EPSILON = 0.0001;
	
	BookDiscountCalculator calculator;

	@BeforeEach
	void setUp() throws Exception {
		calculator = new BookDiscountCalculator();
	}

	@Test
	void givenNoBooks_whenCalculateCost_returnZero() {
		
		List<Books> books = new ArrayList<>();
		
		calculator.setBooks(books);
		
		double result = calculator.calculateTotalCost();
		
		assertEquals(0, result, EPSILON);
	}
	
	@Test
	void givenTwoUniqueBooks_whenCalculateCost_returnCostWithDiscount() {
		
		List<Books> books = Arrays.asList(I, II);
		
		calculator.setBooks(books);

		double expected = BookDiscountCalculator.BOOK_COST * books.size() * BookDiscountCalculator.DISCOUNTS[books.size()];
		double actual = calculator.calculateTotalCost();
		
		assertEquals(expected, actual, EPSILON);
	}
	
	@Test
	void givenThreeUniqueBooks_whenCalculateCost_returnCostWithDiscount() {
		
		List<Books> books = Arrays.asList(I, II, III);
		
		calculator.setBooks(books);

		double expected = BookDiscountCalculator.BOOK_COST * books.size() * BookDiscountCalculator.DISCOUNTS[books.size()];
		double actual = calculator.calculateTotalCost();
		
		assertEquals(expected, actual, EPSILON);
	}
	
	@Test
	void givenThreeUniqueBooksAndOneDuplicate_whenCalculateCost_returnCostWithDiscountForFirstSetAndNoDiscountForDuplicate() {
		
		List<Books> books = Arrays.asList(I, II, III, III);
		
		calculator.setBooks(books);

		double expected = BookDiscountCalculator.BOOK_COST * 3 * BookDiscountCalculator.DISCOUNTS[3]
				+ BookDiscountCalculator.BOOK_COST * 1 * BookDiscountCalculator.DISCOUNTS[1];
		double actual = calculator.calculateTotalCost();
		
		assertEquals(expected, actual, EPSILON);
	}
	
	@Test
	void given12BooksOrLess_whenCalculateCost_returnCostWithOptimalDiscount() {
			
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
	void givenMoreThan12Books_andBooksAreMostlyDuplicates_whenCalculateCost_returnCostWithApproximateOptimalDiscount() {
			
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
