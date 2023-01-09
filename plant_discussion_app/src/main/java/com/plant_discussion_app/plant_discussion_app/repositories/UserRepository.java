package com.plant_discussion_app.plant_discussion_app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.plant_discussion_app.plant_discussion_app.entities.User;


public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);
    List<User> findAll();
}
