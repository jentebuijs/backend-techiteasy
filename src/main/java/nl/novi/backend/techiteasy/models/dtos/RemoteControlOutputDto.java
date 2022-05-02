package nl.novi.backend.techiteasy.models.dtos;

import nl.novi.backend.techiteasy.models.entities.RemoteControl;

public class RemoteControlOutputDto {
    public Long id;
    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public Double price;
    public Integer originalStock;

    public static RemoteControlOutputDto fromRemoteControl(RemoteControl remoteControl){
        RemoteControlOutputDto remoteControlOutputDto = new RemoteControlOutputDto();
        remoteControlOutputDto.id = remoteControl.getId();
        remoteControlOutputDto.compatibleWith = remoteControl.getCompatibleWith();
        remoteControlOutputDto.batteryType = remoteControl.getBatteryType();
        remoteControlOutputDto.name = remoteControl.getName();
        remoteControlOutputDto.brand = remoteControl.getBrand();
        remoteControlOutputDto.price = remoteControl.getPrice();
        remoteControlOutputDto.originalStock = remoteControl.getOriginalStock();
        return remoteControlOutputDto;
    }
}
