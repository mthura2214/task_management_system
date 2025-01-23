package com.application.task_manager.controllers;

import com.application.task_manager.models.*;
import com.application.task_manager.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.findAllNotifications();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Integer id) {
        Notification notification = notificationService.findNotificationById(id).orElse(null);
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification newNotification = notificationService.createNotification(notification);
        return new ResponseEntity<>(newNotification, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Integer id, @RequestBody Notification notification) {
        Notification updatedNotification = notificationService.updateNotification(notification);
        return new ResponseEntity<>(updatedNotification, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteNotification(@PathVariable Integer id) {
        notificationService.deleteNotification(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<Notification>> getNotificationsByTask(@PathVariable Integer taskId) {
        List<Notification> notifications = notificationService.findNotificationsByTask(new Task(taskId));
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

@GetMapping("/user/{userId}")
public ResponseEntity<List<Notification>> getNotificationsByUser(@PathVariable Integer userId) {
    List<Notification> notifications = notificationService.findNotificationsByUser(userId);
    return new ResponseEntity<>(notifications, HttpStatus.OK);
}

    @GetMapping("/isRead/{isRead}")
    public ResponseEntity<List<Notification>> getNotificationsByIsRead(@PathVariable Boolean isRead) {
        List<Notification> notifications = notificationService.findNotificationsByIsRead(isRead);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
}