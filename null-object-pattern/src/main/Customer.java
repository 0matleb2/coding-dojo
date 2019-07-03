package main;

public abstract class Customer {
	
	protected double priceRate;
	protected CustomerPlan plan;
	
	public void setCustomerPlan(CustomerPlan plan) {
		this.plan = plan;
	}
	
	public double getPriceRate() {
		return priceRate;
	}
	
	public abstract void makeCall(long durationMinutes);
	
}
