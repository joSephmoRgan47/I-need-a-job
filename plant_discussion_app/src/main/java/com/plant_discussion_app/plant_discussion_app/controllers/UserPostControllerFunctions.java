package com.plant_discussion_app.plant_discussion_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.plant_discussion_app.plant_discussion_app.entities.UserPost;
import com.plant_discussion_app.plant_discussion_app.services.UserPostSerivceImpl;


@Component
public class UserPostControllerFunctions {
    
    @Autowired
    UserPostSerivceImpl userService;

    public UserPost createUserPost(Long userId, UserPost userPost){
        return userService.createUserPost(userId, userPost);
    }

    public List<UserPost> getAllUserPostsByUserId(Long userId){
        return userService.getAllUserPostsByUserId(userId);
    }

    public UserPost getUserPostById(Long id){
        return userService.getUserPostById(id);
    }

    public void deleteUserPost(Long id){
        userService.deleteUserPost(id);
    }

    public void deletAllUserPostsByUserId(Long UserId){
        userService.deletAllUserPostsByUserId(UserId);
    }

}
