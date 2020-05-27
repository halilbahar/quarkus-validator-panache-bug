package org.acme.entity;

import org.acme.validation.UniqueRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue
    public Long id;

    @UniqueRepository
    public String name;
}
