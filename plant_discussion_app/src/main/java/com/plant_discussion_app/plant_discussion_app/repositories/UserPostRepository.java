package com.plant_discussion_app.plant_discussion_app.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.plant_discussion_app.plant_discussion_app.entities.UserPost;

public interface UserPostRepository extends CrudRepository<UserPost, Long>{
    
    List<UserPost> findUserPostsByUserId(Long id);

}
