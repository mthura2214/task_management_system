package com.application.task_manager.models;

import jakarta.persistence.*;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnotification")
    private int id;

    @ManyToOne
    @JoinColumn(name = "Task_idTask", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_idUser", nullable = false)
    private User user;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "is_read")
    private boolean read = false;

    public Notification() {
    }

    public Notification(int id, Task task, User user, String message, boolean read) {
        this.id = id;
        this.task = task;
        this.user = user;
        this.message = message;
        this.read = read;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", task=" + task +
                ", user=" + user +
                ", message='" + message + '\'' +
                ", read=" + read +
                '}';
    }
}
