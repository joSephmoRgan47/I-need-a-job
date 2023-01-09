package com.plant_discussion_app.plant_discussion_app.entities;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plant_discussion_app.plant_discussion_app.validation.UserName;

@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    
    @NotEmpty(message = "Username cannot be empty")
    @NotBlank(message = "Username cannot be Blank")
    @Size(min = 5, max = 15, message = "Username must be 5-15 characters long")
    @UserName
    @Column(name = "usernames", nullable = false, length = 15, unique = true)
    private String userName;
    
    @Column(name = "emails", length = 120, unique = true)
    @Email(message = "Please use a valid email address")
    @NotEmpty(message = "Valid email required")
    private String email;
    
    @JsonIgnore //possibly redundant
    @Column(nullable = false)
    private String encryptedPassword;
    
    @JsonIgnore //possibly redundant
    @Column(name = "emailVerificationTokens")
    private String emailVerificationToken;
    
    @Column(nullable = false)
    private Boolean emailVerificationStatus = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPost> userPosts;
    
    public User(){

    }

    public User(String userName, String email, String encryptedPassword, String emailVerificationToken){
        this.userName = userName;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.emailVerificationToken = emailVerificationToken;
        this.emailVerificationStatus = false;
    
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEncryptedPassword() {
        return encryptedPassword;
    }
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }
    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }
    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }
    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

   
    

    
}
