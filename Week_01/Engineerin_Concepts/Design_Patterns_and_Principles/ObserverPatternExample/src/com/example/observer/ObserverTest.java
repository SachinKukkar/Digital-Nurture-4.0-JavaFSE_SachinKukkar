package com.example.observer;

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("TCS", 3500.00);

        Observer mobileUser = new MobileApp("Sachin");
        Observer webUser = new WebApp("Anjali");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        stockMarket.setStockPrice(3600.00);
        stockMarket.setStockPrice(3700.50);
    }
}
