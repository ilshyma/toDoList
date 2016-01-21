package com.ilshyma.toDoList.repository;

import com.ilshyma.toDoList.Model.User;
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

    public User getUserByEmail(final String email) {
        TypedQuery<User> query = entityManager.createNamedQuery("findUserByEmail", User.class);
        query.setParameter("p_email", email);
        List<User> users = query.getResultList();
        return (users != null && !users.isEmpty()) ? users.get(0) : null;
    }

    public boolean login(final String email, final String password) {
        TypedQuery<User> query = entityManager.createNamedQuery("findUserByEmailAndPassword", User.class);
        query.setParameter("p_email", email);
        query.setParameter("p_password", password);
        List<User> users = query.getResultList();
        return (users != null && !users.isEmpty());
    }
}
