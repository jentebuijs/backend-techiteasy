package nl.novi.backend.techiteasy.services;

import nl.novi.backend.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.backend.techiteasy.models.dtos.RemoteControlInputDto;
import nl.novi.backend.techiteasy.models.dtos.RemoteControlOutputDto;
import nl.novi.backend.techiteasy.models.entities.RemoteControl;
import nl.novi.backend.techiteasy.repositories.RemoteControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.backend.techiteasy.models.dtos.RemoteControlInputDto.toRemoteControl;
import static nl.novi.backend.techiteasy.models.dtos.RemoteControlOutputDto.fromRemoteControl;

@Service
public class RemoteControlService {
    private final RemoteControlRepository remotecontrolRepository;

    @Autowired
    public RemoteControlService(RemoteControlRepository remotecontrolRepository) {
        this.remotecontrolRepository = remotecontrolRepository;
    }

    public List<RemoteControlOutputDto> getRemoteControls(){
        List<RemoteControl> remoteControls = remotecontrolRepository.findAll();
        List<RemoteControlOutputDto> remoteControlOutputDtos = new ArrayList<>();
        for (RemoteControl remoteControl : remoteControls){
            remoteControlOutputDtos.add(fromRemoteControl(remoteControl));
        }
        return remoteControlOutputDtos;
    }

    public RemoteControlOutputDto getRemoteControl(Long id){
        Optional<RemoteControl> remoteControlFound = remotecontrolRepository.findById(id);
        if(remoteControlFound.isEmpty()){
            throw new RecordNotFoundException("Remotecontrol not found");
        }
        return fromRemoteControl(remotecontrolRepository.getById(id));
    }

    public RemoteControlOutputDto saveRemoteControl(RemoteControlInputDto remoteControlInputDto){
        RemoteControl remoteControlToSave = toRemoteControl(remoteControlInputDto);
        return fromRemoteControl(remotecontrolRepository.save(remoteControlToSave));
    }

    public RemoteControlOutputDto updateRemoteControl(Long id, RemoteControlInputDto remoteControlInputDto){
        Optional<RemoteControl> remoteControlFound = remotecontrolRepository.findById(id);
        if(remoteControlFound.isEmpty()){
            throw new RecordNotFoundException("Remotecontrol not found");
        }
        RemoteControl remoteControlToUpdate = toRemoteControl(remoteControlInputDto);
        remoteControlToUpdate.setId(id);
        return fromRemoteControl(remotecontrolRepository.save(remoteControlToUpdate));
    }

    public void deleteRemoteControl(Long id){
        Optional<RemoteControl> remoteControlFound = remotecontrolRepository.findById(id);
        if(remoteControlFound.isEmpty()){
            throw new RecordNotFoundException("Remotecontrol not found");
        }
        remotecontrolRepository.deleteById(id);
    }
}
