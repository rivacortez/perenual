package com.perenual.platform.u202215313.catalogue.infrastructure.persistence.jpa.repositories;

import com.perenual.platform.u202215313.catalogue.domain.model.aggregates.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    boolean existsByNameCommon(String nameCommon);
    boolean existsByNameScientific(String nameScientific); // Corrected attribute name
    boolean existsByNameOther(String nameOther);
}