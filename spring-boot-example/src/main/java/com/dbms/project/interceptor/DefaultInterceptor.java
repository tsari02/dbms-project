package com.dbms.project.interceptor;

import com.dbms.project.model.Employee;
import com.dbms.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@SessionScope
public class DefaultInterceptor implements HandlerInterceptor {
    @Autowired
    EmployeeService employeeService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && request.getUserPrincipal() != null) {
            String loggedInUserUsername = request.getUserPrincipal().getName();
            Employee employee = employeeService.getEmployeeByUsername(loggedInUserUsername);
            modelAndView.addObject("principal", employee);
        }
    }
}
