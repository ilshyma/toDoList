package com.ilshyma.toDoList.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by user on 16.01.2016.
 */
@Controller

public class IndexController {

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

    @RequestMapping(value = {"/index"})
    protected ModelAndView index2(Principal principal) throws Exception {
        ModelAndView model = new ModelAndView("index");
        return model;
    }
}