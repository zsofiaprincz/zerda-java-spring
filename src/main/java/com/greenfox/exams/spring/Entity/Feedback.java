package com.greenfox.exams.spring.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="feedback")
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String textEvaluation;
    private String email;
    private int score;
}
