package main;

import java.io.IOException;
import java.io.OutputStream;
import java.util.function.IntConsumer;

public class BuzzPrinter implements IntConsumer {
	
	private OutputStream o;
	private IntConsumer next;
	
	public BuzzPrinter(OutputStream o, IntConsumer next) {
		this.o = o;
		this.next = next;
	}

	@Override
	public void accept(int x) {
		if (x % 5 == 0) {
			try {
				o.write("buzz".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (next != null) {
			next.accept(x);
		}
	}
}
