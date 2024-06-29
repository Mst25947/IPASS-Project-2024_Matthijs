package org.model.backend.webservices;

import org.model.backend.model.Car;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    private static final Map<String, Car> carsDatabase = new HashMap<>();

    static {
        carsDatabase.put("Celica T23", new Car("Toyota", "Celica T23", "Red", true, true, true, true, true, false, false));
        carsDatabase.put("Celica ST20", new Car("Toyota", "Celica ST20", "Blue", true, true, true, true, false, true, true));
        carsDatabase.put("Celica ST18", new Car("Toyota", "Celica ST18", "Black", true, true, true, false, true, false, false));
        carsDatabase.put("GT-86", new Car("Toyota", "GT-86", "Yellow", true, true, false, true, true, true, true));
    }

    @GET
    @Path("/{type}")
    public Response getCarDetails(@PathParam("type") String type) {
        Car car = carsDatabase.get(type);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Return the car object as JSON
        return Response.ok(car).build();
    }
}