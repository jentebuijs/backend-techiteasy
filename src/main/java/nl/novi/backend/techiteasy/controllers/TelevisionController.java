package nl.novi.backend.techiteasy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("televisions")
public class TelevisionController {

    @GetMapping
    public ResponseEntity<String> getAllTelevisions(){
        return ResponseEntity.ok("Alle televisies");
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getTelevision(@PathVariable String id){
        return ResponseEntity.ok("Televisie");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTelevision(@RequestBody Object newTelevision){
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable String id, @RequestBody Object updatedTelevision){
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTelevision(@PathVariable String id){
    }
}
