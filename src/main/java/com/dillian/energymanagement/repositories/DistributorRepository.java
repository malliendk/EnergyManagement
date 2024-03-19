package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DistributorRepository extends JpaRepository<Distributor, Long> {

    Optional<Distributor> findByName(String name);
    List<Distributor> findAllByNameIn(List<String> names);
}
