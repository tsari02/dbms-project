package com.dbms.project.service;

import com.dbms.project.dao.WarrantyDao;
import com.dbms.project.model.Warranty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyService {
    private final WarrantyDao warrantyDao;

    @Autowired
    public WarrantyService(WarrantyDao warrantyDao) {
        this.warrantyDao = warrantyDao;
    }

    public int insertWarranty(Warranty warranty) {
        return warrantyDao.insertWarranty(warranty);
    }

    public List<Warranty> getAllWarrantys() {
        return warrantyDao.getAllWarrantys();
    }

    public Warranty getWarrantyById(int id) {
        return warrantyDao.getWarrantyById(id);
    }

    public int deleteWarranty(int id) {
        return warrantyDao.deleteWarranty(id);
    }

    public int updateWarranty(int id, Warranty warranty) {
        return warrantyDao.updateWarranty(id, warranty);
    }
}
