package com.dbms.project.config;

import com.dbms.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private EmployeeService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                Only enable api routes while developing the application
//                .antMatchers("/api","/api/**").permitAll()
                .antMatchers("/api", "/api/**").denyAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/profile").hasAuthority("EMPLOYEE")
                .antMatchers("/employee","/employee/**").hasAuthority("MANAGER")
                .antMatchers("/supplier", "/supplier/**").hasAuthority("MANAGER")
                .antMatchers("/order/supplier", "/order/supplier/**").hasAuthority("MANAGER")
                .anyRequest().authenticated()
            .and()
                .csrf()
//                Only for testing rest api
//                .disable()
                .ignoringAntMatchers("/login", "/logout")
            .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .permitAll()
            .and()
                .logout().permitAll();
    }
}
