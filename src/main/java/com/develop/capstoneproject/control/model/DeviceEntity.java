package com.develop.capstoneproject.control.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "devices")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Long deviceId;

    @Column(name = "zone_id")
    private Long zoneId;

    @Column(name = "device_type", length = 20)
    private String deviceType;  // "LIGHTING" or "HVAC"

    @Column(name = "status", length = 20)
    private String status;  // "ON" / "OFF" / 온도값 문자열

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
