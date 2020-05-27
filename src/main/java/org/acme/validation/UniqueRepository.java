package org.acme.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueValidatorRepository.class)
@Documented
public @interface UniqueRepository {
    String message() default "{org.acme.validation.UniqueRepository.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
