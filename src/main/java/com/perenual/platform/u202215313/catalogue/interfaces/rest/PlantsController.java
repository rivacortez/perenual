package com.perenual.platform.u202215313.catalogue.interfaces.rest;

import com.perenual.platform.u202215313.catalogue.domain.services.PlantCommandService;
import com.perenual.platform.u202215313.catalogue.interfaces.rest.resources.CreatePlantResource;
import com.perenual.platform.u202215313.catalogue.interfaces.rest.resources.PlantResource;
import com.perenual.platform.u202215313.catalogue.interfaces.rest.transform.CreatePlantCommandFromResourceAssembler;
import com.perenual.platform.u202215313.catalogue.interfaces.rest.transform.PlantResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/v1/plants", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Plants", description = "Plants Endpoints")
public class PlantsController {

    private final PlantCommandService plantCommandService;

    public PlantsController(PlantCommandService plantCommandService) {
        this.plantCommandService = plantCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a new plant")
    public ResponseEntity<PlantResource> createPlant(@RequestBody CreatePlantResource resource) {
        var createPlantCommand = CreatePlantCommandFromResourceAssembler.toCommandFromResource(resource);
        var plant = plantCommandService.handle(createPlantCommand);
        if (plant.isEmpty()) return ResponseEntity.badRequest().build();
        var plantResource = PlantResourceFromEntityAssembler.toResourceFromEntity(plant.get());
        return new ResponseEntity<>(plantResource, HttpStatus.CREATED);
    }
}
