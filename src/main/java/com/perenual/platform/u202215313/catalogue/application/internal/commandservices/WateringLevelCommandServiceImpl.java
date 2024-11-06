package com.perenual.platform.u202215313.catalogue.application.internal.commandservices;

import com.perenual.platform.u202215313.catalogue.domain.model.commands.CreateWateringLevelCommand;
import com.perenual.platform.u202215313.catalogue.domain.model.entities.WateringLevel;
import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.WateringLevelName;
import com.perenual.platform.u202215313.catalogue.domain.services.WateringLevelCommandService;
import com.perenual.platform.u202215313.catalogue.infrastructure.persistence.jpa.repositories.WateringLevelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class WateringLevelCommandServiceImpl implements WateringLevelCommandService {
    private final WateringLevelRepository wateringLevelRepository;

    public WateringLevelCommandServiceImpl(WateringLevelRepository wateringLevelRepository) {
        this.wateringLevelRepository = wateringLevelRepository;
    }

    public Optional<WateringLevel> handle(CreateWateringLevelCommand command) {
        try {
            WateringLevelName.valueOf(command.name().name());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Watering Level: " + command.name().name());
        }

        Optional<WateringLevel> existingWateringLevel = wateringLevelRepository.findByName(command.name());
        if (existingWateringLevel.isPresent()) {
            return existingWateringLevel;
        } else {
            WateringLevel wateringLevel = new WateringLevel(command);
            wateringLevelRepository.save(wateringLevel);
            return Optional.of(wateringLevel);
        }
    }
}