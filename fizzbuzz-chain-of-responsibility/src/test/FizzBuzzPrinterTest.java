package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.FizzBuzzPrinter;

class FizzBuzzPrinterTest {

	private ByteArrayOutputStream outContent;
	private FizzBuzzPrinter fizzBuzzPrinter;
	
	@BeforeEach
	void setUp() throws Exception {
		outContent = new ByteArrayOutputStream();
		fizzBuzzPrinter = new FizzBuzzPrinter(new PrintStream(outContent), null);
	}

	@Test
	void when3Accepted_thenPrintNothing() {
		fizzBuzzPrinter.accept(3);
		assertThat(outContent.toString(), is(equalTo("")));
	}
	
	@Test
	void when5Accepted_thenPrintBuzz() {
		fizzBuzzPrinter.accept(5);
		assertThat(outContent.toString(), is(equalTo("")));
	}
	
	@Test
	void when15Accepted_thenPrintBuzz() {
		fizzBuzzPrinter.accept(15);
		assertThat(outContent.toString(), is(equalTo("fizzbuzz")));
	}

}
