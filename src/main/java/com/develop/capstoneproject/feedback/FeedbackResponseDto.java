package com.develop.capstoneproject.feedback;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackResponseDto {

    private Long feedbackId;

    private String zoneId;

    private TemperatureStatus temperatureStatus;

    private String message;

    private LocalDateTime createdAt;

    public static FeedbackResponseDto from(Feedback feedback){
        return new FeedbackResponseDto(
                feedback.getFeedbackId(),
                feedback.getZoneId(),
                feedback.getTemperatureStatus(),
                feedback.getMessage(),
                feedback.getCreatedAt()
        );
    }
}


