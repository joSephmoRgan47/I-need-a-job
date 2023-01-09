package com.plant_discussion_app.plant_discussion_app.exceptions;

public class UserEmailAlreadyExistsException extends RuntimeException{

    public UserEmailAlreadyExistsException(String email){
        super(String.format("User email '%s' already exists in our database", email));
    }
    
}
