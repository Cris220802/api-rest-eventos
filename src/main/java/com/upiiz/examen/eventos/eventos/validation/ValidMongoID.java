
package com.upiiz.examen.eventos.eventos.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@jakarta.validation.Constraint(validatedBy = MongoIdValidator.class)

public @interface ValidMongoID {
    String message() default "ID no es un MongoID válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}