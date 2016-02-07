package com.ilshyma.toDoList.Config;

import com.ilshyma.toDoList.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by user on 28.01.2016.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                    .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/resources/**").permitAll()
                    .antMatchers("/login").permitAll()
                .antMatchers("/task/delete/**").hasRole("ADMIN")
                .antMatchers("/task/**").hasAnyRole("ADMIN", "USER")

                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                    .permitAll()
                        .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                    .permitAll();
    /*
    public void configureGlobal(AuthenticationManagerBuilder  auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                csrf().disable().
                authorizeRequests()
                .antMatchers("/**").access("hasRole('ROLE_ADMIN')")
                .and().formLogin();

    }
*/
    }


    @Bean
    public UserService userService() {
        return new UserService();
    }
}


