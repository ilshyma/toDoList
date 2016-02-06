package com.ilshyma.toDoList.Service;

import com.ilshyma.toDoList.Model.Entity.Task;
import com.ilshyma.toDoList.Model.Entity.User;
import com.ilshyma.toDoList.Model.Entity.enums.Priority;
import com.ilshyma.toDoList.Model.Entity.enums.Status;
import com.ilshyma.toDoList.repository.TaskRepository;
import com.ilshyma.toDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 19.01.2016.
 */
@Service
@Transactional(readOnly = true)
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Task getTaskById(final long id) {
        return taskRepository.getTaskById(id);
    }

    public List<Task> getTasksListByUser(final long userId) {
        return taskRepository.getTaskListByUser(userId);
    }

    public List<Task> getTaskByTitle(final String title) {
        return taskRepository.getTaskByTitle(title);
    }


    @Transactional
    public Task create(final Task task) {
        return taskRepository.create(task);
    }

    @Transactional
    public Task update(Task task) {
        return taskRepository.update(task);
    }

    @Transactional
    public void remove(final Task task) {
        taskRepository.remove(task);
    }

    @PostConstruct
    protected void initialize() {


        User admin = new User("admin", "admin", "ROLE_ADMIN");
        userRepository.save(admin);

        User user = new User("user", "123", "ROLE_USER");
        userRepository.save(user);


        taskRepository.create(
                new Task()
                        .setTitle("Create Sessions system")
                        .setStatus(Status.IN_PROGRESS)
                        .setPriority(Priority.LOW)
                        .setDueDate(new Date())
                        .setUser(admin)
        );

        taskRepository.create(
                new Task()
                        .setTitle("Modify Create Page")
                        .setStatus(Status.DONE)
                        .setPriority(Priority.HIGH)
                        .setDueDate(new Date())
                        .setUser(admin)
        );
        taskRepository.create(
                new Task()
                        .setTitle("Create print page")
                        .setStatus(Status.IN_PROGRESS)
                        .setPriority(Priority.MEDIUM)
                        .setDueDate(new Date())
                        .setUser(user)
        );
        taskRepository.create(
                new Task()
                        .setTitle("Create new button \"Create\"")
                        .setStatus(Status.DONE)
                        .setPriority(Priority.MEDIUM)
                        .setDueDate(new Date())
                        .setUser(user)
        );


    }
}


