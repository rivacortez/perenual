package com.perenual.platform.u202215313.catalogue.domain.services;

import com.perenual.platform.u202215313.catalogue.domain.model.aggregates.Plant;
import com.perenual.platform.u202215313.catalogue.domain.model.commands.CreatePlantsCommand;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PlantCommandService {
    Optional<Plant> handle(CreatePlantsCommand command);
}
