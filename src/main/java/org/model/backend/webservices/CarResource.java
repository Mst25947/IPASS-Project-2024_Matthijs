package org.model.backend.webservices;

import org.model.backend.model.Car;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {
    @GET
    @Path("/{type}")
    public Response getCarDetails(@PathParam("type") String type) {

        //Alle geinitialiseerde auto objecten worden geladen.
        List<Car> allCars = Car.getAllCars();

        //Auto's worden gefilterd doormiddel van het type, dus in dit geval zou dat bijvoorbeeld "Celica ST20" kunnen zijn.
        Car car = allCars.stream()
                .filter(c -> c.getType().equalsIgnoreCase(type)) //.equalsIgnoreCase zodat het niet hoofdletter gevoelig is.
                .findFirst()                                     //Zoekt naar het eerste object dat aan de criteria voldoet.
                .orElse(null);                             //Geeft een null terug als er niks is gevonden.
        //Als er geen auto gevonden kan worden dan wordt er een status NOT FOUND naar de client gestuurd.
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(car).build();
    }
}