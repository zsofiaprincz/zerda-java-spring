package com.greenfox.exams.spring.Controller;

import com.greenfox.exams.spring.Entity.Feedback;
import com.greenfox.exams.spring.Service.DataLoader;
import com.greenfox.exams.spring.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class MainController {

    private FeedbackService feedbackService;
    private DataLoader dataLoader;

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
    public String processFeedback(@Valid Feedback feedback, BindingResult bindingResult) {
        if (feedbackService.wordchecker(feedback)&& feedbackService.emailChecker(feedback)&& feedbackService.scoreChecker(feedback)){
            feedbackService.addFeedbacktoDatabase(feedback);
            return "Thankyou";
        } else {
            return "Welcome";
        }
    }

    @RequestMapping(value = "/thankyou", method = RequestMethod.GET)
    public String showThankYouPage(Model model){
        model.addAttribute("dataloader", dataLoader.findAll());
        return "Thankyou";
    }
}
