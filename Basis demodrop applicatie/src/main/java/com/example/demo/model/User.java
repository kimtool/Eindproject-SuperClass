package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.Encoder;
import java.util.Collection;

public class User implements UserDetails {
    private String email;
    private String password;

    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        String password = encoder.encode("secret");
        System.out.println(String.format("%s is dus secret", password));
//        return encoder.encode("secret");
        return password;
    }

    @Override
    public String getUsername() {
        return "user@novi.com";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
