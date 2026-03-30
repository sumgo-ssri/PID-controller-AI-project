package com.develop.capstoneproject.feedback;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    //로그창에서 피드백 내용 뽑아갈 때
    List<Feedback> findAllByOrderByCreatedAtDesc();
}
