package com.plant_discussion_app.plant_discussion_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.plant_discussion_app.plant_discussion_app.conversions.UserConversions;
import com.plant_discussion_app.plant_discussion_app.entities.User;
import com.plant_discussion_app.plant_discussion_app.request_response_objects.UserDetailsRequestDto;
import com.plant_discussion_app.plant_discussion_app.request_response_objects.UserDetailsResponseDto;
import com.plant_discussion_app.plant_discussion_app.services.UserServiceImpl;



/*Limits exposure of UserConversions class, refactoring in conversions will impact function but will not require refactoring in UserController 
 * Refer to conversions/UserConversions.java and services/UserServiceImpl.java for implementation
*/

@Component
public class UserControllerFunctions {
    

    @Autowired
    UserServiceImpl userService;


    // Directly retrieves User from database and converts to response object for Controller
    public UserDetailsResponseDto getUser(Long id){
        UserDetailsResponseDto returnValue = UserConversions.userToResponseDto(userService.getUserById(id));
        return returnValue;
    }

    //Receives request object, converts to user entity and creates entry, converts and returns response object
    // Using getUserByEmail at line 37, returning userDetails provides null "id"; retrieving by unique email returns fully constructed object
    public UserDetailsResponseDto createUser(UserDetailsRequestDto userDetails){
        User userCreate = UserConversions.requestDtoToUser(userDetails);
        userService.createUser(userCreate);
        UserDetailsResponseDto returnValue = UserConversions.userToResponseDto(userService.getUserByEmail(userCreate.getEmail()));
        return returnValue;
    }

    //Receives request object, converts to user entity and saves changed fields, converts and returns response object
    public UserDetailsResponseDto updateUser(Long id, UserDetailsRequestDto userDetails){
        User user = UserConversions.extractAndCopy(userService.getUserById(id), userDetails);
        userService.saveUser(user);
        UserDetailsResponseDto returnValue = UserConversions.userToResponseDto(user);
        return returnValue;
    }

    //replicated user service method to reduce Autowired dependencies across layers
    public void deleteUser(Long id){
        userService.deleteUser(id);
    }

    //replicated user service method to reduce Autowired dependencies across layers
    public List<UserDetailsResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }


}
