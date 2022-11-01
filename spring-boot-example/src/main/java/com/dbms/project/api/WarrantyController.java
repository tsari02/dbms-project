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

@RequestMapping("api/warranty")
@Controller
public class WarrantyController {
    private final WarrantyService warrantyService;

    @Autowired
    public WarrantyController(WarrantyService warrantyService) {
        this.warrantyService = warrantyService;
    }

    @PostMapping
    @ResponseBody
    public void addWarranty(@Valid @NotNull @RequestBody Warranty warranty) {
        warrantyService.insertWarranty(warranty);
    }

    @GetMapping
    @ResponseBody
    public List<Warranty> getAllWarranties() {
        return warrantyService.getAllWarranties();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteWarranty(@PathVariable("id") int id) {
        warrantyService.deleteWarranty(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public Warranty getWarrantyById(@PathVariable("id") int id) {
        return warrantyService.getWarrantyById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateWarranty(@PathVariable("id") int id, @Valid @NotNull @RequestBody Warranty warranty) {
        warrantyService.updateWarranty(id, warranty);
    }
}
