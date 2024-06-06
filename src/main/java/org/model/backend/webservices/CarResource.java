package org.model.backend.webservices;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

@Path("/cars")
public class CarResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{model}")
    public String getCarDetails(@PathParam("model") String model) {
        JsonObjectBuilder job = Json.createObjectBuilder();

        // Mock data - Replace with your actual data retrieval logic
        if (model.equals("ST23")) {
            job.add("brand", "Toyota");
            job.add("type", "ST23");
            job.add("color", "Red");
            job.add("frontBumper", true);
            job.add("rearBumper", true);
            job.add("sideSkirt", true);
            job.add("spoiler", true);
        } else {
            job.add("error", "Car model not found");
        }

        return job.build().toString();
    }
}