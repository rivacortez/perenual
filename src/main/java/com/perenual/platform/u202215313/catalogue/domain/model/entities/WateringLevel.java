package com.perenual.platform.u202215313.catalogue.domain.model.entities;

import com.perenual.platform.u202215313.catalogue.domain.model.aggregates.Plant;
import com.perenual.platform.u202215313.catalogue.domain.model.commands.CreateWateringLevelCommand;
import com.perenual.platform.u202215313.catalogue.domain.model.valueobjects.WateringLevelName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class WateringLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private WateringLevelName name;

    @OneToMany(mappedBy = "wateringLevel", cascade = CascadeType.ALL)
    private List<Plant> plants= new ArrayList<>();

    public WateringLevel() {
        this.name = WateringLevelName.NONE;
    }

    public WateringLevel(WateringLevelName name) {
        this.name = name;
    }

    public WateringLevel(CreateWateringLevelCommand command) {
        this.name = command.name();
    }
}
