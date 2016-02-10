package com.ilshyma.toDoList.Controllers;


import com.ilshyma.toDoList.Model.Entity.Task;
import com.ilshyma.toDoList.Model.web.TaskDTO;
import com.ilshyma.toDoList.Utility.Reward;
import com.ilshyma.toDoList.Utility.UsdRateServise;
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
        LOGGER.info(" -- show tasks page -- ");
        ModelAndView model = new ModelAndView("tasks/show");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addObject("tasks", taskRepository.getTaskListByUser(userRepository.findByUserName(auth.getName())));
        LOGGER.info(" add tasks OK ");
        model.addObject("usdRate", UsdRateServise.GETUSDRATE());
        LOGGER.info(" add usdRate OK ");
        model.addObject("salary",  new Reward().getCountAllHours(taskRepository.getTaskListByUser(userRepository.findByUserName(auth.getName()))) * UsdRateServise.GETUSDRATE());

        return model;
    }


    //----------Edit page----------------

    @RequestMapping(value = "/task/{taskId}/edit", method = RequestMethod.GET)
    protected ModelAndView editTaskProcessor(@PathVariable final long taskId) throws Exception {
        LOGGER.info(" -- edit tasks page -- ");
        LOGGER.info("edit taskId: \"" + taskId + "\"");
        return new ModelAndView("/tasks/edit", new HashMap<String, Object>() {{
            put("task", taskRepository.getTaskById(taskId));
        }});
    }


    @RequestMapping(value = "/task/{taskIdEdit}/edit", method = RequestMethod.POST)
    protected String editTaskProcessor(@PathVariable final long taskIdEdit, @ModelAttribute TaskDTO taskDTO) throws Exception {
        LOGGER.info("*edit task method*");
        Task task = taskRepository.getTaskById(taskIdEdit);
        task.setTitle(taskDTO.getTitle());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());
        task.setStatus(taskDTO.getStatus());
        taskRepository.save(task);
        return "redirect:/task/show";
    }

    //-----------Delete task------------

    @RequestMapping(value = "/task/{taskIdDelete}/delete", method = RequestMethod.POST)
    protected String deleteTask(@PathVariable final long taskIdDelete) throws Exception {
        LOGGER.info("taskIdDelete: \"" + taskIdDelete + "\"");
        taskRepository.remove(taskRepository.getTaskById(taskIdDelete));
        return "redirect:/task/show";
    }

    //----------Search page (all tasks)----------------
    @RequestMapping(value = "/task/search1", method = RequestMethod.POST)
    protected ModelAndView searchResultPage(@ModelAttribute("title") final String title) throws Exception {
        LOGGER.info("Search word: \"" + title + "\"");
        taskRepository.getTaskByTitle(title);
        LOGGER.info("Search results: \"" + taskRepository.getTaskByTitle(title) + "\"");
        return new ModelAndView("/tasks/search", new HashMap<String, Object>() {{
            put("tasks", taskRepository.getTaskByTitle(title));
            put("searchTitle", title);
        }});
    }
    //----------Search page (by user)----------------
    @RequestMapping(value = "/task/search", method = RequestMethod.POST)
    protected ModelAndView searchResultPageByUser(@ModelAttribute("title") final String title) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        LOGGER.info("Search word: \"" + title + "\"");
            LOGGER.info("Searcher user is: \"" + userRepository.findByUserName(auth.getName()) + "\"");

            LOGGER.info("Search results: \"" + taskRepository.getTaskByTitleAndUser(title, userRepository.findByUserName(auth.getName())) + "\"");

        ModelAndView model = new ModelAndView("/tasks/search");
        model.addObject("tasks", taskRepository.getTaskByTitleAndUser(title, userRepository.findByUserName(auth.getName())));
        model.addObject("searchTitle", title);
        return model;

    }


//--------------Create page-----------------

    @RequestMapping(value = "/task/create", method = RequestMethod.GET)
    protected ModelAndView createTaskPage() throws Exception {

        return new ModelAndView("/tasks/create", new HashMap<String, Object>() {{
            put("tasks", taskRepository.getAllTasks());
        }});
    }

    @RequestMapping(value = "/task/create", method = RequestMethod.POST)
    protected String createTaskProcessor(@ModelAttribute final Task task) throws Exception {
        LOGGER.info("*create task method*");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        task.setUser(userRepository.findByUserName(auth.getName()));
        taskRepository.save(task);
        return "redirect:/task/show";
    }
}