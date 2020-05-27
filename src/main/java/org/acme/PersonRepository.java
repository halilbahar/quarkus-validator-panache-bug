package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Person;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
}
