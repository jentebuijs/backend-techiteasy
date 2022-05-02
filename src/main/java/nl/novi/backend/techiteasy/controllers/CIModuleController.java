package nl.novi.backend.techiteasy.controllers;

import nl.novi.backend.techiteasy.models.dtos.CIModuleInputDto;
import nl.novi.backend.techiteasy.models.dtos.CIModuleOutputDto;
import nl.novi.backend.techiteasy.models.dtos.TelevisionInputDto;
import nl.novi.backend.techiteasy.models.dtos.TelevisionOutputDto;
import nl.novi.backend.techiteasy.services.CIModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("cimodules")
public class CIModuleController {
    private final CIModuleService ciModuleService;

    @Autowired
    public CIModuleController(CIModuleService ciModuleService){
        this.ciModuleService = ciModuleService;
    }

    @GetMapping
    public ResponseEntity<List<CIModuleOutputDto>> getCIModules(){
        return ResponseEntity.ok(ciModuleService.getCIModules());
    }

    @GetMapping("{id}")
    public ResponseEntity<CIModuleOutputDto> getCIModule(@PathVariable Long id){
        return ResponseEntity.ok(ciModuleService.getCIModule(id));
    }

    @PostMapping
    public ResponseEntity<CIModuleOutputDto> addCIModule(@RequestBody CIModuleInputDto newCIModule){
        CIModuleOutputDto ciModuleOutputDto = ciModuleService.saveCIModule(newCIModule);
        URI location = URI.create("televisions/" + ciModuleOutputDto.id);
        return ResponseEntity.created(location).body(ciModuleOutputDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<CIModuleOutputDto> updateCIModule(@PathVariable Long id, @RequestBody CIModuleInputDto ciModuleToUpdate){
        return ResponseEntity.accepted().body(ciModuleService.updateCIModule(id, ciModuleToUpdate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCIModule(@PathVariable Long id){
        ciModuleService.deleteCIModule(id);
        return ResponseEntity.noContent().build();
    }
}
