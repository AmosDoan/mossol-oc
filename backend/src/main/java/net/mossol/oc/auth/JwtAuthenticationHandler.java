package net.mossol.oc.auth;

import lombok.extern.slf4j.Slf4j;
import net.mossol.oc.util.JwtTokenUtilService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationHandler extends OncePerRequestFilter {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private JwtTokenUtilService jwtTokenUtilService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String token = request.getHeader("Authorization");
        if (!StringUtils.isEmpty(token)) {
            authenticate(request, response, filterChain, token);
        }
        filterChain.doFilter(request, response);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain,
                              String token) throws IOException, ServletException {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        String userId = null;
        if (StringUtils.isEmpty(token)) {
            log.warn("Invalid request");
        } else {
            userId = jwtTokenUtilService.validateToken(token);
        }

        if (!StringUtils.isEmpty(userId)) {
            final UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
            final UsernamePasswordAuthenticationToken
                    authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
