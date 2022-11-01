package com.dbms.project.api;

import com.dbms.project.model.Bill;
import com.dbms.project.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/bill")
@Controller
public class BillController {
    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    @ResponseBody
    public void addBill(@RequestBody Bill bill) {
        billService.insertBill(bill);
    }

    @GetMapping
    @ResponseBody
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteBill(@PathVariable("id") int id) {
        billService.deleteBill(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public Bill getBillById(@PathVariable("id") int id) {
        return billService.getBillById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateBill(@PathVariable("id") int id, @RequestBody Bill bill) {
        billService.updateBill(id, bill);
    }
}

