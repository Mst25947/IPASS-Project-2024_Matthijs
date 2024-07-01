package org.model.backend.persistence;

import org.model.backend.model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersistenceManager {

    // Alle bestaande objecten worden opgehaald vanuit het bestand.
    public static void load(String file) throws Exception {
        Path storage = Path.of(file);
        if (Files.exists(storage) && Files.isRegularFile(storage)) {

            InputStream is = Files.newInputStream((storage));
            ObjectInputStream ois = new ObjectInputStream(is);

            HashMap<String, Object> dataList = (HashMap<String, Object>) ois.readObject();
            ContactForm.setAllContactForms((ArrayList<ContactForm>) dataList.get("allContactForms"));
            User.setAllUsers((ArrayList<User>) dataList.get("allUsers"));
            Car.setAllCars((ArrayList<Car>) dataList.get("allCars"));
            Product.setAllProducts((ArrayList<Product>) dataList.get("allProducts"));
            ShoppingCart.setAllShoppingCards((ArrayList<ShoppingCart>) dataList.get("allShoppingCarts"));
            Order.setAllOrders((ArrayList<Order>) dataList.get("allOrders"));
            ois.close();
        } else {
            throw new Exception("no file found");
        }
    }

    // Alle gemaakte objecten worden opgeslagen naar het bestand.
    public static void save(String file) throws IOException {
        HashMap<String, Object> dataList = new HashMap<>();
        List<User> everyUser = User.getAllUsers();
        List<ContactForm> everyContactForm = ContactForm.getAllContactForms();
        List<Car> everyCar = Car.getAllCars();
        List<Product> everyProduct = Product.getAllProducts();
        List<ShoppingCart> everyShoppingCart = ShoppingCart.getAllShoppingCarts();
        List<Order> everyOrder = Order.getAllOrders();
        dataList.put("allUsers", everyUser);
        dataList.put("allContactForms", everyContactForm);
        dataList.put("allCars", everyCar);
        dataList.put("allProducts", everyProduct);
        dataList.put("allShoppingCarts", everyShoppingCart);
        dataList.put("allOrders", everyOrder);
        Path Storage = Path.of(file);

        OutputStream os = Files.newOutputStream(Storage);
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(Storage);
        oos.close();
    }

}