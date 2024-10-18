package com.upiiz.examen.eventos.eventos.validation;
import org.bson.types.ObjectId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class MongoIdValidator implements ConstraintValidator<ValidMongoID, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Verificar si el valor no es nulo y si es un ObjectId válido
        return value != null && ObjectId.isValid(value);
    }
}