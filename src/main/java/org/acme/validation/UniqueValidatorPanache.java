package org.acme.validation;

import org.acme.entity.PersonPanache;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidatorPanache implements ConstraintValidator<UniquePanache, String> {

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        return PersonPanache.count("name", obj) == 0;
    }
}
