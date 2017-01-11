package com.greenfox.exams.spring.Repo;

import com.greenfox.exams.spring.Entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends CrudRepository <Project, Long> {

    List<Project> findAll();

}
