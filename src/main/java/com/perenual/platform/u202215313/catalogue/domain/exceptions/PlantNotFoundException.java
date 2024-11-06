package com.perenual.platform.u202215313.catalogue.domain.exceptions;

public class PlantNotFoundException extends RuntimeException {
    public PlantNotFoundException(String message) {
        super(message);
    }
}
