package com.ilshyma.toDoList.repository;

import com.ilshyma.toDoList.Model.Entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by user on 19.01.2016.
 */
@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public User create(final User user) {
        entityManager.persist(user);
        return user;
    }

    public void remove(final User user) {
        entityManager.createNativeQuery("DELETE FROM todo t WHERE t.userId = " + user.getId()).executeUpdate();
        User u = entityManager.find(User.class, user.getId());
        entityManager.remove(u);
    }

    public User getUserByLogin(final String login) {
        TypedQuery<User> query = entityManager.createNamedQuery("getUserByLogin", User.class);
        query.setParameter("p_login", login);
        List<User> users = query.getResultList();
        return (users != null && !users.isEmpty()) ? users.get(0) : null;
    }

    public boolean login(final String login, final String password) {
        TypedQuery<User> query = entityManager.createNamedQuery("getUserByLoginAndPassword", User.class);
        query.setParameter("p_login", login);
        query.setParameter("p_password", password);
        List<User> users = query.getResultList();
        return (users != null && !users.isEmpty());
    }
}
