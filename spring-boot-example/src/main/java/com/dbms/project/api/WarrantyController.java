package com.dbms.project.api;

import com.dbms.project.model.Warranty;
import com.dbms.project.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void addWarranty(@RequestBody Warranty warranty) {
        warrantyService.insertWarranty(warranty);
    }

    @GetMapping
    @ResponseBody
    public List<Warranty> getAllWarrantys() {
        return warrantyService.getAllWarrantys();
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
    public void updateWarranty(@PathVariable("id") int id, @RequestBody Warranty warranty) {
        warrantyService.updateWarranty(id, warranty);
    }
}
