package org.model.backend.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap;
import java.util.Calendar;

@Path("/authentication")
public class AuthenticationResource extends MyUser {

    public static final String key = "testkey";

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(LogonRequest logonRequest) {
        try {
            String role = MyUser.validateLogin(logonRequest.username, logonRequest.password);
            if (role == null) {
                throw new IllegalArgumentException("No user found");
            }

            String token = createToken(logonRequest.username, role);

            // Return the token in the response
            return Response.ok(new AbstractMap.SimpleEntry<>("JWT", token)).build();
        } catch (JwtException | IllegalArgumentException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private String createToken(String username, String role) throws JwtException {
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE, 10);
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration.getTime())
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }
    private static class LogonRequest{
        public String username;
        public String password;
    }
}
