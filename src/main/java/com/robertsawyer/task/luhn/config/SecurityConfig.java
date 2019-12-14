package com.robertsawyer.task.luhn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user", "/user/**").hasRole("USER")
                .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
                .antMatchers("/media/**").permitAll()
                .anyRequest().authenticated();
    }
}
