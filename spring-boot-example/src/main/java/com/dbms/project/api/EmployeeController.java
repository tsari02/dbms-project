package com.dbms.project.api;

import com.dbms.project.dao.UserDetailsImpl;
import com.dbms.project.model.Employee;
import com.dbms.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.UserDataHandler;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path="/api/employee")
    @ResponseBody
    public void addEmployee(@Valid @NotNull @RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
    }

    @GetMapping(path="/api/employee")
    @ResponseBody
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping(path="/api/employee/{id}/delete")
    @ResponseBody
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping(path="/api/employee/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping(path="/api/employee/{id}/edit")
    @ResponseBody
    public void updateEmployee(@PathVariable("id") int id, @Valid @NotNull @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }

    @GetMapping(path="/profile")
    public String profile(Model model, Authentication authentication) {
        String username = ((UserDetailsImpl)authentication.getPrincipal()).getUsername();
        Employee employee = employeeService.getEmployeeByUsername(username);
        model.addAttribute("employee", employee);
        return "profile";
    }
}
