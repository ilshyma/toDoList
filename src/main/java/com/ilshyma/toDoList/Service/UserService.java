package com.ilshyma.toDoList.Service;

import com.ilshyma.toDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by user on 19.01.2016.
 */
public class UserService /* implements UserDetailsService */{
    @Autowired
    private UserRepository userRepository;
/*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.ilshyma.toDoList.Model.Entity.User user = userRepository.getUserByLogin(username);
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

    private org.springframework.security.core.userdetails.User createUser(com.ilshyma.toDoList.Model.Entity.User user) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), Collections.singleton(createAuthority(user)));
    }

    private GrantedAuthority createAuthority(com.ilshyma.toDoList.Model.Entity.User user) {
        return new SimpleGrantedAuthority(user.getUserRole());
    }
    */
}


