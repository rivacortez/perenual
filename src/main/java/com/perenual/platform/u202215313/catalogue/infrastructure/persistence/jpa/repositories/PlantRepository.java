package com.perenual.platform.u202215313.catalogue.infrastructure.persistence.jpa.repositories;

import com.perenual.platform.u202215313.catalogue.domain.model.aggregates.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    boolean existsByName(String name);
}