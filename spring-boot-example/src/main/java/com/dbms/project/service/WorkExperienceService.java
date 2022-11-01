package com.dbms.project.service;

import com.dbms.project.dao.WorkExperienceDao;
import com.dbms.project.model.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceService {
    private final WorkExperienceDao workExperienceDao;
    
    @Autowired
    public WorkExperienceService(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }

    public int insertWorkExperience(WorkExperience workExperience) {
        return workExperienceDao.insertWorkExperience(workExperience);
    }

    public List<WorkExperience> getAllWorkExperiences() {
        return workExperienceDao.getAllWorkExperiences();
    }

    public WorkExperience getWorkExperienceById(int id) {
        return workExperienceDao.getWorkExperienceById(id);
    }

    public int deleteWorkExperience(int id) {
        return workExperienceDao.deleteWorkExperience(id);
    }

    public int updateWorkExperience(int id, WorkExperience workExperience) {
        return workExperienceDao.updateWorkExperience(id, workExperience);
    }
}
