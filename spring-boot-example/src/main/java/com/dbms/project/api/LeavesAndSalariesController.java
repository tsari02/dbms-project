package com.dbms.project.api;

import com.dbms.project.model.LeavesAndSalaries;
import com.dbms.project.service.LeavesAndSalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping(path="/employee/{id}/leaves/add")
    public String addLeavesAndSalaries(@PathVariable("id") int id, Model model) {
        LeavesAndSalaries leave = new LeavesAndSalaries();
        leave.setEmployeeId(id);
        model.addAttribute("leave", leave);
        return "add-leaves";
    }

    @PostMapping(path="/employee/leaves/add")
    public String addLeavesAndSalariesSubmit(@Valid @NotNull LeavesAndSalaries leave, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // System.out.println(leavesAndSalaries.getEmployeeId());
        System.out.println(leave);
        leavesAndSalariesService.insertLeavesAndSalaries(leave);
        return "redirect:/employee/"+leave.getEmployeeId();
    }
}
