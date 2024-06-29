package org.model.backend.webservices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.model.backend.model.ShoppingCart;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Path("/cart")
public class CartResource {
    // carts get saved to: C:\Users\trick\Downloads\apache-tomcat-9.0.88-windows-x64\apache-tomcat-9.0.88\bin\shopping_cart.json
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCart(ShoppingCart cart) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(cart);

        String filePath = "shopping_cart.json";

        try (FileWriter file = new FileWriter(filePath, true)) {
            if (Files.size(Paths.get(filePath)) == 0) {
                file.write("[\n");
            } else {
                file.write(",\n");
            }

            file.write(json);
            file.write("\n]");
            file.flush();

            return Response.status(Response.Status.CREATED)
                    .entity("{\"message\": \"Order placed successfully\"}")
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error saving shopping cart\"}")
                    .build();
        }
    }
}