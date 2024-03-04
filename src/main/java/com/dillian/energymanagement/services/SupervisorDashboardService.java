package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.AccountsPerLocationDto;
import com.dillian.energymanagement.dtos.SupervisorDashboardDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.services.account.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupervisorDashboardService {


    private final DistributorService distributorService;
    private final AccountService accountService;

    public SupervisorDashboardDto createSupervisorDashboardDto(
            String supervisorName) {

        SupervisorDashboardDto dashboardDto = new SupervisorDashboardDto();
        dashboardDto.setSupervisorName(supervisorName);

        List<AccountsPerLocationDto> accountsPerLocationDtos = accountService.findBySupervisorName(supervisorName)
                .stream()
                .collect(Collectors.groupingBy(Account::getLocation))
                .entrySet()
                .stream()
                .map(entry -> new AccountsPerLocationDto(
                        entry.getKey(),
                        entry.getValue().size(),
                        (int) entry.getValue().stream().filter(account -> account.getSupplyType().equals("shortage"))
                                        .count(),
                        (int) entry.getValue().stream().filter(account -> account.getSupplyType().equals("optimal"))
                                        .count(),
                        (int) entry.getValue().stream().filter(account -> account.getSupplyType().equals("surplus"))
                                .count(),
                        entry.getValue()
                                .stream()
                                .mapToDouble(Account::getSupplyAmount)
                                .average()
                                .orElse(Double.NaN)))
                .toList();
        dashboardDto.setAccountsPerLocationDtos(accountsPerLocationDtos);

        return dashboardDto;
    }
}