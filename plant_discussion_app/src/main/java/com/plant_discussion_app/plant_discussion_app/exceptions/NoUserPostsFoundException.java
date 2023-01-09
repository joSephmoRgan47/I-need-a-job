package com.plant_discussion_app.plant_discussion_app.exceptions;

public class NoUserPostsFoundException extends RuntimeException{

    public NoUserPostsFoundException(Long id){
        super(String.format("User with '%d' id has made no posts", id));
    }
    
}
