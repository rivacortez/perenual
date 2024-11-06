package com.perenual.platform.u202215313.catalogue.domain.model.commands;

import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.WateringLevelName;

public record CreateWateringLevelCommand(Long id, WateringLevelName name) {
}
