package com.perenual.platform.u202215313.catalogue.application.internal.queryservices;

import com.perenual.platform.u202215313.catalogue.domain.model.aggregates.Plant;
import com.perenual.platform.u202215313.catalogue.domain.model.queries.GetAllPlantsQuery;
import com.perenual.platform.u202215313.catalogue.domain.model.queries.GetPlantByIdQuery;
import com.perenual.platform.u202215313.catalogue.domain.services.PlantQueryService;
import com.perenual.platform.u202215313.catalogue.infrastructure.persistence.jpa.repositories.PlantRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PlantQueryServiceImpl implements PlantQueryService {

    private final PlantRepository plantRepository;

    public PlantQueryServiceImpl(PlantRepository plantRepository){
        this.plantRepository = plantRepository;
    }

    @Override
    public List<Plant> handle(GetAllPlantsQuery query) {
        return plantRepository.findAll();
    }

    @Override
    public Optional<Plant> handle(GetPlantByIdQuery query) {
        return plantRepository.findById(query.plantId());
    }
}