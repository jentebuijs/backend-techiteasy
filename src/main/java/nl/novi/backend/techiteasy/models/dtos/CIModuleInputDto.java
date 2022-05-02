package nl.novi.backend.techiteasy.models.dtos;

import nl.novi.backend.techiteasy.models.entities.CIModule;

public class CIModuleInputDto {
    public String name;
    public String type;
    public Double price;

    public static CIModule toCIModule(CIModuleInputDto ciModuleInputDto){
        CIModule ciModule = new CIModule();
        ciModule.setName(ciModuleInputDto.name);
        ciModule.setType(ciModuleInputDto.type);
        ciModule.setPrice(ciModuleInputDto.price);
        return ciModule;
    }
}
