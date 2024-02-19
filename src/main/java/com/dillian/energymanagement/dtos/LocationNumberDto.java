package com.dillian.energymanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LocationNumberDto {

    String location;
    int numberOfAccounts;
}
