package com.perenual.platform.u202215313.catalogue.domain.services;

import com.perenual.platform.u202215313.catalogue.domain.model.commands.CreateWateringLevelCommand;
import com.perenual.platform.u202215313.catalogue.domain.model.entities.WateringLevel;

import java.util.Optional;

public interface WateringLevelCommandService {
    Optional<WateringLevel> handle(CreateWateringLevelCommand command);
}