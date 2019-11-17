package net.mossol.oc.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import net.mossol.oc.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtTokenUtilService {

    @Value("${mossol.jwtSecret}")
    private String jwtSecret;

    @Value("${mossol.jwtExpireTimeMillis}")
    private long jwtExpireTimeMillis;

    public String generateToken(Authentication authentication) {
        final UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        final Date expireTime = new Date(new Date().getTime() + jwtExpireTimeMillis);
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expireTime)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public String validateToken(String jwtToken) {
        try {
            final Claims claims =
                    Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken)
                            .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            log.warn("Invalid jwt token", e);
            return null;
        }
    }
}
