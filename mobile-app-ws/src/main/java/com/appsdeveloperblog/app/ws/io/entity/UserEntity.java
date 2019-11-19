package com.appsdeveloperblog.app.ws.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// this class stores user details in the database

// The entity(table) name defaults to the name of the class. We can change its name using the name element.
@Entity(name = "users")
public class UserEntity implements Serializable {

    // this is information which will be stored and generated
    private static final long serialVersionUID = 5313493413859894403L;


    // @Id Specifies the primary key of an entity
    @Id
    // the value will be generated and assigned and auto incremented one by one
    @GeneratedValue
    // this id is a primary key and it is going to be auto incremented every time a new
    // record is inserted into our database table
    private long id;

    // the userId will be send back to the mobile application with a response and is safe
    // to pass around the network

    // the userId is a required field. We don't want a record (rij) in our database that
    // doesn't have alphanumeric userId which identifies a record
    @Column(nullable = false)
    private String userId;

    // the length of the varchar is set to 50 characters
    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 120)// put 'unique=true' inside the parameters for no duplicates
    private String email;

    @Column(nullable = false)
    private String encryptedPassword;

    private String emailVerificationToken;

    @Column(nullable = false)
    private Boolean emailVerificationStatus = false;
    
    // getters and setters

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
