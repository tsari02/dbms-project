package com.dbms.project.api;

import com.dbms.project.model.SupplierOrder;
import com.dbms.project.service.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("api/supplierOrder")
@Controller
public class SupplierOrderController {
    private final SupplierOrderService supplierOrderService;

    @Autowired
    public SupplierOrderController(SupplierOrderService supplierOrderService) {
        this.supplierOrderService = supplierOrderService;
    }

    @PostMapping
    @ResponseBody
    public void addSupplierOrder(@Valid @NotNull @RequestBody SupplierOrder supplierOrder) {
        supplierOrderService.insertSupplierOrder(supplierOrder);
    }

    @GetMapping
    @ResponseBody
    public List<SupplierOrder> getAllSupplierOrders() {
        return supplierOrderService.getAllSupplierOrders();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteSupplierOrder(@PathVariable("id") int id) {
        supplierOrderService.deleteSupplierOrder(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public SupplierOrder getSupplierOrderById(@Valid @NotNull @PathVariable("id") int id) {
        return supplierOrderService.getSupplierOrderById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateSupplierOrder(@PathVariable("id") int id, @RequestBody SupplierOrder supplierOrder) {
        supplierOrderService.updateSupplierOrder(id, supplierOrder);
    }
}
