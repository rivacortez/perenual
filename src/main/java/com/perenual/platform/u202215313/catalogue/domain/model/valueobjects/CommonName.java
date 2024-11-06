package com.perenual.platform.u202215313.catalogue.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record CommonName(String nameCommon) {

    public CommonName() {
        this(null);
    }

    public CommonName {
        if (nameCommon == null || nameCommon.isBlank()) {
            throw new IllegalArgumentException("NameCommon is required and cannot be blank");
        }

        if (nameCommon.length() > 50) {
            throw new IllegalArgumentException("NameCommon cannot be longer than 50 characters");
        }
    }
}