package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.FizzPrinter;

class FizzPrinterTest {

	private ByteArrayOutputStream outContent;
	private FizzPrinter fizzPrinter;
	
	@BeforeEach
	void setUp() throws Exception {
		outContent = new ByteArrayOutputStream();
		fizzPrinter = new FizzPrinter(new PrintStream(outContent), null);
	}

	@Test
	void when3Accepted_thenPrintFizz() {
		fizzPrinter.accept(3);
		assertThat(outContent.toString(), is(equalTo("fizz")));
	}
	
	@Test
	void when5Accepted_thenPrintNothing() {
		fizzPrinter.accept(5);
		assertThat(outContent.toString(), is(equalTo("")));
	}
	
	@Test
	void when15Accepted_thenPrintFizz() {
		fizzPrinter.accept(15);
		assertThat(outContent.toString(), is(equalTo("fizz")));
	}

}
