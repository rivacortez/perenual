package com.perenual.platform.u202215313.catalogue.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ScientificName(String namescientific) {

    public ScientificName() {
        this(null);
    }

    public ScientificName {
        if (namescientific == null || namescientific.isBlank()) {
            throw new IllegalArgumentException("Scientific name is required and cannot be blank");
        }
    }

    public String nameScientific() {
        return namescientific;
    }
}