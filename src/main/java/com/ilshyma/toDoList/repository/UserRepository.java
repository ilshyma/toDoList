package com.ilshyma.toDoList.repository;

import com.ilshyma.toDoList.Model.Entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;


@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User newUser(User user) {
        //TODO encode password
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public void save(User user){
        if (user.getId() != null && entityManager.find(User.class, user.getId()) != null) {
            entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
    }

    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional(readOnly = true)
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional(readOnly = true)
    public User findByUserName(String userName) {
        try {
            return entityManager.createNamedQuery(User.FIND_BY_USERNAME, User.class)
                    .setParameter("username", userName)
                    .getSingleResult();
        } catch (PersistenceException e) {
            return null;
        }
    }
}
