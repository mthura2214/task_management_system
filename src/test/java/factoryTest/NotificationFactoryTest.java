package factoryTest;
import com.application.task_manager.factories.NotificationFactory;
import com.application.task_manager.models.Notification;
import com.application.task_manager.models.Task;
import com.application.task_manager.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationFactoryTest {

    @Test
    public void testCreateNotification() {
        Task task = new Task(1);
        User user = new User(1);
        String message = "New task assigned";

        Notification notification = NotificationFactory.createNotification(task, user, message);

        assertNotNull(notification);
        assertEquals(task, notification.getTask());
        assertEquals(user, notification.getUser());
        assertEquals(message, notification.getMessage());
    }

    @Test
    public void testCreateNotificationWithId() {
        Integer id = 1;
        Task task = new Task(1);
        User user = new User(1);
        String message = "New task assigned";
        Boolean isRead = false;

        Notification notification = NotificationFactory.createNotification(id, task, user, message, isRead);

        assertNotNull(notification);
        assertEquals(id, notification.getId());
        assertEquals(task, notification.getTask());
        assertEquals(user, notification.getUser());
        assertEquals(message, notification.getMessage());
        assertEquals(isRead, notification.getRead());
    }
}