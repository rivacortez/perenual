package com.perenual.platform.u202215313.catalogue.domain.model.entities;

import com.perenual.platform.u202215313.catalogue.domain.model.aggregates.Plant;
import com.perenual.platform.u202215313.catalogue.domain.model.commands.CreateWateringLevelCommand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class WateringLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "watering_levels", cascade = CascadeType.ALL)
    private List<Plant> plants;

    public WateringLevel(){name="";}

    public WateringLevel(CreateWateringLevelCommand command){
        this.name = command.name();
    }
}
