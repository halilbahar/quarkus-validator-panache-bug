package org.acme.validation;

import org.acme.PersonRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidatorRepository implements ConstraintValidator<UniqueRepository, String> {

    PersonRepository personRepository;

    public void initialize(UniqueRepository constraint) {
        personRepository = new PersonRepository();
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        return personRepository.count("name", obj) == 0;
    }
}
