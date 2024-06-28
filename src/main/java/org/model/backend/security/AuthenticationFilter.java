package org.model.backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestCtx) {
        String authHeader = requestCtx.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring("Bearer".length()).trim();

            try {
                JwtParser parser = Jwts.parser().setSigningKey(AuthenticationResource.key);
                Claims claims = parser.parseClaimsJws(token).getBody();

                String username = claims.getSubject();
                String role = (String) claims.get("role");

                // Create security context with user and role
                MyUser user = MyUser.getUserByUsername(username);
                MySecurityContext msc = new MySecurityContext(user, requestCtx.getUriInfo().getRequestUri().getScheme());

                requestCtx.setSecurityContext(msc);
                return;
            } catch (JwtException | IllegalArgumentException e) {
                // Handle invalid token
                e.printStackTrace();
                System.out.println("Invalid JWT token");
            }
        }

        // If no valid token found or validation failed, set as guest
        MySecurityContext msc = new MySecurityContext(null, requestCtx.getUriInfo().getRequestUri().getScheme());
        requestCtx.setSecurityContext(msc);
    }
}
