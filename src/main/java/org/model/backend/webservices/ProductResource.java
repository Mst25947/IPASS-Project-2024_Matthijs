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

    static {
        new Product("Varis Front Bumper", "High quality varis front bumper", 500, "Black", "frontBumper", "Celica ST20");
        new Product("c-one Front Bumper", "High quality c-one front bumper", 450, "Black", "frontBumper", "Celica ST20");
        new Product("Veilside Front Bumper", "High quality veilside front bumper", 350, "Black", "frontBumper", "Celica ST20");
        new Product("gt-4 Front Bumper", "High quality gt-4 front bumper", 750, "Black", "frontBumper", "Celica ST20");
        new Product("TRD Side Skirt", "TRD Aerodynamic side skirt", 300, "White", "sideSkirt", "Celica ST20");
        new Product("TRD Spoiler", "TRD Enhanced spoiler for better downforce", 350, "Blue", "spoiler", "Celica ST20");
    }

    @GET
    public Response getProducts(@QueryParam("carModel") String carModel, @QueryParam("productType") String productType) {
        List<Product> filteredProducts = Product.allProducts.stream()
                .filter(product -> product.getCarModel().equalsIgnoreCase(carModel) && product.getProductType().equalsIgnoreCase(productType))
                .collect(Collectors.toList());

        if (filteredProducts.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(filteredProducts).build();
    }


}