package com.develop.capstoneproject.control.controller;

import com.develop.capstoneproject.control.model.ControlService;
import com.develop.capstoneproject.control.model.dto.DeviceStatusResponseDto;
import com.develop.capstoneproject.control.model.dto.HvacControlRequestDto;
import com.develop.capstoneproject.control.model.dto.LightingControlRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/control")
@RequiredArgsConstructor
public class ControlController {

    private final ControlService controlService;

    // 구역 내 장치 목록 + 상태 조회
    @GetMapping("/zones/{zoneId}/devices")
    public ResponseEntity<List<DeviceStatusResponseDto>> getDevicesByZone(@PathVariable Long zoneId) {
        return ResponseEntity.ok(controlService.getDevicesByZone(zoneId));
    }

    // 조명 ON/OFF
    @PatchMapping("/devices/{deviceId}/lighting")
    public ResponseEntity<DeviceStatusResponseDto> controlLighting(
            @PathVariable Long deviceId,
            @RequestBody LightingControlRequestDto dto) {
        return ResponseEntity.ok(controlService.controlLighting(deviceId, dto));
    }

    // 냉난방 제어
    @PatchMapping("/devices/{deviceId}/hvac")
    public ResponseEntity<DeviceStatusResponseDto> controlHvac(
            @PathVariable Long deviceId,
            @RequestBody HvacControlRequestDto dto) {
        return ResponseEntity.ok(controlService.controlHvac(deviceId, dto));
    }
}
