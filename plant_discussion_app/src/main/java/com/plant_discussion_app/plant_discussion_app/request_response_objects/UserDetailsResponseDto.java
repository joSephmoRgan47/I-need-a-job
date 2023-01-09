package com.plant_discussion_app.plant_discussion_app.request_response_objects;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsResponseDto {
    private Long id;
    private String userName;
    private String email;
    private boolean emailVerificationStatus;
    

    public UserDetailsResponseDto(){

    }
    
    public UserDetailsResponseDto(Long id, String userName, String email, boolean emailVerificationStatus) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    

    
    

}
