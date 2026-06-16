package com.blog.example.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.blog.example.entities.User;
import com.blog.example.repositories.UserRepo;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User dbUser = userRepo.findByUsername(username);

        if (dbUser == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
                dbUser.getUsername(),
                dbUser.getPassword(),
                Collections.singletonList(
                        new SimpleGrantedAuthority("ROLE_" + dbUser.getRole())
                )
        );
    }
}