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

    @RequestMapping(value = {"/"})
    protected ModelAndView index(Principal principal) throws Exception {
        ModelAndView model = new ModelAndView("base");
        return model;
    }

    @RequestMapping(value = {"/index"})
    protected ModelAndView index2(Principal principal) throws Exception {
        ModelAndView model = new ModelAndView("index");
        return model;
    }


}