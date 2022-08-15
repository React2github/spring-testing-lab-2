package com.example.Springlab2.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/bitcoin")
//                .hasAuthority("admin");
        log.trace("tracing message");

        http.authorizeRequests()
                .antMatchers("/bitcoin")
                .authenticated()
                .and()
                .formLogin()
                .and()
                .logout();


        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login();

        log.trace("tracing message");
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        String username = "ab";
        String password = "1234";
        UserDetails thisUser = User.withUsername(username).password(passwordEncoder().encode(password))
                .authorities("admin")
                .build();

        userDetailsManager.createUser(thisUser);

        return userDetailsManager;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
