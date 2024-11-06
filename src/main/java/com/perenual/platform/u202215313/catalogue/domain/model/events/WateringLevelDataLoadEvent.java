package com.perenual.platform.u202215313.catalogue.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class WateringLevelDataLoadEvent extends ApplicationEvent {
    public WateringLevelDataLoadEvent(Object source) {
        super(source);
    }
}