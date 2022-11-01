package com.dbms.project.api;

import com.dbms.project.model.Feedback;
import com.dbms.project.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/feedback")
@Controller
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    @ResponseBody
    public void addFeedback(@RequestBody Feedback feedback) {
        feedbackService.insertFeedback(feedback);
    }

    @GetMapping
    @ResponseBody
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @DeleteMapping(path="{id}")
    @ResponseBody
    public void deleteFeedback(@PathVariable("id") int id) {
        feedbackService.deleteFeedback(id);
    }

    @GetMapping(path="{id}")
    @ResponseBody
    public Feedback getFeedbackById(@PathVariable("id") int id) {
        return feedbackService.getFeedbackById(id);
    }

    @PutMapping(path="{id}")
    @ResponseBody
    public void updateFeedback(@PathVariable("id") int id, @RequestBody Feedback feedback) {
        feedbackService.updateFeedback(id, feedback);
    }
}
