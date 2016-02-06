package com.ilshyma.toDoList.Controllers;


import com.ilshyma.toDoList.Model.Entity.Task;
import com.ilshyma.toDoList.Model.Entity.User;
import com.ilshyma.toDoList.Model.web.TaskDTO;
import com.ilshyma.toDoList.repository.TaskRepository;
import com.ilshyma.toDoList.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;

/**
 * Created by user on 16.01.2016.
 */
@Controller

public class TaskController {

    private static final Logger LOGGER = Logger.getLogger(TaskController.class);

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;


//----------Show page----------------

    @RequestMapping(value = "/task/show", method = RequestMethod.GET)
    protected ModelAndView show() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView model = new ModelAndView("tasks/show");
        //LOGGER.info(taskRepository.getAllTasks());
        LOGGER.info("user name  = " + auth.getName());

        System.out.println("tro lo lo ");
        LOGGER.info("user by name  = " + userRepository.findByUserName("admin"));
        LOGGER.info("user by id and auth  = " + userRepository.findByUserName(auth.getName()).getId());
        //LOGGER.info(taskRepository.getTaskListByUser(1));

        model.addObject("tasks", taskRepository.getTaskListByUser((Long) userRepository.findByUserName(auth.getName()).getId()));
        return model;
    }


    //----------Edit page----------------

    @RequestMapping(value = "/task/{taskId}/edit", method = RequestMethod.GET)
    protected ModelAndView editTaskProcessor(@PathVariable final long taskId) throws Exception {
        LOGGER.info("Edit taskId: \"" + taskId + "\"");
        return new ModelAndView("/tasks/edit", new HashMap<String, Object>() {{
            put("task", taskRepository.getTaskById(taskId));
        }});
    }


    @RequestMapping(value = "/task/{taskIdEdit}/edit", method = RequestMethod.POST)
    protected ModelAndView editTaskProcessor(@PathVariable final long taskIdEdit, @ModelAttribute TaskDTO taskDTO) throws Exception {
        Task task = taskRepository.getTaskById(taskIdEdit);
        task.setTitle(taskDTO.getTitle());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());
        task.setStatus(taskDTO.getStatus());
        LOGGER.info("new taskId priority: \"" + taskDTO.getPriority() + "\"");
        LOGGER.info("new taskId dueDate: \"" + taskDTO.getDueDate() + "\"");

        taskRepository.save(task);
        return new ModelAndView("/tasks/show", new HashMap<String, Object>() {{
            put("tasks", taskRepository.getAllTasks());
        }});
    }

    //-----------Delete task------------

    @RequestMapping(value = "/task/{taskIdDelete}/delete", method = RequestMethod.POST)
    protected ModelAndView deleteTask (@PathVariable final long taskIdDelete) throws Exception {
        LOGGER.info("taskIdDelete: \"" + taskIdDelete + "\"");
        taskRepository.remove(taskRepository.getTaskById(taskIdDelete));
        return new ModelAndView("/tasks/show", new HashMap<String, Object>() {{
            put("tasks", taskRepository.getAllTasks());
        }});
    }

    //----------Search page----------------
    @RequestMapping(value = "/task/search", method = RequestMethod.POST)
    protected ModelAndView searchResultPage(@ModelAttribute("title") final String title) throws Exception {
        LOGGER.info("Search word: \"" + title + "\"");
        taskRepository.getTaskByTitle(title);
        LOGGER.info("Search results: \"" + taskRepository.getTaskByTitle(title) + "\"");
        return new ModelAndView("/tasks/search", new HashMap<String, Object>() {{
            put("tasks", taskRepository.getTaskByTitle(title));
            put("searchTitle", title);
        }});
    }

//--------------Create page-----------------

    @RequestMapping(value = "/task/create", method = RequestMethod.GET)
    protected ModelAndView createTaskPage() throws Exception {
        return new ModelAndView("/tasks/create", new HashMap<String, Object>() {{
            put("tasks", taskRepository.getAllTasks());
        }});
    }

    @RequestMapping(value = "/task/create", method = RequestMethod.POST)
    protected ModelAndView createTaskProcessor(@ModelAttribute final Task task) throws Exception {
        taskRepository.save(task);
        return new ModelAndView("tasks/show", new HashMap<String, Object>() {{
            put("task", taskRepository.getTaskById(task.getId()));
            put("tasks", taskRepository.getAllTasks());
        }});
    }
}