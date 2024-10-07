package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.SupplyType;
import com.dillian.energymanagement.entities.SolarPanelSet;
import com.dillian.energymanagement.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SolarPanelSetGenerator {

    private final AccountRepository accountRepository;

    public void fillDataBase() {
        createInitialAccounts();
        createMultiple();
    }

    private void createInitialAccounts() {
        List<SolarPanelSet> initialSolarPanelSets = new ArrayList<>();
        for (long i = 0; i < 100; i++) {
            SolarPanelSet solarPanelSet = new SolarPanelSet();
            solarPanelSet.setSupplyType(SupplyType.OPTIMAL);
            solarPanelSet.setSupplyAmount(1.0);
            initialSolarPanelSets.add(solarPanelSet);
        }
        accountRepository.saveAll(initialSolarPanelSets);
    }

    private void createMultiple() {
        List<SolarPanelSet> solarPanelSets = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            SolarPanelSet solarPanelSet = new SolarPanelSet();
            solarPanelSet.setSupplyAmount(getRandomSupplyAmount());
            categorize(solarPanelSet);
            solarPanelSets.add(solarPanelSet);
        }
        accountRepository.saveAll(solarPanelSets);
    }

    private void categorize(SolarPanelSet solarPanelSet){
        double supplyAmount = solarPanelSet.getSupplyAmount();
        if (supplyAmount >= 0.0 && supplyAmount < 0.9) {
            solarPanelSet.setSupplyType(SupplyType.SHORTAGE);
        } else if (supplyAmount > 0.9 && supplyAmount <= 1.1) {
            solarPanelSet.setSupplyType(SupplyType.OPTIMAL);
        } else if (supplyAmount > 1.1) {
            solarPanelSet.setSupplyType(SupplyType.SURPLUS);
        }
    }

    private double getRandomSupplyAmount() {
        return 0.3 + (Math.random() * 1.7);
    }
}
