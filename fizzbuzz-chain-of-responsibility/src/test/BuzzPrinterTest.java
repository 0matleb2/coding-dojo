package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.BuzzPrinter;

class BuzzPrinterTest {

	private ByteArrayOutputStream outContent;
	private BuzzPrinter buzzPrinter;
	
	@BeforeEach
	void setUp() throws Exception {
		outContent = new ByteArrayOutputStream();
		buzzPrinter = new BuzzPrinter(new PrintStream(outContent), null);
	}

	@Test
	void when3Accepted_thenPrintNothing() {
		buzzPrinter.accept(3);
		assertThat(outContent.toString(), is(equalTo("")));
	}
	
	@Test
	void when5Accepted_thenPrintBuzz() {
		buzzPrinter.accept(5);
		assertThat(outContent.toString(), is(equalTo("buzz")));
	}
	
	@Test
	void when15Accepted_thenPrintBuzz() {
		buzzPrinter.accept(15);
		assertThat(outContent.toString(), is(equalTo("buzz")));
	}

}
