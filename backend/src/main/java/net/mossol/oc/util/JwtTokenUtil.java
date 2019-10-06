package net.mossol.oc.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import net.mossol.oc.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.util.Date;

@Slf4j
public class JwtTokenUtil {

    @Value("${mossol.auth.jwtSecret}")
    private static String jwtSecret;

    @Value("${mossol.auth.jwtExpireTimeMillis}")
    private static long jwtExpireTimeMillis;

    public static String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date expireTime = new Date(new Date().getTime() + jwtExpireTimeMillis);
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expireTime)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public static String validateToken(String jwtToken) {
        try {
            Claims claims =
                    Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken)
                            .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            log.warn("Invalid jwt token", e);
            return null;
        }
    }
}
