package com.develop.capstoneproject.control.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ControlMapper {
    public ControlLogEntity toLog(Long zoneId, Long deviceId,
                                  String controlType, String action, Float value) {
        return ControlLogEntity.builder()
                .zoneId(zoneId)
                .deviceId(deviceId)
                .controlType(controlType)
                .action(action)
                .value(value)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public DeviceEntity applyLighting(DeviceEntity device, String action) {
        return DeviceEntity.builder()
                .deviceId(device.getDeviceId())
                .zoneId(device.getZoneId())
                .deviceType(device.getDeviceType())
                .status(action)  // "ON" or "OFF"
                .createdAt(device.getCreatedAt())
                .build();
    }

    public DeviceEntity applyHvac(DeviceEntity device, String action, Float temperature) {
        String newStatus = action.equals("SET_TEMP")
                ? String.valueOf(temperature)
                : action;
        return DeviceEntity.builder()
                .deviceId(device.getDeviceId())
                .zoneId(device.getZoneId())
                .deviceType(device.getDeviceType())
                .status(newStatus)
                .createdAt(device.getCreatedAt())
                .build();
    }
}
