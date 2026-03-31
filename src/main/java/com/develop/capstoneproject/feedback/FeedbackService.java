package com.develop.capstoneproject.feedback;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback submitFeedback(FeedbackRequestDto dto) {


        Feedback feedback = Feedback.builder()
                .zoneId(dto.getZoneId())
                .temperatureStatus(dto.getTemperatureStatus())
                .message(dto.getMessage())
                .build();

         return feedbackRepository.save(feedback);
    }

    @Scheduled(fixedRate = 6000)
    @Transactional
    public void deleteOldFeedbacks() {

        LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);
        feedbackRepository.deleteOldFeedbacks(oneHourAgo);
        log.info("data delete");
    }

}

