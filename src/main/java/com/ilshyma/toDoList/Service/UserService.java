package com.ilshyma.toDoList.Service;

import com.ilshyma.toDoList.Model.User;
import com.ilshyma.toDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 19.01.2016.
 */
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(final User user) {
        return userRepository.create(user);
    }
    public void remove(final User user) {
        userRepository.remove(user);
    }

    @Transactional(readOnly = true)
    public User getUserByEmail(final String email) {
        return userRepository.getUserByEmail(email);
    }

    @Transactional(readOnly = true)
    public boolean login(final String email, final String password) {
        return userRepository.login(email, password);
    }


}

