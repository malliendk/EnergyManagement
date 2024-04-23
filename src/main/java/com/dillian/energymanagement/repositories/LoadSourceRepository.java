package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.LoadSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoadSourceRepository extends JpaRepository<LoadSource, Long> {

    Optional<LoadSource> findByName(String name);
}
