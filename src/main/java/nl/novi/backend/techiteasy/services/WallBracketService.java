package nl.novi.backend.techiteasy.services;

import nl.novi.backend.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.backend.techiteasy.models.dtos.TelevisionInputDto;
import nl.novi.backend.techiteasy.models.dtos.TelevisionOutputDto;
import nl.novi.backend.techiteasy.models.dtos.WallBracketInputDto;
import nl.novi.backend.techiteasy.models.dtos.WallBracketOutputDto;
import nl.novi.backend.techiteasy.models.entities.Television;
import nl.novi.backend.techiteasy.models.entities.WallBracket;
import nl.novi.backend.techiteasy.repositories.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.backend.techiteasy.models.dtos.TelevisionInputDto.toTelevision;
import static nl.novi.backend.techiteasy.models.dtos.TelevisionOutputDto.fromTelevision;
import static nl.novi.backend.techiteasy.models.dtos.WallBracketInputDto.toWallBracket;
import static nl.novi.backend.techiteasy.models.dtos.WallBracketOutputDto.fromWallBracket;

@Service
public class WallBracketService {
    private final WallBracketRepository wallBracketRepository;

    @Autowired
    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracketOutputDto> getWallBrackets(){
        List<WallBracket> wallBrackets = wallBracketRepository.findAll();
        List<WallBracketOutputDto> wallBracketOutputDtos = new ArrayList<>();
        for (WallBracket wallBracket : wallBrackets){
            wallBracketOutputDtos.add(fromWallBracket(wallBracket));
        }
        return wallBracketOutputDtos;
    }

    public WallBracketOutputDto getWallBrackets(Long id){
        Optional<WallBracket> wallBracketFound = wallBracketRepository.findById(id);
        if(wallBracketFound.isEmpty()){
            throw new RecordNotFoundException("Wallbracket not found");
        }
        return fromWallBracket(wallBracketRepository.getById(id));
    }

//    public ArrayList<Object> saveTelevision(TelevisionInputDto televisionInputDto){
//        ArrayList<Object> info = new ArrayList<>();
//        Television televisionToSave = toTelevision(televisionInputDto);
//        info.add(televisionToSave.getId());
//        info.add(fromTelevision(televisionRepository.save(televisionToSave)));
//        return info;
//    }

    public WallBracketOutputDto updateWallBracket(Long id, WallBracketInputDto wallBracketInputDto){
        Optional<WallBracket> wallBracketFound = wallBracketRepository.findById(id);
        if(wallBracketFound.isEmpty()){
            throw new RecordNotFoundException("Wallbracket not found");
        }
        WallBracket wallBracketToUpdate = toWallBracket(wallBracketInputDto);
        wallBracketToUpdate.setId(id);
        return fromWallBracket(wallBracketRepository.save(wallBracketToUpdate));
    }

    public void deleteWallBracket(Long id){
        Optional<WallBracket> wallBracketFound = wallBracketRepository.findById(id);
        if(wallBracketFound.isEmpty()){
            throw new RecordNotFoundException("Wallbracket not found");
        }
        wallBracketRepository.deleteById(id);
    }
}
