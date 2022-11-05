package com.dbms.project.api;

import com.dbms.project.model.Bill;
import com.dbms.project.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;



// @RequestMapping("api/bill")
@Controller
public class BillController {
    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping(path="/api/bill")
    @ResponseBody
    public void addBill(@Valid @NotNull @RequestBody Bill bill) {
        billService.insertBill(bill);
    }

    @GetMapping(path="/api/bill")
    @ResponseBody
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @PostMapping(path="/api/bill/{id}/delete")
    @ResponseBody
    public void deleteBill(@Valid @NotNull @PathVariable("id") int id) {
        billService.deleteBill(id);
    }

    @GetMapping(path="/api/bill/{id}")
    @ResponseBody
    public Bill getBillById(@PathVariable("id") int id) {
        return billService.getBillById(id);
    }

    @PostMapping(path="/api/bill/{id}/edit")
    @ResponseBody
    public void updateBill(@PathVariable("id") int id, @Valid @NotNull @RequestBody Bill bill) {
        billService.updateBill(id, bill);
    }
}

