package com.plant_discussion_app.plant_discussion_app.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserNameValidator.class)
public @interface UserName {
    
    String message() default "Username may not contain uppercase letters or special characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
