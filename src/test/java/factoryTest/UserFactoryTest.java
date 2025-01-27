
package factoryTest;

import com.application.task_manager.factories.UserFactory;
import com.application.task_manager.models.Role;
import com.application.task_manager.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserFactoryTest {

    @Test
    public void testCreateUser() {
        int id = 1;
        String firstName = "John";
        String lastName = "Doe";
        String email = "johndoe@example.com";
        String username = "johndoe";
        String password = "password";
        Role role = Role.USER;
        String createTime = "2022-01-01 12:00:00";

        User user = UserFactory.createUser(id, firstName, lastName, email, username, password, role, createTime);

        assertNotNull(user);
        assertEquals(id, user.getId());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(email, user.getEmail());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(role, user.getRole());
        System.out.println(user);
    }

    @Test
    public void testCreateUserWithoutId() {
        String firstName = "John";
        String lastName = "Doe";
        String email = "johndoe@example.com";
        String username = "johndoe";
        String password = "password";

        User user = UserFactory.createUser2(firstName, lastName, email, username, password);
        assertNotNull(user);
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(email, user.getEmail());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        System.out.println(user);
    }
}