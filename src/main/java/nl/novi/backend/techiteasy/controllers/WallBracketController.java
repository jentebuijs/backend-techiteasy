package nl.novi.backend.techiteasy.controllers;

import nl.novi.backend.techiteasy.models.dtos.CIModuleInputDto;
import nl.novi.backend.techiteasy.models.dtos.CIModuleOutputDto;
import nl.novi.backend.techiteasy.models.dtos.WallBracketInputDto;
import nl.novi.backend.techiteasy.models.dtos.WallBracketOutputDto;
import nl.novi.backend.techiteasy.models.entities.WallBracket;
import nl.novi.backend.techiteasy.services.WallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("wallbrackets")
public class WallBracketController {
    private final WallBracketService wallBracketService;

    @Autowired
    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @GetMapping
    public ResponseEntity<List<WallBracketOutputDto>> getWallBrackets(){
        return ResponseEntity.ok(wallBracketService.getWallBrackets());
    }

    @GetMapping("{id}")
    public ResponseEntity<WallBracketOutputDto> getWallBrackets(@PathVariable Long id){
        return ResponseEntity.ok(wallBracketService.getWallBrackets(id));
    }

    @PostMapping
    public ResponseEntity<WallBracketOutputDto> addWallBracket(@RequestBody WallBracketInputDto newWallBracket){
        WallBracketOutputDto wallBracketOutputDto = wallBracketService.saveWallBracket(newWallBracket);
        URI location = URI.create("televisions/" + wallBracketOutputDto.id);
        return ResponseEntity.created(location).body(wallBracketOutputDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<WallBracketOutputDto> updateWallBracket(@PathVariable Long id,
                                                                  @RequestBody WallBracketInputDto wallBracketToUpdate){
        return ResponseEntity.accepted().body(wallBracketService.updateWallBracket(id, wallBracketToUpdate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCIModule(@PathVariable Long id){
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }
}
