package com.plant_discussion_app.plant_discussion_app.exceptions;

public class UserPostNotFoundException extends RuntimeException {

    public UserPostNotFoundException(Long id){
        super(String.format("User post with '%d' id was not found", id));
    }
    
}
