package nl.novi.backend.techiteasy.services;

import nl.novi.backend.techiteasy.exceptions.TelevisionNotFoundException;
import nl.novi.backend.techiteasy.models.dtos.TelevisionInputDto;
import nl.novi.backend.techiteasy.models.dtos.TelevisionOutputDto;
import nl.novi.backend.techiteasy.models.entities.Television;
import nl.novi.backend.techiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.backend.techiteasy.models.dtos.TelevisionInputDto.toTelevision;
import static nl.novi.backend.techiteasy.models.dtos.TelevisionOutputDto.fromTelevision;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionOutputDto> getTelevisions(){
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionOutputDto> televisionOutputDtos = new ArrayList<>();
        for (Television television : televisions){
            televisionOutputDtos.add(fromTelevision(television));
        }
        return televisionOutputDtos;
    }

    public TelevisionOutputDto getTelevision(Long id){
        Optional<Television> TelevisionFound = televisionRepository.findById(id);
        if(TelevisionFound.isEmpty()){
            throw new TelevisionNotFoundException("Television not found");
        }
        return fromTelevision(televisionRepository.getById(id));
    }

    public TelevisionOutputDto saveTelevision(TelevisionInputDto televisionInputDto){
        Television televisionToSave = toTelevision(televisionInputDto);
        return fromTelevision(televisionRepository.save(televisionToSave));
    }

    public TelevisionOutputDto updateTelevision(Long id, TelevisionInputDto updatedTelevision){
        Optional<Television> televisionFound = televisionRepository.findById(id);
        if(televisionFound.isEmpty()){
            throw new TelevisionNotFoundException("Television not found");
        }
        Television televisionToUpdate = toTelevision(updatedTelevision);
        televisionToUpdate.setId(id);
        return fromTelevision(televisionRepository.save(televisionToUpdate));
    }

    public void deleteTelevision(Long id){
        Optional<Television> televisionFound = televisionRepository.findById(id);
        if(televisionFound.isEmpty()){
            throw new TelevisionNotFoundException("Television not found");
        }
        televisionRepository.deleteById(id);
    }
}
