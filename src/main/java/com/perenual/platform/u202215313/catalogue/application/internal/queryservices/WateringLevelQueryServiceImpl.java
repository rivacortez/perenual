package com.perenual.platform.u202215313.catalogue.application.internal.queryservices;

import com.perenual.platform.u202215313.catalogue.domain.model.entities.WateringLevel;
import com.perenual.platform.u202215313.catalogue.domain.model.queries.GetAllWateringLevelQuery;
import com.perenual.platform.u202215313.catalogue.domain.services.WateringLevelQueryService;
import com.perenual.platform.u202215313.catalogue.infrastructure.persistence.jpa.repositories.WateringLevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WateringLevelQueryServiceImpl implements WateringLevelQueryService {

    private final WateringLevelRepository wateringLevelRepository;

    public WateringLevelQueryServiceImpl(WateringLevelRepository wateringLevelRepository) {
        this.wateringLevelRepository = wateringLevelRepository;
    }

    @Override
    public List<WateringLevel> handle(GetAllWateringLevelQuery query) {
        return wateringLevelRepository.findAll();
    }
}
