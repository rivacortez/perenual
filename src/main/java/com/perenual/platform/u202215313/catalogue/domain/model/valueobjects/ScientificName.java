package com.perenual.platform.u202215313.catalogue.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ScientificName( String nameScientific) {


    public ScientificName() {
        this(null);
    }

    public ScientificName {
        if (nameScientific == null || nameScientific.isBlank()) {
            throw new IllegalArgumentException("NameScientific is required and cannot be blank");
        }

        if (nameScientific.length() >= 150) {
            throw new IllegalArgumentException("NameScientific cannot be longer than 50 characters");
        }


    }

}