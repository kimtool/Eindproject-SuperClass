/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buku.springboot.webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Kim Tool <kimtool@hotmail.com>
 */

@Entity
public class Demo {

//@Id defines primary key(long id), @GeneratedValue defines 
//that the ID is automatically generated by the database
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
//The collums names match the class fields by default
//If you want to set a different value or add nullable or length you can use @Column
    //@Column(name="producer", nullable=false, length=200)
//ManyToOne specifies foreign key, fetchtype defines the stategy for fetching data from the database
//LAZY: when user is fetched, all demo's associated with user will be fetched when needed
//EAGER:demo's will be fetched immediately with user
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="producer")
    private Producer producer;
    private String title;
    private String description;
    
    public Demo(){}

    public Demo(Producer producer, String title, String description) {
        super();
  //    this.id = id;     no need because automatically generated
        this.producer = producer;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
}
