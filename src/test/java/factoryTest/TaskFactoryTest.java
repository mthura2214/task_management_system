package factoryTest;

import com.application.task_manager.factories.TaskFactory;
import com.application.task_manager.models.Task;
import com.application.task_manager.models.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTest {

    @Test
    public void testCreateTask() {
        User user = new User();
        String title = "Test Task";
        String description = "This is a test task";
        String priority = "High";
        Task.Status status = Task.Status.PENDING;
        LocalDate dueDate = LocalDate.now();

        Task task = TaskFactory.createTask(user, title, description, priority, status, dueDate);

        assertNotNull(task);
        assertEquals(title, task.getTitle());
        assertEquals(description, task.getDescription());
        assertEquals(priority, task.getPriority());
        assertEquals(status, task.getStatus());
        assertEquals(dueDate, task.getDueDate());
    }
}