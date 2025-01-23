package factoryTest;

import com.application.task_manager.factories.NotificationFactory;
import com.application.task_manager.models.Notification;
import com.application.task_manager.models.Task;
import com.application.task_manager.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NotificationFactoryTest {

    private Task task;
    private User user;
    private String message;

    @BeforeEach
    public void setUp() {
        task = mock(Task.class);
        user = mock(User.class);
        message = "New task assigned";
    }

    @Test
    public void shouldCreateNotification() {
        Notification notification = NotificationFactory.createNotification(task, user, message);

        assertNotNull(notification);
        assertEquals(task, notification.getTask());
        assertEquals(user, notification.getUser());
        assertEquals(message, notification.getMessage());
        System.out.println(notification);
    }

    @Test
    public void shouldCreateNotificationWithId() {
        Integer id = 1;
        Boolean isRead = false;

        Notification notification = NotificationFactory.createNotification(id, task, user, message, isRead);

        assertNotNull(notification);
        assertEquals(id, notification.getId());
        assertEquals(task, notification.getTask());
        assertEquals(user, notification.getUser());
        assertEquals(message, notification.getMessage());
        assertEquals(isRead, notification.getRead());
        System.out.printf("Notification: %s\n", notification);
    }
}