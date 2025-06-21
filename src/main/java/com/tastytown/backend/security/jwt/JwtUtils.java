package com.tastytown.backend.security.jwt;

import java.util.Base64;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
    private static final String JWT_SECRET = "6e4dc6768a7ecfc81de917a7a7b4b97ad421ceeb7964eb9bdcc20239e459516d";


    private SecretKey getKey() {
        byte[] keyBytes = Base64.getDecoder().decode(JWT_SECRET);
        return Keys.hmacShaKeyFor(keyBytes);

    }
    public String generateToken(String userId, String role) {
        return Jwts.builder()
                .subject(userId)
                .claim("role", role)
                .signWith(getKey())
                .compact();

    }

    public String getUserId(String token) {//verify token,claimuser,verify
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }
     public String getUserRole(String token) {//verify token,claimuser,verify
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("role")
                .toString();

    }
}
