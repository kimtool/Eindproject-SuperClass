package com.in28minutes.rest.webservices.WebServices.jwt;

import com.in28minutes.rest.webservices.WebServices.jwt.user.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//UserDetailsService, interface defined inside spring security core framework
//important method: loadUserByUsername, 

@Service
public class JwtUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    //@Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        UserDetails user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Role role : user.getRoles()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }       
        return user;
    }
    
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        System.out.println(String.format("loadUserByUsername(%s) was called",s));
//        UserDetails userDetails = userRepository.findByEmail(s);
//        if (userDetails == null) throw new UsernameNotFoundException(String.format("Username[%s] not found",s));
//        System.out.println(String.format("return UserDetails for( %s with password %s )was called",userDetails.getUsername(),userDetails.getPassword()));
//        return userDetails;
//    }
}
