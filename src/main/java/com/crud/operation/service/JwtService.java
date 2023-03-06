package com.crud.operation.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;

@Component
public class JwtService {

    //the number 86400000 is the day in ms
    static final long EXPIRATIONTIME = 86400000;

    static final String PREFIX = "Bearer";

    //Generate the secret key only for the demonstration
    //you should read it from the application configuration
    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS384);

    //Generate signed JWT token
    public String getToken(String username) {
        String token =
                Jwts.builder()
                        .setSubject(username)
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                        .signWith(key)
                        .compact();

        return token;
    }

    // Get a token from request Authorization header,
    // verify a token and get username
    public String getAuthUser(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null) {
            String user = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user != null)
                return user;
        }
        return null;
    }
}
