package com.perenual.platform.u202215313.catalogue.domain.model.aggregates;

import com.perenual.platform.u202215313.catalogue.domain.model.commands.CreatePlantsCommand;
import com.perenual.platform.u202215313.catalogue.domain.model.entities.WateringLevel;
import com.perenual.platform.u202215313.catalogue.domain.model.events.ApplicationReadyEvent;
import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.CommonName;
import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.OtherName;
import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.ReferenceImageUrl;
import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.ScientificName;
import com.perenual.platform.u202215313.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Plant extends AuditableAbstractAggregateRoot<Plant> {
    @ManyToOne
    @JoinColumn(nullable = false, name = "wateringLevel_id")
    private WateringLevel wateringLevel;

    @Embedded
    private CommonName nameCommon;

    @Embedded
    private ScientificName nameScientific;

    @Embedded
    private ReferenceImageUrl imageUrlReference;

    @Embedded
    private OtherName nameOther;

    @Getter
    @Column(name = "created_at", nullable = false )
    private Date createdAt;

    @Column(name = "updated_at", nullable = false )
    private Date updatedAt;

    public Plant() {}

    public Plant(CreatePlantsCommand command, WateringLevel wateringLevel) {
        if (command == null || wateringLevel == null) {
            throw new IllegalArgumentException("Command and WateringLevel cannot be null");
        }
        this.nameCommon = new CommonName(command.commonName());
        this.nameScientific = new ScientificName(command.scientificName());
        this.imageUrlReference = new ReferenceImageUrl(command.defaultImageUrl());
        this.nameOther = new OtherName(command.otherName());
        this.wateringLevel = wateringLevel;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.registerEvent(new ApplicationReadyEvent(this, this.wateringLevel.getId()));
    }


    public String getNameCommon() {
        return nameCommon.nameCommon();
    }

    public String getNameScientific() {
        return nameScientific.nameScientific();
    }

    public String getImageUrlReference() {
        return imageUrlReference.urlImageReference();
    }

    public String getNameOther() {
        return nameOther.nameOther();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}