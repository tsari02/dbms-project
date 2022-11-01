package com.dbms.project.service;

import com.dbms.project.dao.FeedbackDao;
import com.dbms.project.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackDao feedbackDao;

    @Autowired
    public FeedbackService(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    public int insertFeedback(Feedback feedback) {
        return feedbackDao.insertFeedback(feedback);
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.getAllFeedbacks();
    }

    public Feedback getFeedbackById(int id) {
        return feedbackDao.getFeedbackById(id);
    }

    public int deleteFeedback(int id) {
        return feedbackDao.deleteFeedback(id);
    }

    public int updateFeedback(int id, Feedback feedback) {
        return feedbackDao.updateFeedback(id, feedback);
    }
}
