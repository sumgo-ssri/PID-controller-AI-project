package com.develop.capstoneproject.feedback;

import org.springframework.stereotype.Service;

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

}

