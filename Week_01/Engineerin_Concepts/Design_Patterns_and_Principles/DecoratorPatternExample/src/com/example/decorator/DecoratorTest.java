package com.example.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();  // base notifier

        // Add SMS notifications
        notifier = new SMSNotifier(notifier);

        // Add Slack notifications
        notifier = new SlackNotifier(notifier);

        // Send one message through all channels
        notifier.send("System is down!");
    }
}
