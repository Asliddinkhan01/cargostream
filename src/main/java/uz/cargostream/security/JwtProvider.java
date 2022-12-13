package uz.cargostream.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import uz.cargostream.entity.admin.enums.Role;

import java.util.Date;

@Component
public class JwtProvider {
    private static final long expirationTime = 1000 * 60 * 60 * 24;
    private static final String key = "secretKey";

    public String generateToken(String username, Role roles) {
//                                              expiration time 5 days, we will change later
        Date expireDate = new Date(System.currentTimeMillis() + expirationTime * 5);
        String token = Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .claim("roles", roles)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        return token;
    }

    public String getPhoneNumber(String token) {
        try {
            String phoneNumber = Jwts
                    .parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            return phoneNumber;
        } catch (Exception e) {
            return null;
        }
    }

}
