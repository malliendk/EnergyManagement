package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

    private Long id;
    private String supplyType;
    private double supplyAmount;
    private double production;
}
