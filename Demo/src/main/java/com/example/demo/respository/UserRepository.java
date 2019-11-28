package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> { 
//    List<User> findByName(String name); 
//    List<User> findByEmail(String email);
//    void deleteByEmail(String email);
}