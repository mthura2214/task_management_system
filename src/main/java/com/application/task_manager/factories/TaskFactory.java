package com.application.task_manager.factories;

import com.application.task_manager.models.Task;
import com.application.task_manager.models.User;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskFactory {

    public static Task createTask(int id, User user, String title, String description, String priority, Task.Status status, LocalDate dueDate, LocalDateTime createTime, LocalDateTime updateTime) {
        Task task = new Task();
        task.setId(id);
        task.setUser(user);
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setStatus(status);
        task.setDueDate(dueDate);
        task.setCreateTime(createTime);
        task.setUpdateTime(updateTime);
        return task;
    }

    public static Task createTask(User user, String title, String description, String priority, Task.Status status, LocalDate dueDate) {
        Task task = new Task();
        task.setUser(user);
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setStatus(status);
        task.setDueDate(dueDate);
        return task;
    }
}
