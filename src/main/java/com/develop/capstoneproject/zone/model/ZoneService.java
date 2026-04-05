package com.develop.capstoneproject.zone.model;


import com.develop.capstoneproject.zone.model.dto.ZoneRequestDto;
import com.develop.capstoneproject.zone.model.dto.ZoneResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZoneService {

    private final ZoneRepository zoneRepository;
    private final ZoneMapper zoneMapper;

    public List<ZoneResponseDto> getAllZones() {
        return zoneRepository.findAll()
                .stream()
                .map(ZoneResponseDto::from)
                .collect(Collectors.toList());
    }

    public ZoneResponseDto getZone(Long zoneId) {
        ZoneEntity zone = zoneRepository.findById(zoneId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 구역입니다. id=" + zoneId));
        return ZoneResponseDto.from(zone);
    }

    @Transactional
    public ZoneResponseDto createZone(ZoneRequestDto dto) {
        ZoneEntity zone = zoneMapper.toEntity(dto);
        return ZoneResponseDto.from(zoneRepository.save(zone));
    }

    @Transactional
    public ZoneResponseDto updateZone(Long zoneId, ZoneRequestDto dto) {
        ZoneEntity zone = zoneRepository.findById(zoneId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 구역입니다. id=" + zoneId));
        ZoneEntity updated = ZoneEntity.builder()
                .zoneId(zone.getZoneId())
                .zoneName(dto.getZoneName())
                .description(dto.getDescription())
                .build();
        return ZoneResponseDto.from(zoneRepository.save(updated));
    }

    @Transactional
    public void deleteZone(Long zoneId) {
        if (!zoneRepository.existsById(zoneId)) {
            throw new IllegalArgumentException("존재하지 않는 구역입니다. id=" + zoneId);
        }
        zoneRepository.deleteById(zoneId);
    }
}
