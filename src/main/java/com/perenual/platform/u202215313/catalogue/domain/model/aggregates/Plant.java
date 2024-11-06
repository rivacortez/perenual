package com.perenual.platform.u202215313.catalogue.domain.model.aggregates;

import com.perenual.platform.u202215313.catalogue.domain.model.commands.CreatePlantsCommand;
import com.perenual.platform.u202215313.catalogue.domain.model.entities.WateringLevel;
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
    private CommonName namecommon;

    @Embedded
    private ScientificName namescientific;

    @Embedded
    private ReferenceImageUrl imageUrlReference;

    @Embedded
    private OtherName nameOther;
    @Embedded
    private ReferenceImageUrl urlImageReference;

    @Getter
    @Column(name = "created_at", nullable = false )
    private Date createdAt;


    @Column(name = "updated_at", nullable = false )
    private Date updatedAt;

  public Plant() {}

    public Plant(CreatePlantsCommand command, WateringLevel wateringLevel) {
        this.namecommon = new CommonName(command.commonName());
        this.namescientific = new ScientificName(command.scientificName());
        this.imageUrlReference = new ReferenceImageUrl(command.defaultImageUrl());
        this.nameOther = new OtherName(command.otherName());

        this.wateringLevel = wateringLevel;
        this.createdAt = new Date();
        this.updatedAt = new Date();

    }

    public String getNameCommon() {
        return namecommon.nameCommon();
    }

    public  String getNameScientific() {
        return namescientific.nameScientific();
    }

    public String getImageUrlReference() {
        return imageUrlReference.urlImageReference();
    }

    public String getNameOther() {
        return nameOther.nameOther();
    }

}