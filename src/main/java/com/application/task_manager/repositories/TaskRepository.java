package com.application.task_manager.repositories;
import com.application.task_manager.models.Task;
import com.application.task_manager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Optional<Task> findByTitle(String title);

    List<Task> findAllByUser(User user);

    List<Task> findAllByStatus(Task.Status status);

    @Query("SELECT t FROM Task t WHERE t.dueDate = :dueDate")
    List<Task> findTasksByDueDate(@Param("dueDate") LocalDate dueDate);
}
