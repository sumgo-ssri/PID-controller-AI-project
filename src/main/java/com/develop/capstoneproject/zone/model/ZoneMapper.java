// zone/model/component/ZoneMapper.java
package com.develop.capstoneproject.zone.model;

import com.develop.capstoneproject.zone.model.dto.ZoneRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ZoneMapper {

    public ZoneEntity toEntity(ZoneRequestDto dto) {
        return ZoneEntity.builder()
                .zoneName(dto.getZoneName())
                .description(dto.getDescription())
                .build();
    }
}