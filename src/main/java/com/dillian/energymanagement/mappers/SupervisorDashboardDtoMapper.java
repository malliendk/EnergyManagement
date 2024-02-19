package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.LocationNumberDto;
import com.dillian.energymanagement.dtos.SupervisorDashboardDto;
import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.entities.Distributor;
import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.repositories.DistributorRespository;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import com.dillian.energymanagement.services.account.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SupervisorDashboardDtoMapper {


    private final SupervisorRepository supervisorRepository;
    private final DistributorRespository distributorRespository;
    private final AccountService accountService;

    public SupervisorDashboardDto mapSupervisorDashboardDto(
            Supervisor supervisor, Distributor distributor) {

        SupervisorDashboardDto supervisorDashboardDto = new SupervisorDashboardDto();
        supervisorDashboardDto.setSupervisorName(supervisor.getName());
        supervisorDashboardDto.setDistributorName(distributor.getName());

        List<LocationNumberDto> locationNumbers = accountService.getAll()
                .stream()
                .filter(account -> account.getSupervisor().getName().equals(supervisor.getName()))
                .collect(Collectors.groupingBy(Account::getLocation))
                .entrySet().stream()
                .map(entry -> new LocationNumberDto(entry.getKey(), entry.getValue().size()))
                .toList();

        supervisorDashboardDto.setLocationsAndAccountNumber(locationNumbers);

        return supervisorDashboardDto;
    }
}
