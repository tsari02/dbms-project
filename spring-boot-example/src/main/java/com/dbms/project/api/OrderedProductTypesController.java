package com.dbms.project.api;

import com.dbms.project.model.OrderedProductTypes;
import com.dbms.project.service.OrderedProductTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("api/orderedProductTypes")
@Controller
public class OrderedProductTypesController {
    private final OrderedProductTypesService orderedProductTypesService;

    @Autowired
    public OrderedProductTypesController(OrderedProductTypesService orderedProductTypesService) {
        this.orderedProductTypesService = orderedProductTypesService;
    }

    @PostMapping
    @ResponseBody
    public void addOrderedProductTypes(@Valid @NotNull @RequestBody OrderedProductTypes orderedProductTypes) {
        orderedProductTypesService.insertOrderedProductTypes(orderedProductTypes);
    }

    @GetMapping
    @ResponseBody
    public List<OrderedProductTypes> getAllOrderedProductTypes() {
        return orderedProductTypesService.getAllOrderedProductTypes();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteOrderedProductTypes(@PathVariable("id") int id) {
        orderedProductTypesService.deleteOrderedProductTypes(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public OrderedProductTypes getOrderedProductTypesById(@PathVariable("id") int id) {
        return orderedProductTypesService.getOrderedProductTypesById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateOrderedProductTypes(@PathVariable("id") int id, @Valid @NotNull @RequestBody OrderedProductTypes orderedProductTypes) {
        orderedProductTypesService.updateOrderedProductTypes(id, orderedProductTypes);
    }
}
