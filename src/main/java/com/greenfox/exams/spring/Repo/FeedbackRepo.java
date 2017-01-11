package com.greenfox.exams.spring.Repo;

import com.greenfox.exams.spring.Entity.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends CrudRepository<Feedback, Long>{


}
