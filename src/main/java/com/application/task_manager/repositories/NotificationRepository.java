package com.application.task_manager.repositories;

import com.application.task_manager.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    Optional<Notification> findByTaskAndUser(Task task, User user);
    List<Notification> findAllByUserId(Integer userId);
    List<Notification> findAllByUser(User user);

    List<Notification> findAllByTask(Task task);

    List<Notification> findAllByIsRead(Boolean isRead);

    @Query("SELECT n FROM Notification n WHERE n.task = :task AND n.user = :user AND n.isRead = :isRead")
    List<Notification> findNotificationsByTaskAndUserAndIsRead(@Param("task") Task task, @Param("user") User user, @Param("isRead") Boolean isRead);
}