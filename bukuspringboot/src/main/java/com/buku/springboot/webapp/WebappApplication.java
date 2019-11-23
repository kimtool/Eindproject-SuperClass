package com.buku.springboot.webapp;

import com.buku.springboot.webapp.domain.Demo;
import com.buku.springboot.webapp.domain.DemoRepository;
import com.buku.springboot.webapp.domain.User;
import com.buku.springboot.webapp.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebappApplication {
    
//Inject repository class to use CRUD methods it provides
    @Autowired
    private DemoRepository demoRepository;    
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
            SpringApplication.run(WebappApplication.class, args);
    }

    @Bean
//allows to use additional code before the application has fully started
//Good to add demo data to database
    CommandLineRunner runner(){
        return args -> {
//add user objects and save to database
            User kim = new User("Kim", "", "");
            User pim = new User("Pim", "", "");      
            userRepository.save(kim);
            userRepository.save(pim);
//Save demo data to database
            demoRepository.save(new Demo(kim, "hi", "test"));
            demoRepository.save(new Demo(pim, "hallo", "test"));
            demoRepository.save(new Demo(kim, "meow", "test"));
        };
    }

}
