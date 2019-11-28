package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min=8, max=40)
    @Column(name = "password")
    private String password;
    
    private String isactive;
    private String roles;

    public User() {}

    public User(String name, String email, String password, String isactive, String roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isactive = "1";
        this.roles = "ROLE_USER";
    }

}
