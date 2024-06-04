package org.Model;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
@Path("/car")
public class CompatiblePartsRequest {
    private String carType;

    @GET
    @Produces("text/plain")
    public String getCompatibleParts() {
        return "hi";
    }

}

