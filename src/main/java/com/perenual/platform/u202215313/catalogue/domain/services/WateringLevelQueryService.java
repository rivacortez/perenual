package com.perenual.platform.u202215313.catalogue.domain.services;

import com.perenual.platform.u202215313.catalogue.domain.model.entities.WateringLevel;
import com.perenual.platform.u202215313.catalogue.domain.model.queries.GetAllWateringLevelQuery;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface WateringLevelQueryService {
    List<WateringLevel> handle(GetAllWateringLevelQuery query);
}
