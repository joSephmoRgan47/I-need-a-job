package com.plant_discussion_app.plant_discussion_app.validation;

    import jakarta.validation.ConstraintValidator;
    import jakarta.validation.ConstraintValidatorContext;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

public class UserNameValidator implements ConstraintValidator<UserName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("[^a-z0-9 ]");
        Matcher matcher = pattern.matcher(value);
        boolean badCharacters = matcher.find();
        return badCharacters ? false : true;
    }
}
