package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {

    Optional<Supervisor> findByLastName(String name);
    List<Supervisor> findAllByLastNameIn(List<String> names);
}
