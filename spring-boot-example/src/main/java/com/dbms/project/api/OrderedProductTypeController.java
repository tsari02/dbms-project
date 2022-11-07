package com.dbms.project.api;

import com.dbms.project.model.OrderedProductType;
import com.dbms.project.service.OrderedProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

// @RequestMapping("api/orderedProductType")
@Controller
public class OrderedProductTypeController {
    private final OrderedProductTypeService orderedProductTypeService;

    @Autowired
    public OrderedProductTypeController(OrderedProductTypeService orderedProductTypeService) {
        this.orderedProductTypeService = orderedProductTypeService;
    }

    @PostMapping(path="/api/orderedProductType")
    @ResponseBody
    public void addOrderedProductType(@Valid @NotNull @RequestBody OrderedProductType orderedProductType) {
        orderedProductTypeService.insertOrderedProductType(orderedProductType);
    }

    @GetMapping(path="/api/orderedProductType")
    @ResponseBody
    public List<OrderedProductType> getAllOrderedProductTypes() {
        return orderedProductTypeService.getAllOrderedProductTypes();
    }
    
    @PostMapping(path="/api/orderedProductType/{id}/delete")
    @ResponseBody
    public void deleteOrderedProductType(@PathVariable("id") int id) {
        orderedProductTypeService.deleteOrderedProductType(id);
    }

    @GetMapping(path="/api/orderedProductType/{id}")
    @ResponseBody
    public OrderedProductType getOrderedProductTypeById(@PathVariable("id") int id) {
        return orderedProductTypeService.getOrderedProductTypeById(id);
    }

    @PostMapping(path="/api/orderedProductType/{id}/edit")
    @ResponseBody
    public void updateOrderedProductType(@PathVariable("id") int id, @Valid @NotNull @RequestBody OrderedProductType orderedProductType) {
        orderedProductTypeService.updateOrderedProductType(id, orderedProductType);
    }
}
