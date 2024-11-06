package com.perenual.platform.u202215313.catalogue.application.internal.eventhandlers;

import com.perenual.platform.u202215313.catalogue.application.internal.commandservices.PopulateWateringLevelsCommand;
import com.perenual.platform.u202215313.catalogue.domain.model.events.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyEventHandler {

    private final PopulateWateringLevelsCommand populateWateringLevelsCommandHandler;

    public ApplicationReadyEventHandler(PopulateWateringLevelsCommand populateWateringLevelsCommandHandler) {
        this.populateWateringLevelsCommandHandler = populateWateringLevelsCommandHandler;
    }

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        populateWateringLevelsCommandHandler.handle();
    }
}