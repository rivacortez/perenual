package com.perenual.platform.u202215313.catalogue.interfaces.rest.resources;

import java.util.Date;

public record PlantResource(Long id, String namecommon, String namescientific, String imageUrlReference, String nameOther, Long wateringLevelId, Date createdAt, Date updatedAt) {
}