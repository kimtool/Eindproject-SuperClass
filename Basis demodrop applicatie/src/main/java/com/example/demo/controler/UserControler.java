package com.example.demo.controler;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping
public class UserControler {
    @PostMapping("/loginSucces")
    public RedirectView loginSucces(@RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    Model model){
        System.out.println(String.format("/loginSucces with -> username : %s password : %s", username, password));
        return new RedirectView("/profile?login=username");
    }
}
