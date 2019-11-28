package nl.jajaro.auth.auth.configuration;

import nl.jajaro.auth.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(String.format("loadUserByUsername(%s) was called",s));
        UserDetails userDetails = userRepository.findByEmail(s);
        if (userDetails == null) throw new UsernameNotFoundException(String.format("Username[%s] not found",s));
        System.out.println(String.format("return UserDetails for( %s with password %s )was called",userDetails.getUsername(),userDetails.getPassword()));
        return userDetails;
    }

 }
