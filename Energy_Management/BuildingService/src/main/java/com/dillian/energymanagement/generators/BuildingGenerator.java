package com.dillian.energymanagement.generators;

import com.dillian.energymanagement.services.BuildingServiceImpl;
import com.dillian.energymanagement.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BuildingGenerator {

    private final BuildingServiceImpl service;

    public List<Building> createWithBasicProperties() {
        Building kolenCentrale = new Building("kolencentrale", "energievoorziening" +
                " waar elektriciteit wordt opgewekt op basis van steenkool", 2.5, 0);
        Building aardgasCentrale = new Building("aardgascentrale", "energievoorziening waar electriciteit " +
                "wordt opgewekt door aardgas te stoken", 2.5, 0);
        Building parkeergarage = new Building(Constants.SOURCE_PARKEERGARAGE_NAME, "parkeergarage bestemd" +
                "voor elektrische voertuigen", 0.5, 1500);
        Building windPark = new Building(Constants.SOURCE_WINDPARK_NAME, "een groot aantal windturbines " +
                "op het vaste land", 1.0, 2000);
        Building windParkOpZee = new Building(Constants.SOURCE_WINDPARKOPZEE_NAME, "een groot aantal windturbines " +
                "geplaatst in de zee", 1.5, 3000);
        Building zonneveld = new Building(Constants.SOURCE_ZONNEWEIDE_NAME, "een groot aantal zonnepanelen bij" +
                " elkaar, gelegen in een weiland", 0.5, 150);
        Building industrieterrein = new Building(Constants.SOURCE_INDUSTRIETERREIN_NAME, "een verzameling van bedrijfspanden en kleine" +
                "industrie op een daarvoor bestemd terrein", 1.0, 2000);
        final List<Building> buildings = List.of(kolenCentrale, aardgasCentrale, parkeergarage, windPark, windParkOpZee,
                zonneveld, industrieterrein);
        return service.saveAllInternal(buildings);
    }
}
