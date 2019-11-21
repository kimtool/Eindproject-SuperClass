package nl.jajaro.auth.auth;


import nl.jajaro.auth.auth.model.Privilege;
import nl.jajaro.auth.auth.model.User;
import nl.jajaro.auth.auth.model.Role;
import nl.jajaro.auth.auth.repository.PrivilegeRepository;
import nl.jajaro.auth.auth.repository.RoleRepository;
import nl.jajaro.auth.auth.repository.UserRepository;

import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class InitRobbies implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        createUserRol();
        createAdminRol();

        User user = new User();
        user.setPassword(passwordEncoder.encode("secret"));
        user.setEmail("robbie@gmail.com");
        user.setName("Robbie User");

        List<Role> roles = new ArrayList<Role>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);
        userRepository.save(user);

        user = new User();
        user.setPassword(passwordEncoder.encode("secret"));
        user.setEmail("robbie.admin@gmail.com");
        user.setName("Robbie Admin");
        roles.add(roleRepository.findByName("ROLE_ADMIN"));
        user.setRoles(roles);
        userRepository.save(user);

        user = new User();
        user.setPassword(passwordEncoder.encode("secret"));
        user.setEmail("robbie.backoffice@gmail.com");
        user.setName("Robbie backoffice");
        roles.add(roleRepository.findByName("ROLE_BACKOFFICE"));
        user.setRoles(roles);
        userRepository.save(user);

    }

    @Transactional
    protected void createUserRol(){
// Maak de rol USER met de privileges READ and WRITE
        List<Role> roles = new ArrayList<Role>();
        List<Privilege> privileges = new ArrayList<>();

        Role role = new Role("ROLE_USER");
        privileges.add(new Privilege("READ"));
        privileges.add(new Privilege("UPLOAD"));
        role.setPrivileges(privileges);
        privilegeRepository.saveAll(privileges);
        roleRepository.save(role);
    }

    protected void createBackOfficeRol(){
// Maak de rol USER met de privileges READ and WRITE
        List<Role> roles = new ArrayList<Role>();
        List<Privilege> privileges = new ArrayList<>();

        Role role = new Role("ROLE_BACKOFFICE");
        privileges.add(new Privilege("UPDATE"));
        privileges.add(new Privilege("WRITE"));
        privileges.add(new Privilege("LIST"));
        role.setPrivileges(privileges);
        privilegeRepository.saveAll(privileges);
        roleRepository.save(role);
    }

    @Transactional
    protected void createAdminRol(){
// Maak de rol ADMIN met de privileges DELETE
        List<Role> roles = new ArrayList<Role>();
        List<Privilege> privileges = new ArrayList<>();

        Role role = new Role("ROLE_ADMIN");
        privileges.add(new Privilege("DELETE"));
        role.setPrivileges(privileges);
        privilegeRepository.saveAll(privileges);
        roleRepository.save(role);
    }
}

