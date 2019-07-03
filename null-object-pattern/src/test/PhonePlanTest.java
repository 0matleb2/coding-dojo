package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.Customer;
import main.CustomerPlan;
import main.NullCustomer;
import main.PayPerUseCustomer;
import main.RoamingCustomer;

class PhonePlanTest {
	
	private static final double BASIC_PLAN_RATE = 1.0;
	
	private static final double ROAMING_CUSTOMER_RATE = 1.5;
	private static final double PAY_PER_USE_CUSTOMER_RATE = 2.0;
	
	private static final long CALL_DURATION_MINUTES = 30;
	
	CustomerPlan customerPlan;
	Customer customer;
	
	@Before
	void setUp() {
		customerPlan = new CustomerPlan();
	}
	
	@Test
	void givenRoamingCustomer_whenCallMade_balanceIsIncreaseAccordingToRoamingCustomerRate() {
		customerPlan = new CustomerPlan();
		customer = new RoamingCustomer();
		customer.setCustomerPlan(customerPlan);
		
		customer.makeCall(CALL_DURATION_MINUTES);
		
		assertThat(customerPlan.getBalance(), is(CALL_DURATION_MINUTES * BASIC_PLAN_RATE * ROAMING_CUSTOMER_RATE));
	}
	
	@Test
	void givenPayPerUseCustomer_whenCallMade_balanceIsIncreaseAccordingToPayPerUseCustomerRate() {
		customerPlan = new CustomerPlan();
		customer = new PayPerUseCustomer();
		customer.setCustomerPlan(customerPlan);
		
		customer.makeCall(CALL_DURATION_MINUTES);
		
		assertThat(customerPlan.getBalance(), is(CALL_DURATION_MINUTES * BASIC_PLAN_RATE * PAY_PER_USE_CUSTOMER_RATE));
	}
	
	@Test
	void givenNullCustomer_whenCallMade_balanceIsNotIncreased() {
		customerPlan = new CustomerPlan();
		customer = new NullCustomer();
		customer.setCustomerPlan(customerPlan);
		
		customer.makeCall(CALL_DURATION_MINUTES);
		
		assertThat(customerPlan.getBalance(), is(0.0));
	}

}
