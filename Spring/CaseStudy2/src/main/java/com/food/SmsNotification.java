package com.food;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SmsNotification implements NotificationService {

    public SmsNotification() {
        System.out.println("SmsNotification bean created");
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS: " + message);
    }
}
