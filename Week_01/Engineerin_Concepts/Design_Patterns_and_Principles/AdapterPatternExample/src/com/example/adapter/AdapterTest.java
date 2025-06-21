package com.example.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(new RazorpayGateway());
        razorpayProcessor.processPayment(1500.00);

        PaymentProcessor paypalProcessor = new PaypalAdapter(new PaypalGateway());
        paypalProcessor.processPayment(2200.75);
    }
}
