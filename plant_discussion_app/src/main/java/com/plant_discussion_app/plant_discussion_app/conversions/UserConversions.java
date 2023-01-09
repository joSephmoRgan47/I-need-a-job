package com.plant_discussion_app.plant_discussion_app.conversions;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.plant_discussion_app.plant_discussion_app.entities.User;
import com.plant_discussion_app.plant_discussion_app.request_response_objects.UserDetailsRequestDto;
import com.plant_discussion_app.plant_discussion_app.request_response_objects.UserDetailsResponseDto;
import com.plant_discussion_app.plant_discussion_app.services.UserServiceImpl;

public abstract class UserConversions {

    @Autowired
    UserServiceImpl userService;

    /* Used in UserController for easy conversions from request/response objects to and from User objects
     * Reducing exposure of Bean.Utils.copyProperties() 
     */

    public static UserDetailsResponseDto userToResponseDto(User user){
        UserDetailsResponseDto returnValue = new UserDetailsResponseDto();
        BeanUtils.copyProperties(user, returnValue);
        return returnValue;
    }

    public static User requestDtoToUser(UserDetailsRequestDto userDetails){
        User user = new User();
        BeanUtils.copyProperties(userDetails, user);
        return user;
    }

    /* Used in UserController 'updateUser' in conjunction with 'getUserById' */
    public static User extractAndCopy(User user, UserDetailsRequestDto userDetails){
        BeanUtils.copyProperties(userDetails, user);
        return user;
    }

    
}
