package nl.novi.backend.techiteasy.models.dtos;

import nl.novi.backend.techiteasy.models.entities.WallBracket;

public class WallBracketOutputDto {
    public Long id;
    public String size;
    public Boolean adjustable;
    public String name;
    public Double price;

    public static WallBracketOutputDto fromWallBracket(WallBracket wallBracket){
        WallBracketOutputDto wallBracketOutputDto = new WallBracketOutputDto();
        wallBracketOutputDto.id = wallBracket.getId();
        wallBracketOutputDto.size = wallBracket.getSize();
        wallBracketOutputDto.adjustable = wallBracket.getAdjustable();
        wallBracketOutputDto.name = wallBracket.getName();
        wallBracketOutputDto.price = wallBracket.getPrice();
        return wallBracketOutputDto;
    }
}
