package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.SupplyType;
import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.dtos.AccountRequestDto;
import com.dillian.energymanagement.services.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @InjectMocks
    private AccountController testable;

    @Mock
    private AccountService accountService;


    @Test
    void findAll_successful() {
        Long id = 1L;
        double supplyAmount = 1;
        SupplyType supplyType = SupplyType.OPTIMAL;
        Long gameId = 10L;

        AccountDto dto = new AccountDto();
        dto.setId(id);
        dto.setSupplyAmount(supplyAmount);
        dto.setSupplyType(supplyType.toString());

        List<AccountDto> dtoList = List.of(dto);
        when(accountService.getAll()).thenReturn(dtoList);

        ResponseEntity<List<AccountDto>> response = testable.findAll();

        assertThat(dtoList).isEqualTo(response.getBody());
        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getSupplyAmount()).isEqualTo(supplyAmount);
        assertThat(dto.getSupplyType()).isEqualTo(supplyType.toString());
    }
}
