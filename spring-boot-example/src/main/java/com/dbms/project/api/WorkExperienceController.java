package com.dbms.project.api;

import com.dbms.project.model.WorkExperience;
import com.dbms.project.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
