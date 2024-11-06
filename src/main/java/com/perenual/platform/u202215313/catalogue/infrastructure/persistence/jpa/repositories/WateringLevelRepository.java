package com.perenual.platform.u202215313.catalogue.infrastructure.persistence.jpa.repositories;

import com.perenual.platform.u202215313.catalogue.domain.model.entities.WateringLevel;
import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.WateringLevelName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface WateringLevelRepository extends JpaRepository<WateringLevel, Long> {
    Optional<WateringLevel> findByName(WateringLevelName name);
}
