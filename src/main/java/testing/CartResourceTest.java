package testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.backend.model.Order;
import org.model.backend.model.Product;
import org.model.backend.model.ShoppingCart;
import org.model.backend.model.User;
import org.model.backend.webservices.CartResource;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartResourceTest {

    @BeforeEach
    void setUp() {
        User.allUsers.clear();
        ShoppingCart.allShoppingCarts.clear();
        Order.getAllOrders().clear();
    }

    @Test
    void saveCart_WithExistingUser_ShouldCreateOrder() {
        ShoppingCart cart = new ShoppingCart();
        cart.setName("Test User");
        cart.setEmail("testuser@gmail.com");
        cart.setProducts(createDummyProducts());

        User testUser = new User("Test User", "Teststraat 1", "testuser@gmail.com", "06-12345678", "test123", "1");
        User.allUsers.add(testUser);

        CartResource cartResource = new CartResource();
        Response response = cartResource.saveCart(cart);

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertEquals(1, Order.getAllOrders().size());

        Order order = Order.getAllOrders().get(0);
        assertEquals(cart.getName(), order.getCustomerName());
        assertEquals(cart.getEmail(), order.getCustomerEmail());
        assertEquals(cart.calculateTotalPrice(), order.getTotalPrice());
        assertEquals(cart.getProducts().size(), order.getOrderedProducts().size());
    }

    @Test
    void saveCart_WithNewUser_ShouldCreateOrderWithTemporaryUser() {
        ShoppingCart cart = new ShoppingCart();
        cart.setName("New User");
        cart.setEmail("newuser@gmail.com");
        cart.setProducts(createDummyProducts());

        CartResource cartResource = new CartResource();
        Response response = cartResource.saveCart(cart);

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertEquals(1, Order.getAllOrders().size());

        Order order = Order.getAllOrders().get(0);
        assertEquals(cart.getName(), order.getCustomerName());
        assertEquals(cart.getEmail(), order.getCustomerEmail());
        assertEquals(cart.calculateTotalPrice(), order.getTotalPrice());
        assertEquals(cart.getProducts().size(), order.getOrderedProducts().size());

        assertEquals(1, User.getAllUsers().size());
        User createdUser = User.getAllUsers().get(0);
        assertEquals(cart.getName(), createdUser.getName());
        assertEquals(cart.getEmail(), createdUser.getEmail());
    }

    @Test
    void saveCart_WithInvalidData_ShouldReturnError() {
        ShoppingCart cart = new ShoppingCart();
        cart.setName(null);
        cart.setEmail(null);
        cart.setProducts(createDummyProducts());

        CartResource cartResource = new CartResource();
        Response response = cartResource.saveCart(cart);

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    private ArrayList<Product> createDummyProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Varis Front Bumper", "High quality varis front bumper", 500, "Black", "frontBumper", "Celica ST20"));
        products.add(new Product("c-one Front Bumper", "High quality c-one front bumper", 450, "Black", "frontBumper", "Celica ST20"));
        return products;
    }
}