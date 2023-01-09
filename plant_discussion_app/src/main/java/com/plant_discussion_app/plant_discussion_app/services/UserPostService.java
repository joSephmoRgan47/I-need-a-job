package com.plant_discussion_app.plant_discussion_app.services;

import java.util.List;

import com.plant_discussion_app.plant_discussion_app.entities.UserPost;

public interface UserPostService {
    UserPost getUserPostById(Long id);
    UserPost createUserPost(Long userId, UserPost postDetails);
    List<UserPost> getAllUserPostsByUserId(Long userId);
    void deleteUserPost(Long id);
    void deletAllUserPostsByUserId(Long userId);
}
