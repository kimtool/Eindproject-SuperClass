package nl.jajaro.auth.auth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;


    public DaoAuthenticationProvider authenticationProvider(){
        System.out.println("configure(DaoAuthenticationProvider() was called");
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        System.out.println("configure(AuthenticationManagerBuilder auth) was called");
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("configure(HttpSecurity http) was called");
        http.csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(
                        HttpMethod.GET, "/index.html","/static/**", "/*.js","/*.png", "/*.json", "/*.ico")
                .permitAll()
                .antMatchers("/test/role").hasRole("USER")
                .antMatchers("/test/role/read").hasAuthority("READ_PRIVILEGE")
                .antMatchers("/register").anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/index.html")
                .loginProcessingUrl("/login")
                .successForwardUrl("/loginSucces");
    }
}
