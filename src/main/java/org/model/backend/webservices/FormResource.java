package org.model.backend.webservices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.model.backend.model.ContactForm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.JsonObject;

// form data wordt opgeslagen in: C:\Users\trick\Downloads\apache-tomcat-9.0.88-windows-x64\apache-tomcat-9.0.88\bin\form_data.json

@Path("/submit")
public class FormResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response submitForm(ContactForm form) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(form);

        String filePath = "form_data.json";

        try (FileWriter file = new FileWriter(filePath, true)) {
            if (Files.size(Paths.get(filePath)) == 0) {
                file.write("[\n");
            } else {
                file.write(",\n");
            }

            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error saving form data").build();
        }

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("message", "Form submitted successfully");

        return Response.ok().entity(gson.toJson(jsonResponse)).build();
    }
}