package com.example.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.makePayment(1500.0);

        // Switch to PayPal
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.makePayment(2200.5);
    }
}
