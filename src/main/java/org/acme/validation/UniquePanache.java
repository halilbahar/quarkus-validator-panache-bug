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
@Constraint(validatedBy = UniqueValidatorPanache.class)
@Documented
public @interface UniquePanache {
    String message() default "{org.acme.validation.UniquePanache.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
