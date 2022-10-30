package com.dbms.project.service;

import com.dbms.project.dao.CustomerDao;
import com.dbms.project.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public int insertCustomer(Customer customer) {
        return customerDao.insertCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    public int deleteCustomer(int id) {
        return customerDao.deleteCustomer(id);
    }

    public int updateCustomer(int id, Customer customer) {
        return customerDao.updateCustomer(id, customer);
    }
}
