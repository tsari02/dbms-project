package com.dbms.project.api;

import com.dbms.project.model.Feedback;
import com.dbms.project.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


// @RequestMapping("api/feedback")
@Controller
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping(path="/api/feedback")
    @ResponseBody
    public void addFeedback(@Valid @NotNull @RequestBody Feedback feedback) {
        feedbackService.insertFeedback(feedback);
    }

    @GetMapping(path="/api/feedback")
    @ResponseBody
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @PostMapping(path="/api/feedback/{id}/delete")
    @ResponseBody
    public void deleteFeedback(@PathVariable("id") int id) {
        feedbackService.deleteFeedback(id);
    }

    @GetMapping(path="/api/feedback/{id}")
    @ResponseBody
    public Feedback getFeedbackById(@PathVariable("id") int id) {
        return feedbackService.getFeedbackById(id);
    }

    @PostMapping(path="/api/feedback/{id}/edit")
    @ResponseBody
    public void updateFeedback(@PathVariable("id") int id, @Valid @NotNull @RequestBody Feedback feedback) {
        feedbackService.updateFeedback(id, feedback);
    }
}
