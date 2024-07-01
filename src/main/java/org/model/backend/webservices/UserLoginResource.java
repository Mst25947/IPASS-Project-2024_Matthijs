package org.model.backend.webservices;

import org.model.backend.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//checkData endpoint die controleerd of de user die probeerd in te loggen al bestaan en of de wachtwoord/username combinatie valide is.
@Path("/checkData")
public class UserLoginResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(User loginRequest) {
        try {
            //Naam en wachtwoord worden geextract.
            String name = loginRequest.getName();
            String password = loginRequest.getPassword();
            //Methode findUserByNameAndPassowrd uit de User klasse wordt gebruikt om te kijken of de user al bestaat.
            User authenticatedUser = User.findUserByNameAndPassword(name, password);
            //ALs er een USer gevonden is die matcged, dan wordt er een response.ok gestuurd (hier krijgt de gebruiker ook een alert van).
            if (authenticatedUser != null) {
                return Response.ok().entity(authenticatedUser).build();
            } else {
                //Is het niet ok? dan wordt er een Response gestuurd met hierin het volgende bericht: v
                return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
            }
            //Opvangen en afhandelen van ventuele exceptions.
        } catch (Exception e) {
            System.out.println("Error during authentication: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred: " + e.getMessage()).build();
        }
    }
}