package nl.novi.backend.techiteasy.models.dtos;

import nl.novi.backend.techiteasy.models.entities.CIModule;

public class CIModuleOutputDto {
    public Long id;
    public String name;
    public String type;
    public Double price;

    public static CIModuleOutputDto fromCIModule(CIModule ciModule){
        CIModuleOutputDto ciModuleOutputDto = new CIModuleOutputDto();
        ciModuleOutputDto.id = ciModule.getId();
        ciModuleOutputDto.name = ciModule.getName();
        ciModuleOutputDto.type = ciModule.getType();
        ciModuleOutputDto.price = ciModule.getPrice();
        return ciModuleOutputDto;
    }
}
