package nl.novi.backend.techiteasy.models.dtos;

import nl.novi.backend.techiteasy.models.entities.Television;

public class TelevisionOutputDto {
    public Long id;
    public String type;
    public String brand;
    public Double price;
    public Double availableSize;
    public Double refreshRate;
    public String screenType;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean hdr;
    public Boolean bluetooth;
    public Boolean ambiLight;
    public Integer originalStock;
    public Integer sold;

    public static TelevisionOutputDto fromTelevision(Television television){
        TelevisionOutputDto televisionOutputDto = new TelevisionOutputDto();
        televisionOutputDto.id = television.getId();
        televisionOutputDto.type = television.getType();
        televisionOutputDto.brand = television.getBrand();
        televisionOutputDto.price = television.getPrice();
        televisionOutputDto.availableSize = television.getAvailableSize();
        televisionOutputDto.refreshRate = television.getRefreshRate();
        televisionOutputDto.screenType = television.getScreenType();
        televisionOutputDto.screenQuality = television.getScreenQuality();
        televisionOutputDto.smartTv = television.getSmartTv();
        televisionOutputDto.wifi = television.getWifi();
        televisionOutputDto.voiceControl = television.getVoiceControl();
        televisionOutputDto.hdr = television.getHdr();
        televisionOutputDto.bluetooth = television.getBluetooth();
        televisionOutputDto.ambiLight = television.getAmbiLight();
        televisionOutputDto.originalStock = television.getOriginalStock();
        televisionOutputDto.sold = television.getSold();
        return televisionOutputDto;
    }

}
