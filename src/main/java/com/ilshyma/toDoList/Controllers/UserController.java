package com.ilshyma.toDoList.Controllers;

import com.ilshyma.toDoList.Model.Entity.User;
import com.ilshyma.toDoList.Model.web.UserDTO;
import com.ilshyma.toDoList.repository.TaskRepository;
import com.ilshyma.toDoList.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by star on 07.02.2016.
 */
@Controller
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(TaskController.class);

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    protected ModelAndView userCreator() throws Exception {
        ModelAndView model = new ModelAndView("users/create");
        return model;
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    protected String createTaskProcessor(@ModelAttribute final UserDTO userDTO) throws Exception {
        LOGGER.info("*create user*");

        User newUser = new User();
        newUser.setPassword(userDTO.getPassword());
        newUser.setUserName(userDTO.getUserName());
        LOGGER.info("*create user role = *" + userDTO.getRole());
        newUser.setRole(userDTO.getRole());
        userRepository.save(newUser);

        LOGGER.info("*create user success*");
        return "redirect:/task/show";

    }
}
