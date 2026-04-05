package com.develop.capstoneproject.control.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "control_logs")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ControlLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "control_id")
    private Long controlId;

    @Column(name = "zone_id")
    private Long zoneId;

    @Column(name = "device_id")
    private Long deviceId;

    @Column(name = "control_type", length = 20)
    private String controlType;  // "LIGHTING" / "HVAC"

    @Column(name = "action", length = 20)
    private String action;  // "ON" / "OFF" / "SET_TEMP"

    @Column(name = "value")
    private Float value;  // 조명: null, 냉난방: 설정 온도

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
