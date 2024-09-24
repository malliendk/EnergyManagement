package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.SupplyType;
import com.dillian.energymanagement.dtos.AccountDto;
import com.dillian.energymanagement.entities.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;

@ExtendWith(MockitoExtension.class)
public class AccountMapperTest {

    @InjectMocks
    private AccountMapper testable;

    @Test
    void toDto() {
        Account account = new Account();
        account.setId(1L);
        account.setSupplyType(SupplyType.OPTIMAL);
        account.setSupplyAmount(1);

        AccountDto result = testable.toDto(account);

        assertThat(result).isInstanceOf(AccountDto.class);
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(account.getSupplyType()).isEqualTo(SupplyType.OPTIMAL);
        assertThat(account.getSupplyAmount()).isEqualTo(1);
    }
}
