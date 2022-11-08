package com.dbms.project.api;

import com.dbms.project.model.Employee;
import com.dbms.project.model.Supplier;
import com.dbms.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    public String deleteEmployee(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
    @GetMapping(path="/employee/{id}")
    public String getEmployeeById(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("months", employeeService.getAllLeavesAndSalaries(id));
        return "employee";
    }

    @PostMapping(path="/employee/{id}/edit")
    public String employeeEditSubmit(@PathVariable("id") int id, @Valid @ModelAttribute("employee") Employee employee, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            return "employee-edit";
        }
        employeeService.updateEmployee(id, employee);
        return "redirect:/employee";
    }

    @GetMapping(path="/employee/{id}/edit")
    public String employeeEditForm(@PathVariable("id") int id, Authentication authentication, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee-edit";
    }
}
