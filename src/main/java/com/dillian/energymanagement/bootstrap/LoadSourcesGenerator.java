package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.LoadSource;
import com.dillian.energymanagement.services.LoadSourceServiceImpl;
import com.dillian.energymanagement.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class LoadSourcesGenerator {

    private final LoadSourceServiceImpl service;

    public List<LoadSource> createWithBasicProperties() {
        LoadSource kolenCentrale = new LoadSource("kolencentrale", "energievoorziening" +
                " waar elektriciteit wordt opgewekt op basis van steenkool", 2.5, 0);
        LoadSource aardgasCentrale = new LoadSource("aardgascentrale", "energievoorziening waar electriciteit " +
                "wordt opgewekt door aardgas te stoken", 2.5, 0);
        LoadSource parkeergarage = new LoadSource(Constants.SOURCE_PARKEERGARAGE_NAME, "parkeergarage alleen bestemd" +
                "voor elektrische voertuigen", 0.5, 1500);
        LoadSource windPark = new LoadSource(Constants.SOURCE_WINDPARK_NAME, "een groot aantal windturbines " +
                "op het vaste land", 1.0, 2000);
        LoadSource windParkOpZee = new LoadSource(Constants.SOURCE_WINDPARKOPZEE_NAME, "een groot aantal windturbines " +
                "geplaatst in de zee", 1.5, 3000);
        LoadSource zonneveld = new LoadSource(Constants.SOURCE_ZONNEWEIDE_NAME, "een groot aantal zonnepanelen bij" +
                " elkaar, gelegen in een weiland", 0.5, 150);
        LoadSource industrieterrein = new LoadSource(Constants.SOURCE_INDUSTRIETERREIN_NAME, "een verzameling van bedrijfspanden en kleine" +
                "industrie op een daarvoor bestemd terrein", 1.0, 2000);
        final List<LoadSource> loadSources = List.of(kolenCentrale, aardgasCentrale, parkeergarage, windPark, windParkOpZee,
                zonneveld, industrieterrein);
        return service.saveAllInternal(loadSources);
    }
}
