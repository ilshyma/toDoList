package com.ilshyma.toDoList.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by user on 18.01.2016.
 */
@EnableWebMvc
@Configuration
@ComponentScan({
        "com.ilshyma.toDoList.Config",
        "com.ilshyma.toDoList.Controllers",
        "com.ilshyma.toDoList.Model"
})

public class RootConfig {
}
