package com.plant_discussion_app.plant_discussion_app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.plant_discussion_app.plant_discussion_app.entities.UserPost;
import com.plant_discussion_app.plant_discussion_app.exceptions.NoUserPostsFoundException;
import com.plant_discussion_app.plant_discussion_app.exceptions.UserNotFoundException;
import com.plant_discussion_app.plant_discussion_app.exceptions.UserPostNotFoundException;
import com.plant_discussion_app.plant_discussion_app.repositories.UserPostRepository;

@Service
public class UserPostSerivceImpl implements UserPostService{

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserPostRepository userPostRepository;


    @Override
    public UserPost createUserPost(Long userId, UserPost postDetails) {
      try{
        postDetails.setUser(userService.getUserById(userId));
        postDetails.setTimeStamp(LocalDateTime.now());
        userPostRepository.save(postDetails);
      }catch(UserNotFoundException ex){
        throw new UserNotFoundException(userId);
      }
        return postDetails;
    }

    @Override
    public List<UserPost> getAllUserPostsByUserId(Long userId){
        try{
        List<UserPost> userPosts = userPostRepository.findUserPostsByUserId(userId);
        if(userPosts.isEmpty()){
            throw new NoUserPostsFoundException(userId);
        }
            return userPosts;
        
        } catch(UserNotFoundException ex){
            throw new UserNotFoundException(userId);
        }
    }

    @Override
    public UserPost getUserPostById(Long id) {
         Optional<UserPost> userPost = userPostRepository.findById(id);
         if(userPost.isPresent()){
            return userPost.get();
         }else{
            throw new UserPostNotFoundException(id);
         }
    }

    @Override
    public void deleteUserPost(Long id) throws DataIntegrityViolationException{
       userPostRepository.deleteById(id);
        
    }

    @Override
    public void deletAllUserPostsByUserId(Long userId) throws UserNotFoundException, DataIntegrityViolationException {
        try{
        for(UserPost userPost : getAllUserPostsByUserId(userId)){
            userPostRepository.delete(userPost);
        }
        }catch(UserNotFoundException ex){
            throw new UserNotFoundException(userId);
        }
    }

    
    
}
