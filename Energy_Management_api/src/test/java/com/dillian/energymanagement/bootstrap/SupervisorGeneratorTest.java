package com.dillian.energymanagement.bootstrap;


import com.dillian.energymanagement.entities.Supervisor;
import com.dillian.energymanagement.repositories.SupervisorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SupervisorGeneratorTest {

    @InjectMocks
    private SupervisorGenerator testable;

    @Mock
    private SupervisorRepository repository;

    @Test
    void createInitialSupervisors_successful() {
        testable.createInitialSupervisors();

        verify(repository).saveAll(argThat((List<Supervisor> list) ->
            list.size() == 4 && list.stream().allMatch(obj -> obj instanceof Supervisor)
        ));
    }
}
