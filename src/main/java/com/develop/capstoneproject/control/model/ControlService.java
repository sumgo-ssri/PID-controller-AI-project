package com.develop.capstoneproject.control.model;


import com.develop.capstoneproject.control.model.dto.DeviceStatusResponseDto;
import com.develop.capstoneproject.control.model.dto.HvacControlRequestDto;
import com.develop.capstoneproject.control.model.dto.LightingControlRequestDto;
import com.develop.capstoneproject.control.model.repository.ControlLogRepository;
import com.develop.capstoneproject.control.model.repository.DeviceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ControlService {
    private final DeviceRepository deviceRepository;
    private final ControlLogRepository controlLogRepository;
    private final ControlMapper controlMapper;

    // 구역 내 장치 목록 + 상태 조회
    public List<DeviceStatusResponseDto> getDevicesByZone(Long zoneId) {
        return deviceRepository.findByZoneId(zoneId)
                .stream()
                .map(DeviceStatusResponseDto::from)
                .collect(Collectors.toList());
    }

    // 조명 제어 (ON/OFF)
    @Transactional
    public DeviceStatusResponseDto controlLighting(Long deviceId, LightingControlRequestDto dto) {
        DeviceEntity device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 장치입니다. id=" + deviceId));

        // 장치 타입 검증
        if (!"LIGHTING".equals(device.getDeviceType())) {
            throw new IllegalArgumentException("조명 장치가 아닙니다. id=" + deviceId);
        }

        // 상태 업데이트
        DeviceEntity updated = controlMapper.applyLighting(device, dto.getAction());
        deviceRepository.save(updated);

        // 제어 로그 저장
        controlLogRepository.save(
                controlMapper.toLog(device.getZoneId(), deviceId, "LIGHTING", dto.getAction(), null)
        );

        return DeviceStatusResponseDto.from(updated);
    }

    // 냉난방 제어 (ON/OFF/SET_TEMP)
    @Transactional
    public DeviceStatusResponseDto controlHvac(Long deviceId, HvacControlRequestDto dto) {
        DeviceEntity device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 장치입니다. id=" + deviceId));

        // 장치 타입 검증
        if (!"HVAC".equals(device.getDeviceType())) {
            throw new IllegalArgumentException("냉난방 장치가 아닙니다. id=" + deviceId);
        }

        // SET_TEMP일 때 온도값 필수 검증
        if ("SET_TEMP".equals(dto.getAction()) && dto.getTemperature() == null) {
            throw new IllegalArgumentException("온도 설정 시 temperature 값이 필요합니다.");
        }

        // 상태 업데이트
        DeviceEntity updated = controlMapper.applyHvac(device, dto.getAction(), dto.getTemperature());
        deviceRepository.save(updated);

        // 제어 로그 저장
        controlLogRepository.save(
                controlMapper.toLog(device.getZoneId(), deviceId, "HVAC", dto.getAction(), dto.getTemperature())
        );

        return DeviceStatusResponseDto.from(updated);
    }
}
