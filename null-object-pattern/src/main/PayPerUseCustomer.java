package main;

public class PayPerUseCustomer extends Customer {

	public PayPerUseCustomer() {
		priceRate = 2.0;
	}

	@Override
	public void makeCall(long durationMinutes) {
		plan.charge(durationMinutes * priceRate);
	}
}
