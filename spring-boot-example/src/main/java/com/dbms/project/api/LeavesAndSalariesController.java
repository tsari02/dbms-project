package com.dbms.project.api;

import com.dbms.project.model.LeavesAndSalaries;
import com.dbms.project.service.LeavesAndSalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


// @RequestMapping("api/leavesAndSalaries")
@Controller
public class LeavesAndSalariesController {
    private final LeavesAndSalariesService leavesAndSalariesService;

    @Autowired
    public LeavesAndSalariesController(LeavesAndSalariesService leavesAndSalariesService) {
        this.leavesAndSalariesService = leavesAndSalariesService;
    }

    @PostMapping(path="/api/leavesAndSalaries")
    @ResponseBody
    public void addLeavesAndSalaries(@Valid @NotNull @RequestBody LeavesAndSalaries leavesAndSalaries) {
        leavesAndSalariesService.insertLeavesAndSalaries(leavesAndSalaries);
    }

    @GetMapping(path="/api/leavesAndSalaries")
    @ResponseBody
    public List<LeavesAndSalaries> getAllLeavesAndSalaries() {
        return leavesAndSalariesService.getAllLeavesAndSalaries();
    }

    @PostMapping(path="/api/leavesAndSalaries/{id}/delete")
    @ResponseBody
    public void deleteLeavesAndSalaries(@PathVariable("id") int id) {
        leavesAndSalariesService.deleteLeavesAndSalaries(id);
    }

    @GetMapping(path="/api/leavesAndSalaries/{id}")
    @ResponseBody
    public LeavesAndSalaries getLeavesAndSalariesById(@PathVariable("id") int id) {
        return leavesAndSalariesService.getLeavesAndSalariesById(id);
    }

    @PostMapping(path="/api/leavesAndSalaries/{id}/edit")
    @ResponseBody
    public void updateLeavesAndSalaries(@PathVariable("id") int id, @Valid @NotNull @RequestBody LeavesAndSalaries leavesAndSalaries) {
        leavesAndSalariesService.updateLeavesAndSalaries(id, leavesAndSalaries);
    }
}
