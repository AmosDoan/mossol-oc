package net.mossol.oc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainServiceHandler {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/test")
    public ResponseEntity<?> healthCheck() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/auth/test")
    public ResponseEntity<?> authTest() {
        return new ResponseEntity(HttpStatus.OK);
    }
}