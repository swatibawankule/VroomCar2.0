package com.vroomcar.VroomCar.config;

import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }

    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "Rest/VroomCar/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "Rest/VroomCar/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "Rest/VroomCar/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "Rest/VroomCar/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "Rest/VroomCar/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
        
 
    }

    /*@Bean
    public UserDetailsService userDetailsService() {
        //ok for demo
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
        return manager;
    }*/

}
