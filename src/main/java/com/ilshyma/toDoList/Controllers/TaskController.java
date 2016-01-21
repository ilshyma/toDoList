package com.ilshyma.toDoList.Controllers;


import com.ilshyma.toDoList.Model.Task;
import com.ilshyma.toDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "tasks/show", method = RequestMethod.GET)
    protected ModelAndView show (Principal principal) throws Exception {
        ModelAndView model = new ModelAndView("tasks/show");
        model.addObject("tasks", taskRepository.getAllTasks());
        return model;
    }

    @RequestMapping(value = "tasks/search", method = RequestMethod.GET)
    protected ModelAndView search (Principal principal) throws Exception {
        ModelAndView model = new ModelAndView("tasks/search");
        model.addObject("tasks", taskRepository.getAllTasks());
        return model;
    }

    @RequestMapping(value = "/tasks/search", method = RequestMethod.POST)
    protected ModelAndView searchResultPage(@ModelAttribute final String title) throws Exception {
        taskRepository.getTaskListByTitle(title);
        return new ModelAndView("tasks/search", new HashMap<String, Object>() {{
            put("task", taskRepository.getTaskListByTitle(title));
        }});
    }


    @RequestMapping(value = "/tasks/create", method = RequestMethod.GET)
    protected ModelAndView createTaskPage() throws Exception {
        return new ModelAndView("tasks/create", new HashMap<String, Object>() {{
            put("tasks", taskRepository.getAllTasks());
        }});
    }

    @RequestMapping(value = "/tasks/create", method = RequestMethod.POST)
    protected ModelAndView createTaskProcessor(@ModelAttribute final Task task) throws Exception {
        taskRepository.save(task);
        return new ModelAndView("tasks/show", new HashMap<String, Object>() {{
            put("task", taskRepository.getTaskById(task.getId()));
            put("tasks", taskRepository.getAllTasks());
        }});
    }
}