/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.springboot.webapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Kim Tool <kimtool@hotmail.com>
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producer extends User{
    private String username;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="producer")
//add @JsonIgnore to prevent infinite looping of serializing when navigating to localhost:8080/demos
    @JsonIgnore
    private List<Demo> demos;
    
    public Producer(){}

    public Producer(String username, String email, String password) {
        super(email, password);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Demo> getDemos() {
        return demos;
    }

    public void setDemos(List<Demo> demos) {
        this.demos = demos;
    }   
    
}
