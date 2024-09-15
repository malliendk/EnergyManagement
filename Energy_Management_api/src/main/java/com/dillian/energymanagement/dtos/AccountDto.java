package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

    Long id;
    String supplyType;
    double supplyAmount;
    String localityName;
}
