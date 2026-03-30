package com.develop.capstoneproject.feedback;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    //로그창에서 피드백 내용 뽑아갈 때
    List<Feedback> findAllByOrderByCreatedAtDesc();

    //1시간 지난 데이터 삭제하기
     @Modifying
    @Query("DELETE FROM Feedback f WHERE f.createdAt <:time")
    void deleteOldFeedbacks(@Param("time") LocalDateTime time);
}
