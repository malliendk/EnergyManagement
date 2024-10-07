package com.dillian.energymanagement.bootstrap;

import com.dillian.energymanagement.entities.SolarPanelSet;
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
public class SolarPanelSetGeneratorTest {

    @InjectMocks
    private SolarPanelSetGenerator testable;

    @Mock
    private AccountRepository accountRepository;


    @Test
    void fillDataBase() {
        List<SolarPanelSet> initialSolarPanelSets = new ArrayList<SolarPanelSet>();

        when(accountRepository.saveAll(any(List.class))).thenReturn(initialSolarPanelSets);
        when(accountRepository.saveAll(any(List.class))).thenReturn(initialSolarPanelSets);

        testable.fillDataBase();

        assertThat(initialSolarPanelSets.size()).isEqualTo(100);

    }
}
