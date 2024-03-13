package com.dillian.energymanagement.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LocalityDto {

    Long id;
    String name;
    DistributorDto distributorDto;
    List<AccountDto> accountDtos;
}
