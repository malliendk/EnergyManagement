package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.SupplyType;
import com.dillian.energymanagement.dtos.SolarPanelSetDto;
import com.dillian.energymanagement.services.SolarPanelSetService;
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
public class SolarPanelSetControllerTest {

    @InjectMocks
    private SolarPanelSetController testable;

    @Mock
    private SolarPanelSetService solarPanelSetService;


    @Test
    void findAll_successful() {
        Long id = 1L;
        double supplyAmount = 1;
        SupplyType supplyType = SupplyType.OPTIMAL;
        Long gameId = 10L;

        SolarPanelSetDto dto = new SolarPanelSetDto();
        dto.setId(id);
        dto.setSupplyAmount(supplyAmount);
        dto.setSupplyType(supplyType.toString());

        List<SolarPanelSetDto> dtoList = List.of(dto);
        when(solarPanelSetService.getAll()).thenReturn(dtoList);

        ResponseEntity<List<SolarPanelSetDto>> response = testable.findAll();

        assertThat(dtoList).isEqualTo(response.getBody());
        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getSupplyAmount()).isEqualTo(supplyAmount);
        assertThat(dto.getSupplyType()).isEqualTo(supplyType.toString());
    }
}
