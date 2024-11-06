package com.perenual.platform.u202215313.catalogue.interfaces.rest.transform;

import com.perenual.platform.u202215313.catalogue.domain.model.commands.CreatePlantsCommand;
import com.perenual.platform.u202215313.catalogue.interfaces.rest.resources.CreatePlantResource;

public class CreatePlantCommandFromResourceAssembler {

    public static CreatePlantsCommand toCommandFromResource(CreatePlantResource resource) {
        return new CreatePlantsCommand(
                resource.namecommon(),
                resource.namescientific(),
                resource.wateringLevelId(),
                resource.imageUrlReference(),
                resource.nameOther()
        );
    }
}
