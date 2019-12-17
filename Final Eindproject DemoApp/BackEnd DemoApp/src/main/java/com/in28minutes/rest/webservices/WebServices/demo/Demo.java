package com.in28minutes.rest.webservices.WebServices.demo;

import com.in28minutes.rest.webservices.WebServices.jwt.user.User;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

/**
 *
 * @author Gebruiker
 */

@Entity
public class Demo {
     
    @Id         //any entity needs primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //auto generated
    private Long id;    
    
    private String fileName;
    @Size(max = 30)
    private String trackName;
    private String contentType;
//    @Size(max = 30)
//    private String username;
    @Size(max = 255)
    private String description;
    @Lob
    private byte[] data;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "username", nullable = false)
    private User user;
    
    protected Demo(){        
    }

    public Demo(String fileName, String contentType, User user, String description, byte[] data) {
        super();
        this.fileName = fileName;
        this.trackName = trackName;
        this.contentType = contentType;
        this.user = user;
        this.description = description;
        this.data = data;
    } 

    public Demo(String fileName, String contentType, byte[] data) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.data = data;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return user.getUsername();
    }
    
//    public void setUsername(String username) {        
//        this.username = user.getUsername();
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Demo other = (Demo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }   
}