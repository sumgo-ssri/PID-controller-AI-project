package com.develop.capstoneproject.log.model.dto;

import com.develop.capstoneproject.control.model.ControlLogEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ControlLogResponseDto {
    private Long controlId;
    private Long zoneId;
    private Long deviceId;
    private String controlType;   // "LIGHTING" / "HVAC"
    private String action;        // "ON" / "OFF" / "SET_TEMP"
    private Float value;          // 냉난방 온도값 (조명은 null)
    private LocalDateTime createdAt;

    public static ControlLogResponseDto from(ControlLogEntity entity) {
        return ControlLogResponseDto.builder()
                .controlId(entity.getControlId())
                .zoneId(entity.getZoneId())
                .deviceId(entity.getDeviceId())
                .controlType(entity.getControlType())
                .action(entity.getAction())
                .value(entity.getValue())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
