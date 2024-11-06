package com.perenual.platform.u202215313.catalogue.domain.model.commands;

public record CreatePlantsCommand(String commonName,String scientificName,Long wateringLevelId,String otherName,String defaultImageUrl) {
}
