package com.greenfox.exams.spring.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String projectName;
    private String projectTag;

    public Project(String projectName, String projectTag) {
        this.projectName = projectName;
        this.projectTag = projectTag;
    }
}
