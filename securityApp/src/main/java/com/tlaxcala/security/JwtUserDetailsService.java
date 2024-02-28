package com.tlaxcala.security;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tlaxcala.model.User;
import com.tlaxcala.repo.IUserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final IUserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findOneByUsername(username);

        if (user == null) {
            log.info("User not exists" +  user);
            throw new UsernameNotFoundException(String.format("User not exists", user));
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        user.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getName())); // generamos la lista de roles
        });

        // hacemos una llamada de la referencia del user en el contexto de spring security
        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);

        return ud;
    }
    
}
