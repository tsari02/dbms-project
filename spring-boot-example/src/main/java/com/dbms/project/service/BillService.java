package com.dbms.project.service;

import com.dbms.project.dao.BillDao;
import com.dbms.project.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    private final BillDao billDao;

    @Autowired
    public BillService(BillDao billDao) {
        this.billDao = billDao;
    }

    public int insertBill(Bill bill) {
        return billDao.insertBill(bill);
    }

    public List<Bill> getAllBills() {
        return billDao.getAllBills();
    }

    public Bill getBillById(int id) {
        return billDao.getBillById(id);
    }

    public int deleteBill(int id) {
        return billDao.deleteBill(id);
    }

    public int updateBill(int id, Bill bill) {
        return billDao.updateBill(id, bill);
    }
}
