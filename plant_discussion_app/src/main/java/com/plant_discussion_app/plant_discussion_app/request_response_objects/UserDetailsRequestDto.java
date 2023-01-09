package com.plant_discussion_app.plant_discussion_app.request_response_objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import com.plant_discussion_app.plant_discussion_app.validation.Password;
import com.plant_discussion_app.plant_discussion_app.validation.UserName;

@Component
public class UserDetailsRequestDto {
    
    @NotEmpty(message = "Username cannot be empty")
    @NotBlank(message = "Username cannot be Blank")
    @Size(min = 5, max = 15, message = "Username must be 5-15 characters long")
    @UserName
    private String userName;

    @NotEmpty(message = "Email cannot be Empty")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotEmpty
    @NotBlank
    @Password
    private String password;

    public UserDetailsRequestDto(){
        
    }

    public UserDetailsRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    
}
