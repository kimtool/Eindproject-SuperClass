/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.springboot.webapp.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Kim Tool <kimtool@hotmail.com>
 */
@Entity
abstract class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long userid;
//   private String username;
    private String email;
    private String password;
//cascade defines how cascading affects the entities
//ALL means if user is deleted, demos are also deleted
//mappedBy means the demo calss has the owner field, which is the foreign key in this relationship
//    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
//    private List<Demo> demos;
    
    protected User(){}

    protected User(String email, String password) {
        super();
//        this.username = username;
        this.email = email;
        this.password = password;
    }

    private long getUserId() {
        return userid;
    }

    private void setUserId(long userid) {
        this.userid = userid;
    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

    private String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

//    public List<Demo> getDemos() {
//        return demos;
//    }
//
//    public void setDemos(List<Demo> demos) {
//        this.demos = demos;
//    }
    
    
    
    
}
