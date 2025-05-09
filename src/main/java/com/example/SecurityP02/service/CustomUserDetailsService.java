package com.example.SecurityP02.service;

import com.example.SecurityP02.entity.User;
import com.example.SecurityP02.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

          return new org.springframework.security.core.userdetails.User(
                 user.getUsername(),
                 user.getPassword(),
                 true,
                 true,
                 true,
                 true,
                  user.getRoles()
                         .stream()
                         .map(role-> new SimpleGrantedAuthority(role.getName()))
                         .collect(Collectors.toSet())

         );

    }
}