package nl.novi.backend.techiteasy.controllers;

import nl.novi.backend.techiteasy.models.dtos.CIModuleInputDto;
import nl.novi.backend.techiteasy.models.dtos.CIModuleOutputDto;
import nl.novi.backend.techiteasy.models.dtos.RemoteControlInputDto;
import nl.novi.backend.techiteasy.models.dtos.RemoteControlOutputDto;
import nl.novi.backend.techiteasy.services.RemoteControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("remotecontrols")
public class RemoteControlController {
    private final RemoteControlService remoteControlService;

    @Autowired
    public RemoteControlController(RemoteControlService remoteControlService) {
        this.remoteControlService = remoteControlService;
    }

    @GetMapping
    public ResponseEntity<List<RemoteControlOutputDto>> getRemoteControls(){
            return ResponseEntity.ok(remoteControlService.getRemoteControls());
    }

    @GetMapping("{id}")
    public ResponseEntity<RemoteControlOutputDto> getRemoteControl(@PathVariable Long id){
        return ResponseEntity.ok(remoteControlService.getRemoteControl(id));
    }

    @PostMapping
    public ResponseEntity<RemoteControlOutputDto> addRemoteControl(@RequestBody RemoteControlInputDto newRemoteControl){
        RemoteControlOutputDto remoteControlOutputDto = remoteControlService.saveRemoteControl(newRemoteControl);
        URI location = URI.create("televisions/" + remoteControlOutputDto.id);
        return ResponseEntity.created(location).body(remoteControlOutputDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<RemoteControlOutputDto> updateRemoteControl(@PathVariable Long id, @RequestBody RemoteControlInputDto remoteControlToUpdate){
        return ResponseEntity.accepted().body(remoteControlService.updateRemoteControl(id, remoteControlToUpdate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteRemoteControl(@PathVariable Long id){
        remoteControlService.deleteRemoteControl(id);
        return ResponseEntity.noContent().build();
    }
}
