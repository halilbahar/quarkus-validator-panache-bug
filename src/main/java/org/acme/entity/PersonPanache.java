package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.acme.validation.UniquePanache;

import javax.persistence.Entity;

@Entity
public class PersonPanache extends PanacheEntity {

    @UniquePanache
    public String name;
}
