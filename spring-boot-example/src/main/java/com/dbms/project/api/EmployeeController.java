package com.dbms.project.api;

import com.dbms.project.model.Employee;
import com.dbms.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeController(EmployeeService employeeService, PasswordEncoder passwordEncoder) {
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(path="/employee/new")
    public String addEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        System.out.println(employee);
        return "employee-new";
    }

    @PostMapping(path="/employee")
    public String addEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            return "employee-new";
        }
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeService.insertEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping(path="/employee")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "show-employees";
    }

    @PostMapping(path="/api/employee/{id}/delete")
    @ResponseBody
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping(path="/employee/{id}")
    public String getEmployeeById(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee";
    }

    @PostMapping(path="/api/employee/{id}/edit")
    @ResponseBody
    public void updateEmployee(@PathVariable("id") int id, @Valid @NotNull @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }
}
