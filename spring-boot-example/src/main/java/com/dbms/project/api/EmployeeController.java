package com.dbms.project.api;

import com.dbms.project.model.Employee;
import com.dbms.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/employee")
@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseBody
    public void addEmployee(@Valid @NotNull @RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
    }

    @GetMapping
    @ResponseBody
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateEmployee(@PathVariable("id") int id, @Valid @NotNull @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }
}
