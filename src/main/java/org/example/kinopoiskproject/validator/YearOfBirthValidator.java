package org.example.kinopoiskproject.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YearOfBirthValidator implements ConstraintValidator<Year, Integer> {
    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext context) {

        return year > 1900 && year < 2020;
    }
}
