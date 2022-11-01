package com.dbms.project.api;

import com.dbms.project.model.WorkExperience;
import com.dbms.project.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/workExperience")
@Controller
public class WorkExperienceController {
    private final WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperienceController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @PostMapping
    @ResponseBody
    public void addWorkExperience(@RequestBody WorkExperience workExperience) {
        workExperienceService.insertWorkExperience(workExperience);
    }

    @GetMapping
    @ResponseBody
    public List<WorkExperience> getAllWorkExperiences() {
        return workExperienceService.getAllWorkExperiences();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteWorkExperience(@PathVariable("id") int id) {
        workExperienceService.deleteWorkExperience(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public WorkExperience getWorkExperienceById(@PathVariable("id") int id) {
        return workExperienceService.getWorkExperienceById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateWorkExperience(@PathVariable("id") int id, @RequestBody WorkExperience workExperience) {
        workExperienceService.updateWorkExperience(id, workExperience);
    }
}
