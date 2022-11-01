package com.dbms.project.api;

import com.dbms.project.model.LeavesAndSalaries;
import com.dbms.project.service.LeavesAndSalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/leavesAndSalaries")
@Controller
public class LeavesAndSalariesController {
    private final LeavesAndSalariesService leavesAndSalariesService;

    @Autowired
    public LeavesAndSalariesController(LeavesAndSalariesService leavesAndSalariesService) {
        this.leavesAndSalariesService = leavesAndSalariesService;
    }

    @PostMapping
    @ResponseBody
    public void addLeavesAndSalaries(@RequestBody LeavesAndSalaries leavesAndSalaries) {
        leavesAndSalariesService.insertLeavesAndSalaries(leavesAndSalaries);
    }

    @GetMapping
    @ResponseBody
    public List<LeavesAndSalaries> getAllLeavesAndSalaries() {
        return leavesAndSalariesService.getAllLeavesAndSalaries();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteLeavesAndSalaries(@PathVariable("id") int id) {
        leavesAndSalariesService.deleteLeavesAndSalaries(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public LeavesAndSalaries getLeavesAndSalariesById(@PathVariable("id") int id) {
        return leavesAndSalariesService.getLeavesAndSalariesById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateLeavesAndSalaries(@PathVariable("id") int id, @RequestBody LeavesAndSalaries leavesAndSalaries) {
        leavesAndSalariesService.updateLeavesAndSalaries(id, leavesAndSalaries);
    }
}
