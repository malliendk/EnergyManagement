package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {

    Optional<Locality> findByName(String name);

    @Query("SELECT e FROM Locality e JOIN e.supervisors s WHERE s.lastName = :lastName")
    List<Locality> findAllBySupervisorLastName(@Param("lastName") String lastName);
    List<Locality> findAllByNameIn(List<String> names);
}
