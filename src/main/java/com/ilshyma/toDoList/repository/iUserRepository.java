package com.ilshyma.toDoList.repository;

import com.ilshyma.toDoList.Model.Entity.User;

/**
 * Created by star on 28.01.2016.
 */
public interface iUserRepository {
    User findByUserName(String username);
}
