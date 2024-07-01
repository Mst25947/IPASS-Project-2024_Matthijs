package org.model.backend.webservices;

import org.model.backend.model.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    @GET
    public Response getProducts(@QueryParam("carModel") String carModel, @QueryParam("productType") String productType) {

        //Hier wordt wederom gebruikt gemaakt van .stream() om te filteren op de criteria carModel en productType.
        //Product("Varis Front Bumper", "High quality varis front bumper", 500, "Black", productType: "frontBumper", carModel: "Celica ST20");
        List<Product> filteredProducts = Product.allProducts.stream()
                .filter(product -> product.getCarModel().equalsIgnoreCase(carModel) && product.getProductType().equalsIgnoreCase(productType))
                .collect(Collectors.toList());      //Gooit alle gefilterede producten in een lijst.

        //En not found response als er geen producten zijn gevonden die aan de criteria voldoen.
        if (filteredProducts.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(filteredProducts).build();
    }
}
