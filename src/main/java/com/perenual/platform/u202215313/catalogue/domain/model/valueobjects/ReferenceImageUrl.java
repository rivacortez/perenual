package com.perenual.platform.u202215313.catalogue.domain.model.valueobjects;

public record ReferenceImageUrl(String urlImageReference) {

    public ReferenceImageUrl() {
        this(null);
    }

    public ReferenceImageUrl {
        if(urlImageReference == null || urlImageReference.isBlank()) {
            throw new IllegalArgumentException("NameCommon cannot be null");
        }

    }
}