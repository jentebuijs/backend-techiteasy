package nl.novi.backend.techiteasy.services;

import nl.novi.backend.techiteasy.exceptions.RecordNotFoundException;
import nl.novi.backend.techiteasy.models.dtos.CIModuleInputDto;
import nl.novi.backend.techiteasy.models.dtos.CIModuleOutputDto;
import nl.novi.backend.techiteasy.models.entities.CIModule;
import nl.novi.backend.techiteasy.repositories.CIModuleRepository;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static nl.novi.backend.techiteasy.models.dtos.CIModuleInputDto.toCIModule;
import static nl.novi.backend.techiteasy.models.dtos.CIModuleOutputDto.fromCIModule;

@Service
public class CIModuleService {
    private final CIModuleRepository ciModuleRepository;

    @Autowired
    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CIModuleOutputDto> getCIModules(){
        List<CIModule> cimodules = ciModuleRepository.findAll();
        List<CIModuleOutputDto> ciModuleOutputDtos = new ArrayList<>();
        for (CIModule ciModule : cimodules){
            ciModuleOutputDtos.add(fromCIModule(ciModule));
        }
        return ciModuleOutputDtos;
    }

    public CIModuleOutputDto getCIModule(Long id){
        Optional<CIModule> ciModuleFound = ciModuleRepository.findById(id);
        if(ciModuleFound.isEmpty()){
            throw new RecordNotFoundException("CI-Module not found");
        }
        return fromCIModule(ciModuleRepository.getById(id));
    }

    //    public ArrayList<Object> saveTelevision(TelevisionInputDto televisionInputDto){
//        ArrayList<Object> info = new ArrayList<>();
//        Television televisionToSave = toTelevision(televisionInputDto);
//        info.add(televisionToSave.getId());
//        info.add(fromTelevision(televisionRepository.save(televisionToSave)));
//        return info;
//    }

    public CIModuleOutputDto updateCIModule(Long id, CIModuleInputDto ciModuleInputDto){
    Optional<CIModule> ciModuleFound = ciModuleRepository.findById(id);
    if(ciModuleFound.isEmpty()){
        throw new RecordNotFoundException("CI-Module not found");
    }
    CIModule ciModuleToUpdate = toCIModule(ciModuleInputDto);
    ciModuleToUpdate.setId(id);
    return fromCIModule(ciModuleRepository.save(ciModuleToUpdate));
    }

    public void deleteCIModule(Long id){
        Optional<CIModule> ciModuleFound = ciModuleRepository.findById(id);
        if(ciModuleFound.isEmpty()){
            throw new RecordNotFoundException("CI-Module not found");
        }
        ciModuleRepository.deleteById(id);
    }
}
