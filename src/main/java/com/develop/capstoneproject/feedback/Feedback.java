package com.develop.capstoneproject.feedback;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @Column(nullable = false)
    private String zoneId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TemperatureStatus temperatureStatus;

    @Column(columnDefinition = "TEXT", length = 100)
    private String message;

    @CreationTimestamp
    private LocalDateTime createdAt;
}