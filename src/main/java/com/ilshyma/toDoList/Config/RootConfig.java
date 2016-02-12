package com.ilshyma.toDoList.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by user on 18.01.2016.
 */
@EnableWebMvc
@EnableScheduling
@EnableWebMvcSecurity
@EnableAsync
@Configuration
@ComponentScan({
        "com.ilshyma.toDoList.Config",
        "com.ilshyma.toDoList.Controllers",
        "com.ilshyma.toDoList.Model",
        "com.ilshyma.toDoList.repository",
        "com.ilshyma.toDoList.Service",
        "com.ilshyma.toDoList.Utility"

})

public class RootConfig {

}
