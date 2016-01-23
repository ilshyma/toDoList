package com.ilshyma.toDoList.Controllers;


import com.ilshyma.toDoList.Model.Task;
import com.ilshyma.toDoList.Model.web.TaskDTO;
import com.ilshyma.toDoList.repository.TaskRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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


//----------Show page----------------

    @RequestMapping(value = "/tasks/show", method = RequestMethod.GET)
    protected ModelAndView show() throws Exception {
        ModelAndView model = new ModelAndView("tasks/show");
        LOGGER.info(taskRepository.getAllTasks());
        model.addObject("tasks", taskRepository.getAllTasks());
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
        taskRepository.save(task);
        return new ModelAndView("/tasks/show", new HashMap<String, Object>() {{
            put("tasks", taskRepository.getAllTasks());
        }});
    }

    //-----------Delete task------------

    @RequestMapping(value = "/task/{taskIdDelete}/delete", method = RequestMethod.POST)
    protected ModelAndView editProjectPageProcessor(@PathVariable final long taskIdDelete) throws Exception {
        LOGGER.info("taskIdDelete: \"" + taskIdDelete + "\"");
        taskRepository.remove(taskRepository.getTaskById(taskIdDelete));
        return new ModelAndView("/tasks/show", new HashMap<String, Object>() {{
            put("tasks", taskRepository.getAllTasks());
        }});
    }

    //----------Search page----------------
    @RequestMapping(value = "/tasks/search", method = RequestMethod.POST)
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

    @RequestMapping(value = "/tasks/create", method = RequestMethod.GET)
    protected ModelAndView createTaskPage() throws Exception {
        return new ModelAndView("/tasks/create", new HashMap<String, Object>() {{
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