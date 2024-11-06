package com.perenual.platform.u202215313.catalogue.domain.model.aggregates;

import com.perenual.platform.u202215313.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class Plant extends AuditableAbstractAggregateRoot<Plant> {


}
