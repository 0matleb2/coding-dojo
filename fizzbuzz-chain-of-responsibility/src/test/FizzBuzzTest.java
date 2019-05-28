package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.FizzBuzz;


class FizzBuzzTest {

	private ByteArrayOutputStream outContent;
	private FizzBuzz fizzBuzz;
	
	@BeforeEach
	void setUp() throws Exception {
		outContent = new ByteArrayOutputStream();
		fizzBuzz = new FizzBuzz(new PrintStream(outContent));
	}
	
	@Test
	void when3Accepted_thenPrintFizz() {
		fizzBuzz.accept(3);
		assertThat(outContent.toString(), is("fizz"));
	}
	
	@Test
	void when4Accepted_thenPrintNothing() {
		fizzBuzz.accept(4);
		assertThat(outContent.toString(), is(""));
	}
	
	@Test
	void when5Accepted_thenPrintBuzz() {
		fizzBuzz.accept(5);
		assertThat(outContent.toString(), is("buzz"));
	}
	
	@Test
	void when15Accepted_thenPrintFizzbuzz() {
		fizzBuzz.accept(15);
		assertThat(outContent.toString(), is("fizzbuzz"));
	}

}
