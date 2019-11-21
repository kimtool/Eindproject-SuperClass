package nl.jajaro.auth.auth.controler;

import nl.jajaro.auth.auth.model.User;
import nl.jajaro.auth.auth.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping
public class Controler  {

    @Autowired
    UserService userService;

    @PostMapping("/loginSucces")
    public RedirectView loginSucces(@RequestParam("username") String username ,
                                    @RequestParam("password") String password,
                                    Model model){
        System.out.println(String.format("/loginSucces with -> username : %s password : %s",username,password));
        return new RedirectView(userService.getRedirect());
    }

    @PostMapping("/register")
    public RedirectView register(@RequestParam("username") String username ,
                                    @RequestParam("password") String password,
                                    Model model){
        userService.getUserByLogin(username);
        System.out.println(String.format("/added new user with -> username : %s password : %s",username,password));
        return new RedirectView("/profile");
    }

    @GetMapping("/demo/current")
    public String getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return "Welcome "+currentPrincipalName;
    }

    @GetMapping("/demo/info")
    public UserDetails getCurrentUser(@AuthenticationPrincipal UserDetails userDetails){

//        return userDetails;
//         exception ... failed to lazily initialize a collection of role ....
//
//        // probeer maar eens direct de userDetails te sturen
//        // Je krijgt dan waarschijnlijk een exception en je moet je gaan verdiepen in de "Lazy initialization" van gekoppelde tabellen

        User user = new User(true);
        user.setName(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        return user;
    }

    // De methodes hieronder zijn in de SecurityConfiguration beveiligd met antMatchers.

    @GetMapping("/ant/role/user")
    public String anttestRoleUser(){
        return "hasRole USER";
    }

    @GetMapping("/ant/role/admin")
    public String anttestRoleAdmin(){
        return "hasRole ADMIN";
    }

    @GetMapping("/ant/auth/read")
     public String anttestAuthorityRead(){
        return "hasAuthority READ";
    }
    @GetMapping("/ant/auth/write")
    public String anttestAuthorityWrite(){
        return "hasAuthority WRITE";
    }
    @GetMapping("/ant/auth/delete")
     public String anttestAuthorityDelete(){
        return "hasAuthority DELETE";
    }



    // demo van @Secured en @PreAuthorize
    // deze methodes moeten wel worden geactiveerd!  Zie Class MethodSecurityConfig

    // kijk voor meer mogelijkhedenop:
    // https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html
    // of bv.
    // https://www.baeldung.com/spring-security-method-security


    @GetMapping("/test/role/user")
    @Secured("ROLE_USER")
    public String testRoleUser(){
        return "hasRole USER";
    }
    @GetMapping("/test/role/admin")
    @Secured("ROLE_ADMIN")
    public String testRoleAdmin(){
        return "hasRole ADMIN";
    }

    @GetMapping("/test/auth/read")
    @PreAuthorize("hasAuthority('READ')")
    public String testAuthorityRead(){

        return "hasAuthority READ";
    }
    @GetMapping("/test/auth/write")
    @PreAuthorize("hasAuthority('WRITE')")
    public String testAuthorityWrite(){

        return "hasAuthority WRITE";
    }
    @GetMapping("/test/auth/delete")
    @PreAuthorize("hasAuthority('DEL')")
    public String testAuthorityDelete(){

        return "hasAuthority DELETE";
    }



    @GetMapping("/logouthandler")
    public String logout(){
        SecurityContextHolder.clearContext();

        return "ok logged out!";
    }
}
