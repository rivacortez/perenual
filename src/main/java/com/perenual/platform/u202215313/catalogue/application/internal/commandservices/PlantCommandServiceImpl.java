package com.perenual.platform.u202215313.catalogue.application.internal.commandservices;

import com.perenual.platform.u202215313.catalogue.domain.model.aggregates.Plant;
import com.perenual.platform.u202215313.catalogue.domain.model.commands.CreatePlantsCommand;
import com.perenual.platform.u202215313.catalogue.domain.model.entities.WateringLevel;
import com.perenual.platform.u202215313.catalogue.domain.services.PlantCommandService;
import com.perenual.platform.u202215313.catalogue.infrastructure.persistence.jpa.repositories.PlantRepository;
import com.perenual.platform.u202215313.catalogue.infrastructure.persistence.jpa.repositories.WateringLevelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlantCommandServiceImpl implements PlantCommandService {

    private final PlantRepository plantRepository;
    private final WateringLevelRepository wateringLevelRepository;

    public PlantCommandServiceImpl(PlantRepository plantRepository, WateringLevelRepository wateringLevelRepository) {
        this.plantRepository = plantRepository;
        this.wateringLevelRepository = wateringLevelRepository;
    }

    @Override
    public Optional<Plant> handle(CreatePlantsCommand command) {
        if (plantRepository.existsByNameCommon(command.commonName())) {
            throw new IllegalArgumentException("Plant with Common Name: " + command.commonName() + " already exists");
        }

        if (plantRepository.existsByNameScientific(command.scientificName())) {
            throw new IllegalArgumentException("Plant with Scientific Name: " + command.scientificName() + " already exists");
        }

        if (plantRepository.existsByNameOther(command.otherName())) {
            throw new IllegalArgumentException("Plant with Other Name: " + command.otherName() + " already exists");
        }

        WateringLevel wateringLevel = wateringLevelRepository.findById(command.wateringLevelId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Watering Level ID: " + command.wateringLevelId()));

        var plant = new Plant(command, wateringLevel);
        try {
            plantRepository.save(plant);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving plant: " + e.getMessage());
        }
        return Optional.of(plant);
    }
}