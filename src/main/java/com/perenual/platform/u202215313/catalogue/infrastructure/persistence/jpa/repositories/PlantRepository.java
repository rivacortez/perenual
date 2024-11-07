package com.perenual.platform.u202215313.catalogue.infrastructure.persistence.jpa.repositories;

import com.perenual.platform.u202215313.catalogue.domain.model.aggregates.Plant;
import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.CommonName;
import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.OtherName;
import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.ScientificName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    boolean existsByNameCommon(CommonName nameCommon);
    boolean existsByNameScientific(ScientificName nameScientific);
    boolean existsByNameOther(OtherName nameOther);
}