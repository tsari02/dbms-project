package com.dbms.project.service;

import com.dbms.project.dao.CustomerOrderDao;
import com.dbms.project.model.CustomerOrder;
import com.dbms.project.model.CustomerOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {
    private final CustomerOrderDao customerOrderDao;
    
    @Autowired
    public CustomerOrderService(CustomerOrderDao customerOrderDao) {
        this.customerOrderDao = customerOrderDao;
    }

    public int insertCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderDao.insertCustomerOrder(customerOrder);
    }

    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderDao.getAllCustomerOrders();
    }

    public CustomerOrder getCustomerOrderById(int id) {
        return customerOrderDao.getCustomerOrderById(id);
    }

    public int deleteCustomerOrder(int id) {
        return customerOrderDao.deleteCustomerOrder(id);
    }

    public int updateCustomerOrder(int id, CustomerOrder customerOrder) {
        return customerOrderDao.updateCustomerOrder(id, customerOrder);
    }
}
