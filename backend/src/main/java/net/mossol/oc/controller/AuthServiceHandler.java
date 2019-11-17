package net.mossol.oc.controller;

import lombok.extern.slf4j.Slf4j;
import net.mossol.oc.model.*;
import net.mossol.oc.repository.RoleRepository;
import net.mossol.oc.repository.UserRepository;
import net.mossol.oc.util.JwtTokenUtilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthServiceHandler {

    @Resource
    AuthenticationManager authenticationManager;

    @Resource
    UserRepository userRepository;

    @Resource
    RoleRepository roleRepository;

    @Resource
    PasswordEncoder passwordEncoder;

    @Resource
    JwtTokenUtilService jwtTokenUtilService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        final UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserId(),
                        loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = jwtTokenUtilService.generateToken(authentication);
        return ResponseEntity.ok(jwtToken);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        if(userRepository.existsByUserId(registerRequest.getUserId())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        final User user = new User(registerRequest.getUserId(), registerRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = null;
        try {
            userRole = roleRepository.findByType(RoleType.ROLE_USER)
                    .orElseThrow(() -> new Exception("User Role not set."));
        } catch (Exception e) {
            log.warn("Fail to fetch role", e);
        }

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUserId()).toUri();

        return ResponseEntity.created(location).body("User registered successfully");
    }
}
