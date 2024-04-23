package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Event;
import com.dillian.energymanagement.entities.LoadSource;
import com.dillian.energymanagement.services.EventServiceImpl;
import com.dillian.energymanagement.services.LoadSourceServiceImpl;
import com.dillian.energymanagement.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventRelationshipSetter {

    private final EventGenerator eventGenerator;
    private final LoadSourcesGenerator loadSourcesGenerator;
    private final EventServiceImpl eventService;
    private final LoadSourceServiceImpl loadSourceService;


    public EventRelationshipSetter(final EventGenerator eventGenerator, final LoadSourcesGenerator loadSourcesGenerator, final EventServiceImpl eventService, final LoadSourceServiceImpl loadSourceService) {
        this.eventGenerator = eventGenerator;
        this.loadSourcesGenerator = loadSourcesGenerator;
        this.eventService = eventService;
        this.loadSourceService = loadSourceService;
    }

    private LoadSource parkeergarage;
    private LoadSource windpark;
    private LoadSource windparkOpZee;
    private LoadSource zonneveld;
    private LoadSource industrieterrein;

    private Event addParkeergarage;
    private Event addZonneveld;
    private Event addWindpark;
    private Event addWindparkOpZee;
    private Event addIndustrieterrein;


    public void initializeAndSetObjects() {
        getLoadsources();
        getEvents();
        addParkeergarage.setLoadSource(parkeergarage);
        setDescriptionWithLoad(addParkeergarage, parkeergarage);
        addWindpark.setLoadSource(windpark);
        setDescriptionWithLoad(addWindpark, windpark);
        addWindparkOpZee.setLoadSource(windparkOpZee);
        setDescriptionWithLoad(addWindparkOpZee, windparkOpZee);
        addZonneveld.setLoadSource(zonneveld);
        setDescriptionWithLoad(addZonneveld, zonneveld);
        addIndustrieterrein.setLoadSource(industrieterrein);
        setDescriptionWithLoad(addIndustrieterrein, industrieterrein);
        final List<Event> eventsToBeSaved = List.of(addParkeergarage, addWindpark, addWindparkOpZee, addZonneveld, addIndustrieterrein);
        eventService.saveAllInternal(eventsToBeSaved);
    }


    private void getEvents() {
        eventGenerator.createWithBasicProperties();
        log.info("sources created");
        addParkeergarage = getEventByName("Bouw nieuwe parkeergarage");
        addZonneveld = getEventByName("Aanleg nieuw zonneveld");
        addIndustrieterrein = getEventByName("Bouw nieuw industrieterrein");
        addWindpark = getEventByName("Aanleg nieuw windpark");
        addWindparkOpZee = getEventByName("Aanleg nieuw windpark op zee");
    }

    private void getLoadsources() {
        loadSourcesGenerator.createWithBasicProperties();
        parkeergarage = findLoadSourceByName(Constants.SOURCE_PARKEERGARAGE_NAME);
        windpark = findLoadSourceByName(Constants.SOURCE_WINDPARK_NAME);
        windparkOpZee = findLoadSourceByName(Constants.SOURCE_WINDPARKOPZEE_NAME);
        zonneveld = findLoadSourceByName(Constants.SOURCE_ZONNEWEIDE_NAME);
        industrieterrein = findLoadSourceByName(Constants.SOURCE_INDUSTRIETERREIN_NAME);
    }


    private LoadSource findLoadSourceByName(String name) {
        return loadSourceService.findByNameInternal(name);
    }

    private Event getEventByName(String name) {
        return eventService.findByNameInternal(name);
    }

    private void setDescriptionWithLoad(Event event, LoadSource source) {
        event.setDescription(String.format(event.getDescription(), source.getLoad()));
    }
}
