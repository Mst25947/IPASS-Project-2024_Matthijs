package testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.backend.model.Product;
import org.model.backend.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @BeforeEach
    void setUp() {
        ShoppingCart.allShoppingCarts.clear();
    }

    @Test
    void testCreateShoppingCart() {
        ShoppingCart cart = new ShoppingCart("John Doe", "john@example.com", 0.0f);

        assertEquals("John Doe", cart.getName());
        assertEquals("john@example.com", cart.getEmail());
        assertEquals(0.0f, cart.getTotalPrice(), 0.001);
        assertTrue(ShoppingCart.getAllShoppingCarts().contains(cart));
    }

    @Test
    void testSetAndGetProducts() {
        ShoppingCart cart = new ShoppingCart("John Doe", "john@example.com", 0.0f);
        ArrayList<Product> products = new ArrayList<>();
        new Product("TRD Side Skirts", "TRD Aerodynamic side skirts", 330, "White", "sideSkirt", "Celica ST20");
        new Product("c-one Side Skirts", "c-one side skirts", 320, "White", "sideSkirt", "Celica ST20");

        cart.setProducts(products);
        assertEquals(products, cart.getProducts());
    }

    @Test
    void testGetAndSetTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        cart.setTotalPrice(50.02F);

        assertEquals(50.02F, cart.getTotalPrice(), 0.001);
    }

    @Test
    void testGetAndSetAllShoppingCarts() {
        ShoppingCart cart1 = new ShoppingCart("John Doe", "john@example.com", 2.0F);
        ShoppingCart cart2 = new ShoppingCart("Jane Doe", "jane@example.com", 3.0F);

        List<ShoppingCart> carts = new ArrayList<>();
        carts.add(cart1);
        carts.add(cart2);

        ShoppingCart.setAllShoppingCards(carts);

        assertEquals(carts, ShoppingCart.getAllShoppingCarts());
        assertTrue(ShoppingCart.getAllShoppingCarts().contains(cart1));
        assertTrue(ShoppingCart.getAllShoppingCarts().contains(cart2));
    }
}