package com.develop.capstoneproject.log.model;

import com.develop.capstoneproject.control.model.ControlLogEntity;
import com.develop.capstoneproject.log.model.dto.ControlLogResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LogMapper {
    public List<ControlLogResponseDto> toDtoList(List<ControlLogEntity> entities) {
        return entities.stream()
                .map(ControlLogResponseDto::from)
                .collect(Collectors.toList());
    }
}
