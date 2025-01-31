package com.jd.interviewprep.designpattern.strategy;

public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardStrategy(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

