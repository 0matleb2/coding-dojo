package main;

import java.io.OutputStream;
import java.util.function.IntConsumer;

public class FizzBuzz implements IntConsumer {
	
	IntConsumer cor;
	
	public FizzBuzz(OutputStream os) {
		IntConsumer buzzPrinter = new BuzzPrinter(os, null);
		IntConsumer fizzPrinter = new FizzPrinter(os, buzzPrinter);
		IntConsumer fizzBuzzPrinter = new FizzBuzzPrinter(os, fizzPrinter);
		cor = fizzBuzzPrinter;
	}
	
	public void accept(int x) {
		cor.accept(x);
	}

}
