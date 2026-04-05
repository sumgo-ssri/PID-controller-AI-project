package com.develop.capstoneproject.log.model;

import com.develop.capstoneproject.log.model.dto.ControlLogResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
    private final LogMapper logMapper;

    public List<ControlLogResponseDto> getControlLogs(Long zoneId, LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();           // 2024-01-01 00:00:00
        LocalDateTime endOfDay = date.plusDays(1).atStartOfDay(); // 2024-01-02 00:00:00

        return logMapper.toDtoList(
                logRepository.findByZoneIdAndDate(zoneId, startOfDay, endOfDay)
        );
    }
}
