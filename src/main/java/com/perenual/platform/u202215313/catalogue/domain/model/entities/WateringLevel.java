package com.perenual.platform.u202215313.catalogue.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
@Table(name = "watering_levels")
public class WateringLevel {
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;


}
