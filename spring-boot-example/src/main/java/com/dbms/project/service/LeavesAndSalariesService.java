package com.dbms.project.service;

import com.dbms.project.dao.LeavesAndSalariesDao;
import com.dbms.project.model.LeavesAndSalaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeavesAndSalariesService {
    private final LeavesAndSalariesDao leavesAndSalariesDao;
    
    @Autowired
    public LeavesAndSalariesService(LeavesAndSalariesDao leavesAndSalariesDao) {
        this.leavesAndSalariesDao = leavesAndSalariesDao;
    }

    public int insertLeavesAndSalaries(LeavesAndSalaries leavesAndSalaries) {
        return leavesAndSalariesDao.insertLeavesAndSalaries(leavesAndSalaries);
    }

    public List<LeavesAndSalaries> getAllLeavesAndSalaries() {
        return leavesAndSalariesDao.getAllLeavesAndSalaries();
    }

    public LeavesAndSalaries getLeavesAndSalariesById(int id) {
        return leavesAndSalariesDao.getLeavesAndSalariesById(id);
    }

    public int deleteLeavesAndSalaries(int id) {
        return leavesAndSalariesDao.deleteLeavesAndSalaries(id);
    }

    public int updateLeavesAndSalaries(int id, LeavesAndSalaries leavesAndSalaries) {
        return leavesAndSalariesDao.updateLeavesAndSalaries(id, leavesAndSalaries);
    }
}
