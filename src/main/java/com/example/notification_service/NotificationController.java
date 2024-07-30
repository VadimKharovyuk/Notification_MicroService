package com.example.notification_service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {


    @PostMapping("/notifications")
    public void sendNotification(@RequestBody NotificationRequest request) {
        // Логика отправки уведомления
        System.out.println("Sending notification to user: " + request.getUserId());
        System.out.println("Message: " + request.getMessage());
    }

}
