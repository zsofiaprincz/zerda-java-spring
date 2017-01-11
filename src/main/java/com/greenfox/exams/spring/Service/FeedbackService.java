package com.greenfox.exams.spring.Service;


import com.greenfox.exams.spring.Entity.Feedback;
import com.greenfox.exams.spring.Repo.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class FeedbackService {

    private FeedbackRepo feedbackRepo;



    @Autowired
    public FeedbackService(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }

    public static ArrayList<String> acceptableWords= new ArrayList<>(Arrays.asList("amazing", "awesome", "blithesome", "excellent", "fabulous", "fantastic", "favorable", "fortuitous", "great", "incredible", "ineffable", "mirthful", "outstanding", "perfect", "propitious", "remarkable", "smart", "spectacular", "splendid", "stellar", "stupendous", "super", "ultimate", "unbelievable", "wondrous"));
    public static String worngWords = new String("Sorry, your evaluation does not contain enough of our acceptable words, please fill out the form again");
    public static String wrongEmail = new String("Sorry, the format of the email you provided is not valid, please fill out the form again");
    public static String wrongscore = new String("Sorry, the score you gave is not good enough, please fill out the form again");


    public void addFeedbacktoDatabase (Feedback feedback) {
        feedbackRepo.save(feedback);

    }

    public boolean wordchecker(Feedback feedback) {
        int numberOfMatchingWords=0;
        for (String contains : acceptableWords) {
            if (feedback.getTextEvaluation().contains(contains)) {
                numberOfMatchingWords++;
            }
        }
        return numberOfMatchingWords > 5;
    }

    public boolean emailChecker(Feedback feedback){
          return feedback.getEmail().contains("@");
    }

    public boolean scoreChecker(Feedback feedback){
        return feedback.getScore()>=10;

    }



}
