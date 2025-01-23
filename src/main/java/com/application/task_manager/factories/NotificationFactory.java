package com.application.task_manager.factories;

import com.application.task_manager.models.Notification;
import com.application.task_manager.models.Task;
import com.application.task_manager.models.User;

public class NotificationFactory {

    public static Notification createNotification(Task task, User user, String message) {
        Notification notification = new Notification();
        notification.setTask(task);
        notification.setUser(user);
        notification.setMessage(message);
        return notification;
    }

    public static Notification createNotification(Integer id, Task task, User user, String message, Boolean isRead) {
        Notification notification = new Notification();
        notification.setId(id);
        notification.setTask(task);
        notification.setUser(user);
        notification.setMessage(message);
        notification.setRead(isRead);
        return notification;
    }
}