package com.dbms.project.service;

import com.dbms.project.dao.SupplierDao;
import com.dbms.project.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierDao supplierDao;
    
    @Autowired
    public SupplierService(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    public int insertSupplier(Supplier supplier) {
        return supplierDao.insertSupplier(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierDao.getAllSuppliers();
    }

    public Supplier getSupplierById(int id) {
        return supplierDao.getSupplierById(id);
    }

    public int deleteSupplier(int id) {
        return supplierDao.deleteSupplier(id);
    }

    public int updateSupplier(int id, Supplier supplier) {
        return supplierDao.updateSupplier(id, supplier);
    }

    public List<Supplier> findSuppliersByContactNo(String contactNo, Supplier supplier) {
        return supplierDao.findSuppliersByContactNo(contactNo);
    }
}
