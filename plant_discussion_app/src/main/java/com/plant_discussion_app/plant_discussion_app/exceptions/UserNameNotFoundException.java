package com.plant_discussion_app.plant_discussion_app.exceptions;

public class UserNameNotFoundException extends RuntimeException{

    public UserNameNotFoundException(String userName){
        super(String.format("User with %s username was not found in our database", userName));
    }
}
