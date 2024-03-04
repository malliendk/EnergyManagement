package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DistributorRespository extends JpaRepository<Distributor, Long> {

    Optional<Distributor> findBySupervisorName(String name);
}
