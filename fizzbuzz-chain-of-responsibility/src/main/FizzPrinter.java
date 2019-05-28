package main;

import java.io.IOException;
import java.io.OutputStream;
import java.util.function.IntConsumer;

public class FizzPrinter implements IntConsumer {
	
	private OutputStream o;
	private IntConsumer next;
	
	public FizzPrinter(OutputStream o, IntConsumer next) {
		this.o = o;
		this.next = next;
	}

	@Override
	public void accept(int x) {
		if (x % 3 == 0) {
			try {
				o.write("fizz".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (next != null) {
			next.accept(x);
		}
	}
}
