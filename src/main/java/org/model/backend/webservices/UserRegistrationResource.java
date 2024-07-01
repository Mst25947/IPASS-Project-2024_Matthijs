package org.model.backend.webservices;

import com.google.gson.JsonObject;
import org.model.backend.model.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.model.backend.model.User.allUsers;
import static org.model.backend.model.User.findUserByNameAndPassword;

@Path("/register")
public class UserRegistrationResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(User user) {
        try {
            //Dit controleerd net als bij de loginResource of de user al bestaat. Dit wordt wederom gedaan met dezelfde methode in de User klasse.
            User existingUser = findUserByNameAndPassword(user.getName(), user.getPassword());
            if (existingUser != null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Username already exists").build();
            }
            //De Nieuwe user wordt toegevoegd aan de lijst met bestaande users.
            allUsers.add(user);
            //Een Response die de gebruiker krijgt te zien (d.m.v. een alert) als hij/zij succesvol inlogt.
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("message", "User registered successfully");

            return Response.status(Response.Status.CREATED)
                    .entity(jsonResponse.toString()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error saving user data").build();
        }
    }
}