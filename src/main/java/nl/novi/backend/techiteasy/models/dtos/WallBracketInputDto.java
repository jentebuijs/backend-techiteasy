package nl.novi.backend.techiteasy.models.dtos;

import nl.novi.backend.techiteasy.models.entities.WallBracket;

public class WallBracketInputDto {
    public String size;
    public Boolean adjustable;
    public String name;
    public Double price;

    public static WallBracket toWallBracket(WallBracketInputDto wallBracketInputDto){
        WallBracket wallBracket = new WallBracket();
        wallBracket.setSize(wallBracketInputDto.size);
        wallBracket.setAdjustable(wallBracketInputDto.adjustable);
        wallBracket.setName(wallBracketInputDto.name);
        wallBracket.setPrice(wallBracketInputDto.price);
        return wallBracket;
    }
}
