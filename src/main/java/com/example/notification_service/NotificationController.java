package com.example.notification_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest request) {
        Notification notification = new Notification();
        notification.setUserId(request.getUserId());
        notification.setMessage(request.getMessage());
        notificationRepository.save(notification);
        System.out.println("Notification saved: " + notification.getMessage());
    }

    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable Long id) {
        System.out.println("Поиск юзера по " + id);
        return notificationRepository.findById(id).orElse(null);
    }

    @GetMapping("/all")
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
