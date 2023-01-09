package com.plant_discussion_app.plant_discussion_app.services;


import com.plant_discussion_app.plant_discussion_app.entities.User;
import com.plant_discussion_app.plant_discussion_app.request_response_objects.UserDetailsResponseDto;
import java.util.List;



public interface UserService{
    
    User getUserById(Long id);
    User getUserByEmail(String email);
    User getUserByUserName(String userName);
    User createUser(User userDetails);
    List<UserDetailsResponseDto> getAllUsers();
    void deleteUser(Long id);
}
