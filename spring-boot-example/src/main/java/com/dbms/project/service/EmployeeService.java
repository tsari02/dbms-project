package com.dbms.project.service;

import com.dbms.project.dao.EmployeeDao;
import com.dbms.project.dao.UserDetailsImpl;
import com.dbms.project.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements UserDetailsService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int insertEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    public int deleteEmployee(int id) {
        return employeeDao.deleteEmployee(id);
    }

    public int updateEmployee(int id, Employee employee) {
        return employeeDao.updateEmployee(id, employee);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeDao.findEmployeeByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(employee);
    }

    public Employee getEmployeeByUsername(String username) {
        return employeeDao.findEmployeeByUsername(username).get();
    }
}
