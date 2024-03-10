package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {

    Optional<Supervisor> findByLastName(String name);
    Optional<Supervisor> findByDistributorName(String name);
}
