package com.plant_discussion_app.plant_discussion_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plant_discussion_app.plant_discussion_app.entities.User;
import com.plant_discussion_app.plant_discussion_app.exceptions.UserEmailAlreadyExistsException;
import com.plant_discussion_app.plant_discussion_app.exceptions.UserEmailNotFoundException;
import com.plant_discussion_app.plant_discussion_app.exceptions.UserNotFoundException;
import com.plant_discussion_app.plant_discussion_app.exceptions.UserNameAlreadyExistsException;
import com.plant_discussion_app.plant_discussion_app.exceptions.UserNameNotFoundException;
import com.plant_discussion_app.plant_discussion_app.repositories.UserRepository;
import com.plant_discussion_app.plant_discussion_app.request_response_objects.UserDetailsResponseDto;



@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User userDetails) {
        Optional<User> storedUserByEmail = userRepository.findByEmail(userDetails.getEmail());
         if(storedUserByEmail.isPresent()){
             throw new UserEmailAlreadyExistsException(userDetails.getEmail());
         }
         Optional<User> storedUserByUserName = userRepository.findByUserName(userDetails.getUserName());
         if(storedUserByUserName.isPresent()){
             throw new UserNameAlreadyExistsException(userDetails.getUserName());
         }
            userDetails.setEncryptedPassword("test");
            userRepository.save(userDetails);
            return userDetails;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        } else{
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new UserEmailNotFoundException(email);
        }
    
    }

    @Override
    public User getUserByUserName(String userName) {
        Optional<User> user = userRepository.findByUserName(userName);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new UserNameNotFoundException(userName);
        }
    }

    @Override
    public List<UserDetailsResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDetailsResponseDto>usersDto = new ArrayList<>();
            for(User user : users){
                UserDetailsResponseDto userDto = new UserDetailsResponseDto();
                BeanUtils.copyProperties(user, userDto);
                usersDto.add(userDto);
            
        }    
        return usersDto;
    }
    
    public void saveUser(User user){
        userRepository.save(user);
    }

    
}
