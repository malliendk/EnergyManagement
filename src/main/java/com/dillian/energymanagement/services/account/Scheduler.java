package com.dillian.energymanagement.services.account;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.services.supply.SupplyCategorizer;
import com.dillian.energymanagement.services.supply.SupplyOptimizer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@Slf4j
public class Scheduler {

    private final SupplyOptimizer supplyOptimizer;
    private final SupplyCategorizer supplyCategorizer;
    private ScheduledExecutorService schedulerService;
    private List<Account> accountsToBeUpdated;


    public void startOptimzingSupply(List<AccountDto> accounts) {
        long initialDelay = 0;
        long period = 1;

        schedulerService = Executors.newScheduledThreadPool(1);
        schedulerService.scheduleAtFixedRate(() -> {
            try {
                accountsToBeUpdated = supplyOptimizer.updateSupplyAmount(accounts);
                accounts.forEach(supplyCategorizer::categorizeSupply);
                log.info("process started");
            } catch (Exception e) {
                log.info(e.toString());
            }
        }, initialDelay, period, TimeUnit.SECONDS);
    }

    public void stopOptimzingSupply() {
        schedulerService.shutdownNow();
        log.info("process shutdown");
    }
}
