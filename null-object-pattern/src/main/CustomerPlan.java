package main;

public class CustomerPlan {
	
	private double balance;
	private double planRate;
	
	public CustomerPlan() {
		this.balance = 0;
		this.planRate = 1.0;
	}
	
	public CustomerPlan(double planRate) {
		this.balance = 0;
		this.planRate = planRate; 
	}
	
	public void charge(double charge) {
		balance += charge * planRate;
	}
	
	public double getBalance() {
		return balance;
	}
	
}
