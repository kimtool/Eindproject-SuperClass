package com.in28minutes.rest.webservices.WebServices.jwt.user;

import com.in28minutes.rest.webservices.WebServices.demo.Demo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Gebruiker
 */

@Entity
public class User implements UserDetails{   
    
    private static final long serialVersionUID = 5155720064139820502L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //auto generated
    private Long id;      
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    
    @OneToMany(
            mappedBy = "User",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Demo> demos = new ArrayList<>();

    public User() {
    }

    public User(String username, String email, String password, String role) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }   

    public List<Demo> getDemos() {
        return demos;
    }

    public void setDemos(List<Demo> demos) {
        this.demos = demos;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
