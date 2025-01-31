package com.jd.interviewprep.designpattern.strategy;

public class PaymentContext {
	 private PaymentStrategy paymentStrategy;

	    // Set the strategy at runtime
	    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
	        this.paymentStrategy = paymentStrategy;
	    }

	    // Call the strategy to execute payment
	    public void executePayment(double amount) {
	        if (paymentStrategy != null) {
	            paymentStrategy.pay(amount);
	        } else {
	            System.out.println("No payment strategy selected!");
	        }
	    }
}
