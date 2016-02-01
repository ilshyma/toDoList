package com.ilshyma.toDoList.Service;

import com.ilshyma.toDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

/**
 * Created by user on 01.02.2016.
 */
public class UserService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.ilshyma.toDoList.Model.Entity.User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return createUser(user);
    }

    public void signin(com.ilshyma.toDoList.Model.Entity.User user) {
        SecurityContextHolder.getContext().setAuthentication(authenticate(user));
    }

    private Authentication authenticate(com.ilshyma.toDoList.Model.Entity.User user) {
        return new UsernamePasswordAuthenticationToken(createUser(user), null, Collections.singleton(createAuthority(user)));
    }

    private User createUser(com.ilshyma.toDoList.Model.Entity.User user) {
        return new User(user.getUserName(), user.getPassword(), Collections.singleton(createAuthority(user)));
    }

    private GrantedAuthority createAuthority(com.ilshyma.toDoList.Model.Entity.User user) {
        return new SimpleGrantedAuthority(user.getRole());
    }
}
