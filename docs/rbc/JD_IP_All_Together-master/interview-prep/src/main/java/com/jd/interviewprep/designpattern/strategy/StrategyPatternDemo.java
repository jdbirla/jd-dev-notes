package com.jd.interviewprep.designpattern.strategy;

public class StrategyPatternDemo {
	 public static void main(String[] args) {
	        PaymentContext paymentContext = new PaymentContext();

	        // Pay using Credit Card
	        paymentContext.setPaymentStrategy(new CreditCardStrategy("1234-5678-9876-5432", "John Doe"));
	        paymentContext.executePayment(100.00);

	        // Pay using PayPal
	        paymentContext.setPaymentStrategy(new PayPalStrategy("john@example.com"));
	        paymentContext.executePayment(200.00);
	    }
}
