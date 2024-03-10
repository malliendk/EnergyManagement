package com.dillian.energymanagement.dtos;

import com.dillian.energymanagement.entities.Distributor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

    Long id;
    String name;
    String location;
    String supplyType;
    double supplyAmount;
    DistributorDto distributor;
    SupervisorDto supervisor;

}
