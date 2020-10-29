package org.example.kinopoisk_project.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = YearOfBirthValidator.class)
@Documented
public @interface Year {
    String message() default "Year of birth doesn't correct";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
