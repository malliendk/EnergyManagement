package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {

    Optional<Locality> findByName(String name);
    List<Locality> findAllByNameIn(List<String> names);
}
