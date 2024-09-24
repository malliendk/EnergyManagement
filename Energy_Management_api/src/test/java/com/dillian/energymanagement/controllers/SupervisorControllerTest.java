package com.dillian.energymanagement.controllers;

import com.dillian.energymanagement.dtos.SupervisorDto;
import com.dillian.energymanagement.mappers.SupervisorMapper;
import com.dillian.energymanagement.services.SupervisorService;
import com.dillian.energymanagement.utils.ImageCreationService;
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
public class SupervisorControllerTest {

    @InjectMocks
    private SupervisorController testable;

    @Mock
    private SupervisorService service;;

    @Mock
    private ImageCreationService imageCreationService;


    @Test
    void create_successful() {
        SupervisorDto supervisorDto = new SupervisorDto();
        when(service.create(supervisorDto)).thenReturn(supervisorDto);

        ResponseEntity<SupervisorDto> response = testable.create(supervisorDto);

        assertThat(response.getBody()).isEqualTo(supervisorDto);
    }


    @Test
    void findAll_successful() {
        Long id = 1L;
        String firstName = "firstName";
        String lastName = "lastName";
        double popRate = 1;
        double incomeRate = 1;
        double distributionEfficiency = 1;
        SupervisorDto supervisorDto = new SupervisorDto();
        supervisorDto.setId(id);
        supervisorDto.setFirstName(firstName);
        supervisorDto.setLastName(lastName);
        supervisorDto.setIncomeRate(incomeRate);
        supervisorDto.setDistributionEfficiency(distributionEfficiency);
        supervisorDto.setPopRate(popRate);
        List<SupervisorDto> list = List.of(supervisorDto);
        when(service.findAll()).thenReturn(list);

        ResponseEntity<List<SupervisorDto>> result = testable.findAll();

        assertThat(result.getBody()).isEqualTo(list);
    }

    @Test
    void findById_successful() {
        SupervisorDto supervisorDto = new SupervisorDto();
        supervisorDto.setId(1L);
        when(service.findById(1L)).thenReturn(supervisorDto);

        ResponseEntity<SupervisorDto> response = testable.findById(1L);

        assertThat(response.getBody()).isEqualTo(supervisorDto);
    }

    @Test
    void findByLastName_successful() {
        String name = "name";
        SupervisorDto supervisorDto = new SupervisorDto();
        supervisorDto.setLastName(name);
        when(service.findByLastName(name)).thenReturn(supervisorDto);

        ResponseEntity<SupervisorDto> result = testable.findByLastName(name);

        assertThat(result.getBody()).isEqualTo(supervisorDto);
    }

    @Test
    void getImage_successful() {
        byte[] bytes = new byte[]{};
        String imageName = "image";
        when(imageCreationService.getImage(imageName)).thenReturn(bytes);

        ResponseEntity<byte[]> response = testable.getImage(imageName);

        assertThat(response.getBody()).isEqualTo(bytes);
    }
}
