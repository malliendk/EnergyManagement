package com.dillian.energymanagement.services;

import com.dillian.energymanagement.dtos.AccountDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAll();

    List<AccountDto> getForDto(int offset, int limit);
}
