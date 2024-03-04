package com.dillian.energymanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountsPerLocationDto {

    String location;
    int numberOfAccounts;
    int numberOfShortageAccounts;
    int numberOfOptimalAccounts;
    int numberOfSurplusAccounts;
    double supplyMean;
}
