package nl.jajaro.auth.auth.model;


import nl.jajaro.auth.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByLogin(String login){
        return userRepository.findByEmail(login);
    }

    public String getRedirect(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) return "/admin";
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_BACKOFFICE"))) return "/backoffice";
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) return "/profile";
        return "";
    }


}
