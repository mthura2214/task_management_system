package factory;

import com.application.task_manager.models.User;
import com.application.task_manager.models.Role;

import java.sql.Timestamp;

public class UserFactoryTest {

    // Static method to create a User instance
    public static User createUser(int idUser, String firstName, String lastName, String username, String password, String email, Role role) {
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        return new User();
    }

    // Overloaded method to create a User with default values
    public static User createDefaultUser() {
        return createUser(
                1,
                "John",
                "Doe",
                "johndoe",
                "password123",
                "johndoe@example.com",
                Role.USER
        );
    }
}
