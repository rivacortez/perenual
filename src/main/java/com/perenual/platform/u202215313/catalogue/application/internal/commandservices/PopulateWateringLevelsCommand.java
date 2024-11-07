package com.perenual.platform.u202215313.catalogue.application.internal.commandservices;

import com.perenual.platform.u202215313.catalogue.domain.model.entities.WateringLevel;
import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.WateringLevelName;
import com.perenual.platform.u202215313.catalogue.infrastructure.persistence.jpa.repositories.WateringLevelRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PopulateWateringLevelsCommand {

    private final WateringLevelRepository wateringLevelRepository;

    public PopulateWateringLevelsCommand(WateringLevelRepository wateringLevelRepository) {
        this.wateringLevelRepository = wateringLevelRepository;
    }

    @PostConstruct
    public void handle() {
        List<WateringLevelName> wateringLevels = Arrays.asList(WateringLevelName.values());

        for (WateringLevelName levelName : wateringLevels) {
            if (wateringLevelRepository.findByName(levelName).isEmpty()) {
                WateringLevel wateringLevel = new WateringLevel(levelName);
                wateringLevelRepository.save(wateringLevel);
            }
        }
    }
}