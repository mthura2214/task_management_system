
package factoryTest;

import com.application.task_manager.factories.UserFactory;
import com.application.task_manager.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserFactoryTest {

    @Test
    public void testCreateUser() {
        int id = 1;
        String firstName = "John";
        String lastName = "Doe";
        String username = "johndoe";
        String password = "password";
        String email = "johndoe@example.com";
        User.Role role = User.Role.USER;
        String createTime = "2022-01-01 12:00:00";

        User user = UserFactory.createUser(id, firstName, lastName, username, password, email, role, createTime);

        assertNotNull(user);
        assertEquals(id, user.getId());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(role, user.getRole());
    }

    @Test
    public void testCreateUserWithoutId() {
        String firstName = "John";
        String lastName = "Doe";
        String username = "johndoe";
        String password = "password";
        String email = "johndoe@example.com";

        User user = UserFactory.createUser(firstName, lastName, username, password, email);

        assertNotNull(user);
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
    }
}