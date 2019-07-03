package main;

public class NullCustomer extends Customer {

	public NullCustomer() {
		this.priceRate = 0.0;
	}

	@Override
	public void makeCall(long durationMinutes) {
		plan.charge(0);		
	}
	
}
