package nl.novi.backend.techiteasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelevisionController {

    @GetMapping
    public ResponseEntity<String> getAllTelevisions() {
        return ResponseEntity.ok("Alle televisies");
    }
}
