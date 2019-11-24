/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.springboot.webapp.domain;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kim Tool <kimtool@hotmail.com>
 */
public interface UserRepository extends CrudRepository <User, Long>{
    
}
