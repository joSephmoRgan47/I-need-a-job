package com.plant_discussion_app.plant_discussion_app.exceptions;

public class UserNotFoundException extends RuntimeException{

    
    
    public UserNotFoundException(Long id){
        super(String.format("The user id '%d' does not exist in our database", id));
    }
  
  
}
