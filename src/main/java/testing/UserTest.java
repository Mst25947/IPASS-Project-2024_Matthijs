package testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.backend.model.ShoppingCart;
import org.model.backend.model.User;


import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @BeforeEach
    void setUp() {
        User.getAllUsers().clear();
    }

    @Test
    void testCreateUser() {
        User user = new User("John Doe", "123 Main St", "john@example.com", "123-456-7890", "password123", "1");

        assertEquals("John Doe", user.getName());
        assertEquals("123 Main St", user.getAddress());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("123-456-7890", user.getPhoneNumber());
        assertEquals("password123", user.getPassword());
        assertEquals("1", user.getUserId());
        assertNull(user.getMyShoppingCart());
        assertTrue(User.getAllUsers().contains(user));
    }

    @Test
    void testGetAndSetMyShoppingCart() {
        User user = new User("John Doe", "123 Main St", "john@example.com", "123-456-7890", "password123", "1");
        ShoppingCart cart = new ShoppingCart();

        user.setMyShoppingCart(cart);

        assertEquals(cart, user.getMyShoppingCart());
    }

    @Test
    void testFindUserByNameAndPassword() {
        User user1 = new User("John Doe", "123 Main St", "john@example.com", "123-456-7890", "password123", "1");
        User user2 = new User("Jane Doe", "456 Oak St", "jane@example.com", "098-765-4321", "password456", "2");

        User foundUser = User.findUserByNameAndPassword("John Doe", "password123");
        assertNotNull(foundUser);
        assertEquals(user1, foundUser);

        User notFoundUser = User.findUserByNameAndPassword("John Doe", "wrongpassword");
        assertNull(notFoundUser);
    }
}

