package com.perenual.platform.u202215313.catalogue.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/v1/plants", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Plants", description = "Plants Endpoints")
public class PlantsController {

}
