package tinario9954.gmail.com.Kutandisa.Security;
import java.util.Date;
 
import javax.crypto.SecretKey;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
 
@Component
public class JwtUtil {
 
    private final String SECRET = "KutandisaSecretKeyMuitoSegura2024SuperLongaParaHS256Algorithm!";
    private final long EXPIRATION = 86400000L; // 24 horas
 
    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
 
    public String gerarToken(Long userId, String email, String role) {
        return Jwts.builder()
                .subject(email)
                .claim("userId", userId)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getKey())
                .compact();
    }
 
    public Claims extrairClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
 
    public String extrairEmail(String token) {
        return extrairClaims(token).getSubject();
    }
 
    public Long extrairUserId(String token) {
        return extrairClaims(token).get("userId", Long.class);
    }
 
    public String extrairRole(String token) {
        return extrairClaims(token).get("role", String.class);
    }
 
    public boolean validarToken(String token) {
        try {
            Claims claims = extrairClaims(token);
            return !claims.getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}