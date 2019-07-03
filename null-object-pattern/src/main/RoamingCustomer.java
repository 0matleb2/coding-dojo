package main;

public class RoamingCustomer extends Customer {
	
	public RoamingCustomer() {
		priceRate = 1.5;
	}

	@Override
	public void makeCall(long durationMinutes) {
		plan.charge(durationMinutes * priceRate);
	}
	
}
