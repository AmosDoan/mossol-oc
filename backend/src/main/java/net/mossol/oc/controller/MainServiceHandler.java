package net.mossol.oc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MainServiceHandler {

    @GetMapping("/test")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> healthCheck() {
        log.info("Logged");
        return new ResponseEntity(HttpStatus.OK);
    }

}
