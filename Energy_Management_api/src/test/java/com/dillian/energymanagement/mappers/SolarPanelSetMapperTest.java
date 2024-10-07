package com.dillian.energymanagement.mappers;

import com.dillian.energymanagement.SupplyType;
import com.dillian.energymanagement.dtos.SolarPanelSetDto;
import com.dillian.energymanagement.entities.SolarPanelSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class SolarPanelSetMapperTest {

    @InjectMocks
    private SolarPanelSetMapper testable;

    @Test
    void toDto() {
        SolarPanelSet solarPanelSet = new SolarPanelSet();
        solarPanelSet.setId(1L);
        solarPanelSet.setSupplyType(SupplyType.OPTIMAL);
        solarPanelSet.setSupplyAmount(1);

        SolarPanelSetDto result = testable.toDto(solarPanelSet);

        assertThat(result).isInstanceOf(SolarPanelSetDto.class);
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(solarPanelSet.getSupplyType()).isEqualTo(SupplyType.OPTIMAL);
        assertThat(solarPanelSet.getSupplyAmount()).isEqualTo(1);
    }
}
