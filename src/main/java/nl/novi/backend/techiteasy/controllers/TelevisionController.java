package nl.novi.backend.techiteasy.controllers;

import nl.novi.backend.techiteasy.models.dtos.IdInputDto;
import nl.novi.backend.techiteasy.models.dtos.TelevisionInputDto;
import nl.novi.backend.techiteasy.models.dtos.TelevisionOutputDto;
import nl.novi.backend.techiteasy.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("televisions")
public class TelevisionController {
    private final TelevisionService televisionService;

    @Autowired
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionOutputDto>> getTelevisions(){
        return ResponseEntity.ok(televisionService.getTelevisions());
    }

    @GetMapping("{id}")
    public ResponseEntity<TelevisionOutputDto> getTelevision(@PathVariable Long id){
        return ResponseEntity.ok(televisionService.getTelevision(id));
    }

    @PostMapping
    public ResponseEntity<TelevisionOutputDto> addTelevision(@RequestBody TelevisionInputDto newTelevision){
        TelevisionOutputDto televisionOutputDto = televisionService.saveTelevision(newTelevision);
        URI location = URI.create("televisions/" + televisionOutputDto.id);
        return ResponseEntity.created(location).body(televisionOutputDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<TelevisionOutputDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto televisionToUpdate){
        return ResponseEntity.accepted().body(televisionService.updateTelevision(id, televisionToUpdate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTelevision(@PathVariable Long id){
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{televisionId}/remoteControl")
    public ResponseEntity<TelevisionOutputDto> assignRemotecontrol(@PathVariable Long televisionId, @RequestBody IdInputDto remoteControlId) {
        TelevisionOutputDto televisionOutputDto= televisionService.assignRemoteControlToTelevision(televisionId, remoteControlId);
        return ResponseEntity.ok().body(televisionOutputDto);
    }

}
