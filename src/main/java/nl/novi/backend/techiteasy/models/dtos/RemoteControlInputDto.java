package nl.novi.backend.techiteasy.models.dtos;

import nl.novi.backend.techiteasy.models.entities.RemoteControl;

public class RemoteControlInputDto {
    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public Double price;
    public Integer originalStock;

    public static RemoteControl toRemoteControl(RemoteControlInputDto remoteControlInputDto){
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCompatibleWith(remoteControlInputDto.compatibleWith);
        remoteControl.setBatteryType(remoteControlInputDto.batteryType);
        remoteControl.setName(remoteControlInputDto.name);
        remoteControl.setBrand(remoteControlInputDto.brand);
        remoteControl.setPrice(remoteControlInputDto.price);
        remoteControl.setOriginalStock(remoteControlInputDto.originalStock);
        return remoteControl;
    }
}
