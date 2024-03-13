package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {
}
