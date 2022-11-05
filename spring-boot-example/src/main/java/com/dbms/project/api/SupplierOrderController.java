package com.dbms.project.api;

import com.dbms.project.model.SupplierOrder;
import com.dbms.project.service.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

// @RequestMapping("api/order/supplier")
@Controller
public class SupplierOrderController {
    private final SupplierOrderService supplierOrderService;

    @Autowired
    public SupplierOrderController(SupplierOrderService supplierOrderService) {
        this.supplierOrderService = supplierOrderService;
    }

    @PostMapping(path="/api/order/supplier")
    @ResponseBody
    public void addSupplierOrder(@Valid @NotNull @RequestBody SupplierOrder supplierOrder) {
        supplierOrderService.insertSupplierOrder(supplierOrder);
    }

    @GetMapping(path="/api/order/supplier")
    @ResponseBody
    public List<SupplierOrder> getAllSupplierOrders() {
        return supplierOrderService.getAllSupplierOrders();
    }

    @PostMapping(path="/api/order/supplier/{id}/delete")
    @ResponseBody
    public void deleteSupplierOrder(@PathVariable("id") int id) {
        supplierOrderService.deleteSupplierOrder(id);
    }

    @GetMapping(path="/api/order/supplier/{id}")
    @ResponseBody
    public SupplierOrder getSupplierOrderById(@Valid @NotNull @PathVariable("id") int id) {
        return supplierOrderService.getSupplierOrderById(id);
    }

    @PostMapping(path="/api/order/supplier/{id}/edit")
    @ResponseBody
    public void updateSupplierOrder(@PathVariable("id") int id, @Valid @NotNull @RequestBody SupplierOrder supplierOrder) {
        supplierOrderService.updateSupplierOrder(id, supplierOrder);
    }
}
