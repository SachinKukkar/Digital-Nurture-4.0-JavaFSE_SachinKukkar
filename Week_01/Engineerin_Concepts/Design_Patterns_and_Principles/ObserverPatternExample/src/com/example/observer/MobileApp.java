package com.example.observer;

public class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double newPrice) {
        System.out.println("Mobile App (" + user + "): " + stockName + " price updated to ₹" + newPrice);
    }
}
