package com.application.task_manager.services;

import com.application.task_manager.models.Task;
import com.application.task_manager.models.User;
import com.application.task_manager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(int id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    public List<Task> findTasksByUser(User user) {
        return taskRepository.findAllByUser(user);
    }

    public List<Task> findTasksByStatus(Task.Status status) {
        return taskRepository.findAllByStatus(status);
    }
}
