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

public class IndexController {

    @Autowired
    TaskRepository taskRepository;

   /* @RequestMapping(value = {"/project/all"})
    protected ModelAndView indexPage() throws Exception {
        ModelAndView model = new ModelAndView("project/all");
        model.addObject("user", userRepository.getUser(userSession.getUserId()));
        model.addObject("projects", projectRepository.getAllProjects());
        return model;
    }
*/
    @RequestMapping(value = {"/"})
    protected ModelAndView index(Principal principal) throws Exception {
        ModelAndView model = new ModelAndView("base");
        return model;
    }

    @RequestMapping(value = {"/show"})
    protected ModelAndView show (Principal principal) throws Exception {
        ModelAndView model = new ModelAndView("tasks/show");
        model.addObject("tasks", taskRepository.getAllTasks());
        return model;
    }

    @RequestMapping(value = {"/index"})
    protected ModelAndView index2(Principal principal) throws Exception {
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    protected ModelAndView createTaskPage() throws Exception {
        return new ModelAndView("tasks/create", new HashMap<String, Object>() {{
            put("tasks", taskRepository.getAllTasks());
        }});
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    protected ModelAndView createProjectPageProcessor(@ModelAttribute final Task task) throws Exception {
        taskRepository.save(task);
        return new ModelAndView("tasks", new HashMap<String, Object>() {{
            put("task", taskRepository.getTaskById(task.getId()));
            put("tasks", taskRepository.getAllTasks());
        }});
    }
}