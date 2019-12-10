package com.example.demodd.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "new_demo")
public class Demo {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private String discription;
    private String date;
    private String producer;

}