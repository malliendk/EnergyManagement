package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
}
