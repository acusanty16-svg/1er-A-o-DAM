package Biblioteca.ejercicio2.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Servicio para crear y validar tokens JWT.
 * Usa la clave secreta de application-dev.yml.
 */

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private long jwtExpiration;

    // Obtiene la clave de firma
    private SecretKey getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Extrae todos los claims del token
    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    // Extrae un claim específico del token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //Extrae el nombre de usuario del token
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    //Extrae una fecha especifica del token
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    //Genera un token con claims adicionales
    public String generateToken(Map<String, Object> extraClaims, String username){
        return Jwts.builder()
                .claims(extraClaims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSigningKey())
                .compact();
    }

    //Genera un token JWT para un usuario
    public String generateToken(String username){
        return generateToken(new HashMap<>(), username);
    }

    //Verifica si el token es valido
    public boolean isTokenValid(String token, String username){
        final String extractUsername = extractUsername(token);
        return (extractUsername.equals(username)) && !isTokenExpired(token);
    }

    //Verifica si el token ha expirado
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }


}
