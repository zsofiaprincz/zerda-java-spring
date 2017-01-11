package com.greenfox.exams.spring.Controller;

import com.greenfox.exams.spring.Entity.Feedback;
import com.greenfox.exams.spring.Service.DataLoader;
import com.greenfox.exams.spring.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    FeedbackService feedbackService;
    DataLoader dataLoader;

    @Autowired
    public MainController(FeedbackService feedbackService, DataLoader dataLoader) {
        this.feedbackService = feedbackService;
        this.dataLoader = dataLoader;
    }

    @RequestMapping(value = {"/welcome"})
    public String showIndex(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "Welcome";
    }

    @GetMapping(value = "/welcome")
    public String addContentForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "Welcome";
    }

    @PostMapping("/welcome")
    public String processFeedback(@ModelAttribute Feedback feedback) {
        if (feedbackService.wordchecker(feedback)&& feedbackService.emailChecker(feedback)&& feedbackService.scoreChecker(feedback)){
            feedbackService.addFeedbacktoDatabase(feedback);
            return "redirect:/Thankyou";
        } else {
            return "redirect:/Welcome";
        }
    }
}
