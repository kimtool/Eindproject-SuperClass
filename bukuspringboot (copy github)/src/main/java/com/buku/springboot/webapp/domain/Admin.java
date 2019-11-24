/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.springboot.webapp.domain;

import javax.persistence.Entity;

/**
 *
 * @author Kim Tool <kimtool@hotmail.com>
 */
@Entity
public class Admin extends User{
    
    public Admin(String email, String password) {
        super(email, password);
    }
    
}
