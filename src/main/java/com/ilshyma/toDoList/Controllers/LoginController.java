package com.ilshyma.toDoList.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by user on 28.01.2016.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/login"})
    protected ModelAndView login(Principal principal) throws Exception {
        ModelAndView model = new ModelAndView("login");
        return model;
    }
}
