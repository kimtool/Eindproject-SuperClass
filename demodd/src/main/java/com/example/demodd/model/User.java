package com.example.demodd.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "new_user")
public class User{

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private String email;
    private String password;
    private String role;
    private String isactive;

}