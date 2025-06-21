package com.example.builder;

public class BuilderTest {
    public static void main(String[] args) {
        // Build a simple computer
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB")
                .setOperatingSystem("Windows 10")
                .build();

        System.out.println("Basic Computer: " + basicComputer);

        // Build a high-end computer
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setOperatingSystem("Windows 11 Pro")
                .build();

        System.out.println("Gaming Computer: " + gamingComputer);
    }
}
