package com.appsdeveloperblog.app.ws.shared.dto;

import java.io.Serializable;

// this class is shared between different layers, like: user, database and service layer.
// this class will be used as a data transfer object. Therefore it contains more information 
// our java code will be passing user information in this dto when it needs to send information
// between different layers 
// Dto: Data transfer object
public class UserDto implements Serializable {

    private static final long serialVersionUID = 6835192601898364280L;
    // this is a value from the database; auto incremented id
    private long id;
    // this is a public user id which will be returned back to the mobile application and that Id can be 
    // stored and passed around
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    // this is an unencrypted plain text password that the user has provided 
    private String password;
    // already encrypted password. Because in the database you do not store a clear password
    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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


}
