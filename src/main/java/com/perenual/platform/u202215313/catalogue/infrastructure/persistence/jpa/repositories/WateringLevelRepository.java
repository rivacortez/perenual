package com.perenual.platform.u202215313.catalogue.infrastructure.persistence.jpa.repositories;

import com.perenual.platform.u202215313.catalogue.domain.model.entities.WateringLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface WateringLevelRepository  extends JpaRepository<WateringLevel, Long> {

    WateringLevel findByName(String name);

    WateringLevel findByCreatedAt(Date createdAt);
}
