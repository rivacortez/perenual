package com.perenual.platform.u202215313.catalogue.interfaces.rest.transform;


import com.perenual.platform.u202215313.catalogue.domain.model.aggregates.Plant;
import com.perenual.platform.u202215313.catalogue.interfaces.rest.resources.PlantResource;

public class PlantResourceFromEntityAssembler {

    public static PlantResource toResourceFromEntity(Plant entity) {
        return new PlantResource(
                entity.getId(),
                entity.getNameCommon(),
                entity.getNameScientific(),
                entity.getImageUrlReference(),
                entity.getNameOther(),
                entity.getWateringLevel().getId(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}