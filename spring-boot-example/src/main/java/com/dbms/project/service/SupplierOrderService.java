package com.dbms.project.service;

import com.dbms.project.dao.SupplierOrderDao;
import com.dbms.project.model.SupplierOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierOrderService {
    private final SupplierOrderDao supplierDao;

    @Autowired
    public SupplierOrderService(SupplierOrderDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    public int insertSupplierOrder(SupplierOrder supplier) {
        return supplierDao.insertSupplierOrder(supplier);
    }

    public List<SupplierOrder> getAllSupplierOrders() {
        return supplierDao.getAllSupplierOrders();
    }

    public SupplierOrder getSupplierOrderById(int id) {
        return supplierDao.getSupplierOrderById(id);
    }

    public int deleteSupplierOrder(int id) {
        return supplierDao.deleteSupplierOrder(id);
    }

    public int updateSupplierOrder(int id, SupplierOrder supplier) {
        return supplierDao.updateSupplierOrder(id, supplier);
    }

    public void completeSupplierOrder(int id) {
        supplierDao.completeSupplierOrder(id);
    }
}
