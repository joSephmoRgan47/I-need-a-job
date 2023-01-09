package com.plant_discussion_app.plant_discussion_app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plant_discussion_app.plant_discussion_app.request_response_objects.UserDetailsRequestDto;
import com.plant_discussion_app.plant_discussion_app.request_response_objects.UserDetailsResponseDto;
import java.util.List;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserControllerFunctions userControllerFunctions;

    /* Return value of Get/Post/Put Mappings  = UserDetailsResponseDto { private Long id; private String userName; private String email;} */

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsResponseDto> getUser(@PathVariable Long id){
        return new ResponseEntity<UserDetailsResponseDto>(userControllerFunctions.getUser(id), HttpStatus.OK);
    }
    
    @GetMapping()
    public ResponseEntity<List<UserDetailsResponseDto>> getUsers(){
        return new ResponseEntity<List<UserDetailsResponseDto>>(userControllerFunctions.getAllUsers(), HttpStatus.OK);
    }

    /*  @Valid = String userName, String email, String passWord
    * "Username may not contain uppercase letters or special characters" Refer to /validation/UserNameValidator 
    * Refer to validation/PassWordValidator for password constraints*/
    @PostMapping("/sign-up") 
    public ResponseEntity<UserDetailsResponseDto> createUser(@Valid @RequestBody UserDetailsRequestDto userDetails){
        return new ResponseEntity<UserDetailsResponseDto>(userControllerFunctions.createUser(userDetails), HttpStatus.CREATED);
    }

    /*  @Valid = String userName, String email, String passWord. 
    * "Username may not contain uppercase letters or special characters" Refer to /validation/UserNameValidator 
    * Refer to validation/PassWordValidator for password constraints*/
    @PutMapping("/{id}") 
    public ResponseEntity<UserDetailsResponseDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserDetailsRequestDto userDetails){
        return new ResponseEntity<>(userControllerFunctions.updateUser(id, userDetails), HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id){
        userControllerFunctions.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
}

