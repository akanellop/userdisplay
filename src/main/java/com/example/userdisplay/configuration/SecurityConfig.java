package com.example.userdisplay.configuration;

import com.example.userdisplay.services.PasswordEncoderTest;
import com.example.userdisplay.services.UserLoginDetailsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //@Autowired
    //private LoginSuccessHandler loginSuccessHandler;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserLoginDetailsImpl();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoderTest();
    }

    @Override
    public void configure(HttpSecurity security) throws Exception{
        security
                .csrf().disable()

                //LOGIN Configuration
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/home", true)
                //.successHandler(loginSuccessHandler)
                .failureUrl("/login?error=true") // kodikas gianni `${RequestParameters.error}`, sto fthl an iparxei ayto p.x. tipose bad credentials <------


                //LOGOUT Configuration
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()

                //AUTHORIZATION AND ROLES
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("login").anonymous()
                .antMatchers("/*").hasAuthority("USER")

                //ERROR HANDLING FOR ACCESS DENIED
                .and()
                .exceptionHandling().accessDeniedPage("/error/deny_error");


    }
}
