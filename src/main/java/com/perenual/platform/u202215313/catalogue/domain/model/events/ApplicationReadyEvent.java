package com.perenual.platform.u202215313.catalogue.domain.model.events;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ApplicationReadyEvent extends ApplicationEvent {

    private final Long wateringLevelId;
    public ApplicationReadyEvent(Object source, Long wateringLevelId) {
        super(source);
        this.wateringLevelId = wateringLevelId;
    }
}