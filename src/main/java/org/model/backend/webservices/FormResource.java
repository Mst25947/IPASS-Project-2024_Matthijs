package org.model.backend.webservices;

import com.google.gson.JsonObject;
import org.model.backend.model.ContactForm;
import org.model.backend.persistence.PersistenceManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

import static org.model.backend.model.ContactForm.allContactForms;

@Path("/submit")
public class FormResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response submitForm(ContactForm form) {
        try {
            //Contactformulier wordt in de lijst met alle contactformulieren gestopt.
            allContactForms.add(form);
            //Opvangen en afhandelen van eventuele exceptions.
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error saving form data").build();
        }
        //Een json responds naar de client, de gebruiker krijgt hier ook een alert van.
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("message", "Form submitted successfully");

        return Response.ok().entity(jsonResponse.toString()).build();
    }
}