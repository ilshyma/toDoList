package com.ilshyma.toDoList.Service;

import com.ilshyma.toDoList.Model.Priority;
import com.ilshyma.toDoList.Model.Task;
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
    private UserRepository userRepository;

    public Task getTaskById(final long id) {
        return taskRepository.getTaskById(id);
    }

    public List<Task> getTasksListByUser(final long userId) {return taskRepository.getTaskListByUser(userId); }

    public List<Task> getTaskByTitle(final String title) {
        return taskRepository.getTaskListByTitle(title);
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

            taskRepository.create(
                new Task()
                    .setTitle("Task1")
                    .setDone(true)
                    .setPriority(Priority.LOW)
                    .setDueDate(new Date())
                );

            taskRepository.create(
                    new Task()
                        .setTitle("Task2")
                        .setDone(false)
                        .setPriority(Priority.HIGH)
                        .setDueDate(new Date())
                    );
            taskRepository.create(
                    new Task()
                        .setTitle("Task3")
                        .setDone(true)
                        .setPriority(Priority.MEDIUM)
                        .setDueDate(new Date())
                    );

    }
}


