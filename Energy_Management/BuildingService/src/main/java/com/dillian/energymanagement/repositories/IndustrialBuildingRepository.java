package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.building.IndustrialBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustrialBuildingRepository extends JpaRepository<IndustrialBuilding, Long> {
}
