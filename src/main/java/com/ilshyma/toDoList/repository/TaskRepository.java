package com.ilshyma.toDoList.repository;

import com.ilshyma.toDoList.Model.Entity.Task;
import com.ilshyma.toDoList.Model.Entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by user on 19.01.2016.
 */

@Repository
@Transactional
public class TaskRepository {

    @PersistenceContext
    private EntityManager entityManager;



    public Task getTaskById(final long id) {
        return entityManager.find(Task.class, id);
    }

    public Task update(Task task) {
        return entityManager.merge(task);
    }

    public Task create(final Task task) {
        entityManager.persist(task);
        return task;
    }

    public void save(Task task) {
        if (task.getId() != null && entityManager.find(Task.class, task.getId()) != null) {
            entityManager.merge(task);
        } else {
            entityManager.persist(task);
        }
    }

    public void remove(final Task task) {
        Task t = entityManager.find(Task.class, task.getId());
        entityManager.remove(t);
    }


    public List<Task> getAllTasks() {
        TypedQuery<Task> query = entityManager.createNamedQuery(Task.TASKALL, Task.class);
        return query.getResultList();
    }

    public List<Task> getTaskListByUser(final User user) {
        TypedQuery<Task> query = entityManager.createNamedQuery(Task.TASKBYUSER, Task.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    public List<Task> getTaskByTitle( final String title) {
        TypedQuery<Task> query = entityManager.createNamedQuery(Task.TASKBYTITLE, Task.class);
        query.setParameter(1, "%" + title.toUpperCase() + "%");
        return query.getResultList();
    }
    public List<Task> getTaskByTitleAndUser( final String title, User user) {
        TypedQuery<Task> query = entityManager.createNamedQuery(Task.TASKBYTITLEANDUSER, Task.class);
        query.setParameter(1, "%" + title.toUpperCase() + "%");
        query.setParameter(2, user);
        return query.getResultList();
    }

    public int getCountAllTasks(final User user) {
        TypedQuery<Task> query = entityManager.createNamedQuery(Task.COUNTALLTASKSHOURS, Task.class);
        query.setParameter("user", user);
        return Integer.valueOf(String.valueOf(query.getSingleResult()));
    }

}
