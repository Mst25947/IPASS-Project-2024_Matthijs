package testing;

import org.junit.jupiter.api.Test;
import org.model.backend.model.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductInitializationTest {

    @Test
    void testProductInitialization() {
        var allProducts = Product.getAllProducts();
        assertEquals(20, allProducts.size());

        assertTrue(allProducts.stream().anyMatch(p -> p.getProductName().equals("TRD GP Splitter")));
        assertTrue(allProducts.stream().anyMatch(p -> p.getProductName().equals("Aero Splitter")));
        assertTrue(allProducts.stream().anyMatch(p -> p.getProductName().equals("Varis Side Skirts")));
        assertTrue(allProducts.stream().anyMatch(p -> p.getProductName().equals("HIRO spoiler")));
        assertTrue(allProducts.stream().anyMatch(p -> p.getProductName().equals("EndWorks Diffuser")));

    }
}