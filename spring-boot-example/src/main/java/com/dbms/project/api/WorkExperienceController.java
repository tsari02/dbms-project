package com.dbms.project.api;

import com.dbms.project.model.WorkExperience;
import com.dbms.project.service.WorkExperienceService;
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


// @RequestMapping("api/workExperience")
@Controller
public class WorkExperienceController {
    private final WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperienceController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @PostMapping(path="/api/workExperience")
    @ResponseBody
    public void addWorkExperience(@Valid @NotNull @RequestBody WorkExperience workExperience) {
        workExperienceService.insertWorkExperience(workExperience);
    }

    @GetMapping(path="/api/workExperience")
    @ResponseBody
    public List<WorkExperience> getAllWorkExperiences() {
        return workExperienceService.getAllWorkExperiences();
    }

    @PostMapping(path="/api/workExperience/{id}/delete")
    @ResponseBody
    public void deleteWorkExperience(@PathVariable("id") int id) {
        workExperienceService.deleteWorkExperience(id);
    }

    @GetMapping(path="/api/workExperience/{id}")
    @ResponseBody
    public WorkExperience getWorkExperienceById(@PathVariable("id") int id) {
        return workExperienceService.getWorkExperienceById(id);
    }

    @PostMapping(path="/api/workExperience/{id}/edit")
    @ResponseBody
    public void updateWorkExperience(@PathVariable("id") int id, @Valid @NotNull @RequestBody WorkExperience workExperience) {
        workExperienceService.updateWorkExperience(id, workExperience);
    }
    @GetMapping(path="/employee/{id}/workExperience/add")
    public String addWorkExperience(@PathVariable("id") int id, Model model) {
        WorkExperience workExperience = new WorkExperience();
        workExperience.setEmployeeId(id);
        model.addAttribute("workExperience", workExperience);
        return "add-workExperience";
    }

    @PostMapping(path="/employee/workexperience/add")
    public String addWorkExperienceSubmit(@Valid @NotNull WorkExperience workExperience, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // System.out.println(leavesAndSalaries.getEmployeeId());
        // System.out.println(leave);
        workExperienceService.insertWorkExperience(workExperience);
        return "redirect:/employee/"+workExperience.getEmployeeId();
    }
}
