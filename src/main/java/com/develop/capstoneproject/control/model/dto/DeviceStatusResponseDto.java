package com.develop.capstoneproject.control.model.dto;

import com.develop.capstoneproject.control.model.DeviceEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeviceStatusResponseDto {
    private Long deviceId;
    private Long zoneId;
    private String deviceType;
    private String status;

    public static DeviceStatusResponseDto from(DeviceEntity entity) {
        return DeviceStatusResponseDto.builder()
                .deviceId(entity.getDeviceId())
                .zoneId(entity.getZoneId())
                .deviceType(entity.getDeviceType())
                .status(entity.getStatus())
                .build();
    }
}
