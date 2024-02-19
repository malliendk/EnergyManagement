package com.dillian.energymanagement.repositories;

import com.dillian.energymanagement.entities.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributorRespository extends JpaRepository<Distributor, Long> {
}
