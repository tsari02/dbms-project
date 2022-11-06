package com.dbms.project.api;

import com.dbms.project.model.Employee;
import com.dbms.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path="/api/employee")
    @ResponseBody
    public Employee addEmployee(@Valid @NotNull @RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
        return employee;
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

    @GetMapping(path="/api/employee/{id}")
    @ResponseBody
    public String getEmployeeById(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "profile";
    }

    @PostMapping(path="/api/employee/{id}/edit")
    @ResponseBody
    public void updateEmployee(@PathVariable("id") int id, @Valid @NotNull @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }

    @GetMapping(path="/profile")
    public String profile() {
        return "profile";
    }

    @PostMapping(path = "/profile/edit")
    public String profileEditSubmit(@Valid @ModelAttribute("profile") Employee profile, Authentication authentication, RedirectAttributes redirectAttributes) {
        employeeService.updateEmployee(profile.getId(), profile);
        return "redirect:/profile";
    }

    @GetMapping(path="/profile/edit")
    public String profileEditForm(Authentication authentication, Model model) {
//        model.addAttribute("profile", ((Employee)(authentication.getPrincipal())));
        return "profile-edit";
    }

    @GetMapping(path="/employee/new")
    public String addEmployeeForm() {
        return "employee-new";
    }
}
