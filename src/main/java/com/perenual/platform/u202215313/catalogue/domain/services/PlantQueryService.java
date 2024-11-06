package com.perenual.platform.u202215313.catalogue.domain.services;


import com.perenual.platform.u202215313.catalogue.domain.model.aggregates.Plant;
import com.perenual.platform.u202215313.catalogue.domain.model.queries.GetAllPlantsQuery;
import com.perenual.platform.u202215313.catalogue.domain.model.queries.GetPlantByIdQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface PlantQueryService  {
    List<Plant> handle(GetAllPlantsQuery query);
    Optional<Plant> handle(GetPlantByIdQuery query);
}
