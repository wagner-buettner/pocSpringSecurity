package com.example.demo.config;

import com.example.demo.business.component.MyAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author wagner on 12/11/17
 */

@Configuration
@EnableWebSecurity
@ImportResource({ "classpath:webSecurityConfig.xml" })
@ComponentScan("com.example.demo")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthProvider myAuthProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthProvider);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .antMatcher("/publicservice").authorizeRequests().anyRequest().permitAll()
        .and()
        .antMatcher("/privateservice").authorizeRequests().anyRequest().authenticated()
        .and()
        .authenticationProvider(myAuthProvider);

    }
}
