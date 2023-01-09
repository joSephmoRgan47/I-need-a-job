package com.plant_discussion_app.plant_discussion_app.controllers;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plant_discussion_app.plant_discussion_app.entities.UserPost;

@RestController
@RequestMapping("/user-posts")
public class UserPostController {

    @Autowired
    UserPostControllerFunctions userPostControllerFunctions;
 
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<UserPost>> getUserPostsByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(userPostControllerFunctions.getAllUserPostsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{userPostId}")
    public ResponseEntity<UserPost> getUserPostById(@PathVariable Long userPostId){
        return new ResponseEntity<>(userPostControllerFunctions.getUserPostById(userPostId), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<UserPost> createUserPost(@PathVariable Long userId, @Valid @RequestBody UserPost userPost){
        return new ResponseEntity<>(userPostControllerFunctions.createUserPost(userId, userPost), HttpStatus.CREATED);
    }

    @DeleteMapping("/{userPostId}")
    public ResponseEntity<HttpStatus> deleteUserPostById(@PathVariable Long userPostId){
        userPostControllerFunctions.deleteUserPost(userPostId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<HttpStatus> deleteUserPostsByUserId(@PathVariable Long userId){
        userPostControllerFunctions.deletAllUserPostsByUserId(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
 
}
