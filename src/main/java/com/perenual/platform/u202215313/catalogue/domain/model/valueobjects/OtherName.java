package com.perenual.platform.u202215313.catalogue.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable

public record OtherName(String nameOther) {

    public OtherName() {
        this(null);
    }

    public OtherName {

        if (nameOther.length() >= 360) {
            throw new IllegalArgumentException("NameCommon cannot be longer than 50 characters");
        }
    }
}