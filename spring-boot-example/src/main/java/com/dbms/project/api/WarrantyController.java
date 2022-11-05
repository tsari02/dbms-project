package com.dbms.project.api;

import com.dbms.project.model.Warranty;
import com.dbms.project.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

// @RequestMapping("api/warranty")
@Controller
public class WarrantyController {
    private final WarrantyService warrantyService;

    @Autowired
    public WarrantyController(WarrantyService warrantyService) {
        this.warrantyService = warrantyService;
    }

    @PostMapping(path="/api/warranty")
    @ResponseBody
    public void addWarranty(@Valid @NotNull @RequestBody Warranty warranty) {
        warrantyService.insertWarranty(warranty);
    }

    @GetMapping(path="/api/warranty")
    @ResponseBody
    public List<Warranty> getAllWarranties() {
        return warrantyService.getAllWarranties();
    }

    @PostMapping(path="/api/warranty/{id}/delete")
    @ResponseBody
    public void deleteWarranty(@PathVariable("id") int id) {
        warrantyService.deleteWarranty(id);
    }

    @GetMapping(path="/api/warranty{id}")
    @ResponseBody
    public Warranty getWarrantyById(@PathVariable("id") int id) {
        return warrantyService.getWarrantyById(id);
    }

    @PostMapping(path="/api/warranty{id}/edit")
    @ResponseBody
    public void updateWarranty(@PathVariable("id") int id, @Valid @NotNull @RequestBody Warranty warranty) {
        warrantyService.updateWarranty(id, warranty);
    }
}
