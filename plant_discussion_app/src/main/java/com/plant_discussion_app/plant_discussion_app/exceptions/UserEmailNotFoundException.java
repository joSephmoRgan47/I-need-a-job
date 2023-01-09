package com.plant_discussion_app.plant_discussion_app.exceptions;

public class UserEmailNotFoundException extends RuntimeException{
    
    public UserEmailNotFoundException(String email){
        super(String.format("No user with '%s' user email exists in our database", email));
    }
}
