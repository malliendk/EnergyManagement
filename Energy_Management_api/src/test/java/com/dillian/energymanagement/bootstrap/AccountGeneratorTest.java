package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.Account;
import com.dillian.energymanagement.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountGeneratorTest {

    @InjectMocks
    private AccountGenerator testable;

    @Mock
    private AccountRepository accountRepository;


    @Test
    void fillDataBase() {
        List<Account> initialAccounts = new ArrayList<Account>();

        when(accountRepository.saveAll(any(List.class))).thenReturn(initialAccounts);
        when(accountRepository.saveAll(any(List.class))).thenReturn(initialAccounts);

        testable.fillDataBase();

        assertThat(initialAccounts.size()).isEqualTo(100);

    }
}
