package com.application.task_manager.services;

import com.application.task_manager.models.*;
import com.application.task_manager.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> findAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> findNotificationById(Integer id) {
        return notificationRepository.findById(id);
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void deleteNotification(Integer id) {
        notificationRepository.deleteById(id);
    }

    public List<Notification> findNotificationsByUser(User user) {
        return notificationRepository.findAllByUser(user);
    }

    public List<Notification> findNotificationsByTask(Task task) {
        return notificationRepository.findAllByTask(task);
    }

    public List<Notification> findNotificationsByIsRead(Boolean isRead) {
        return notificationRepository.findAllByIsRead(isRead);
    }
}