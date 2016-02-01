package com.ilshyma.toDoList.repository;

import com.ilshyma.toDoList.Model.Entity.Task;
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

    public List<Task> getTaskListByUser(final long userId) {
        TypedQuery<Task> query = entityManager.createNamedQuery(Task.TASKBYUSER, Task.class);
        query.setParameter(1, userId);
        return query.getResultList();
    }

    public List<Task> getAllTasks() {
        TypedQuery<Task> query = entityManager.createNamedQuery(Task.TASKALL, Task.class);
        return query.getResultList();
    }

    public List<Task> getTaskByTitle( final String title) {
        TypedQuery<Task> query = entityManager.createNamedQuery(Task.TASKBYTITLE, Task.class);
        query.setParameter(1, "%" + title.toUpperCase() + "%");
        return query.getResultList();
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



}
