package com.dillian.energymanagement.generators;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventGenerator {


    public List<Event> createWithBasicProperties() {
        Event addParkeergarage = new Event("Bouw nieuwe parkeergarage", "Een bewonerscollectief" +
                "heeft een vergunning aangevraagd voor de bouw van een nieuwe parkeergarage, bestemd voor 400 elektrische " +
                "voertuigen. De extra netbelasting is %f", null);
        Event addZonneveld = new Event("Aanleg nieuw zonneveld", "Een bewonerscollectief heeft in samenwerking" +
                "met lokale ondernemers een vergunning aangevraagd om een zonneweide aan leggen. De extra netbelasting is %f", null);
        Event addIndustrieterrein = new Event("Bouw nieuw industrieterrein", "Een ondernemerscollectief heeft " +
                "een vergunningen aangevraagd om aan de rand van stad een nieuw gebied voor kleine indusrtie aan te leggen."
                , null);
        Event addWindpark = new Event("Aanleg nieuw windpark", "Een gebied in de gemeente is bestemd" +
                "voor het oprichten van een park windturbines. De Gemeente heeft inmiddels budget weten vrij te maken" +
                "en richt in samenwerking met een grote energieleverancier het boogde park op.",
                null);
        Event addWindparkOpZee = new Event("Aanleg nieuw windpark op zee", "In de Noordzee wordt opnieuw " +
                "een windpark opgericht met honderd windturbines. Een deel van de opgewekte elektriciteit is direct " +
                "bestemd voor {}", null);
        Event addAccountWithSolarPanels = new Event("Aanschaf zonnepanelen bewonersgroep", "Een bewonerscollectief heeft %d" +
                "zonnepanelen laten plaatsen in een deel van hun wijk", null);

        return List.of(addParkeergarage, addWindparkOpZee, addZonneveld, addIndustrieterrein, addWindpark);
    }
}
