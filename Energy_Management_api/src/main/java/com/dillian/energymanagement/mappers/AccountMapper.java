package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountDto toDto(Account account) {
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setSupplyType(account.getSupplyType().toString());
        dto.setSupplyAmount(account.getSupplyAmount());
        dto.setEnergyYield(account.getEnergyYield());
        dto.setGoldYield(account.getEnergyYield());
        dto.setResearchYield(account.getResearchYield());
        dto.setPopYield(account.getPopYield());
        return dto;
    }
}
