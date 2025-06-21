package com.example.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("sample_photo1.jpg");
        Image img2 = new ProxyImage("sample_photo2.jpg");

        // Image is loaded only when display() is called
        img1.display();  // Loads and displays
        img1.display();  // Uses cached object

        img2.display();
    }
}
