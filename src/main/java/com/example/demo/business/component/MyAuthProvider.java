package com.example.demo.business.component;

import com.example.demo.business.model.User;
import com.example.demo.business.model.UserAuth;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author wagner on 12/11/17
 */

@Component
public class MyAuthProvider implements AuthenticationProvider{
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = User.builder()
                .birthDate(LocalDate.of(1985, Month.APRIL,15))
                .nome("Wagner")
                .build();

        UserAuth userAuth = UserAuth.builder().company("Penguin").build();

        return new UsernamePasswordAuthenticationToken(user, userAuth);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
