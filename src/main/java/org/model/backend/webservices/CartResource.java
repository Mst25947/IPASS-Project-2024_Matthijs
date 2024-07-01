package org.model.backend.webservices;

import com.google.gson.JsonObject;
import org.model.backend.model.Order;
import org.model.backend.model.Product;
import org.model.backend.model.ShoppingCart;
import org.model.backend.model.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.model.backend.model.ShoppingCart.allShoppingCarts;

@Path("/cart")
public class CartResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCart(ShoppingCart cart) {
        try {
            User user = User.findUserByName(cart.getName());

            if (user == null) {
                //als er geen bestaande user is gevonden, vul deze dan in met de naam gegeven tijdens het bestellen en email.
                user = new User(cart.getName(), null, cart.getEmail(), null, null, null);
            }

            //maak een order object aan.
            List<Product> products = cart.getProducts();
            float totalPrice = cart.calculateTotalPrice();
            Order order = new Order(cart.getName(), cart.getEmail(), totalPrice, products);
            Order.addOrder(order);

            //Winkelmandje wordt toegevoegd aan de lijst met alle andere winkelmandjes
            allShoppingCarts.add(cart);

            //Response naar de client als alles goed is gegaan (hier krijgt de gebruker ook een alert van).
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("message", "Order placed successfully");
            return Response.status(Response.Status.CREATED).entity(jsonResponse.toString()).build();

            //Eventuele exceptions opvangen en afhandelen.
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error saving shopping cart and order\"}")
                    .build();
        }
    }
}
