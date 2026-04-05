// zone/model/dto/ZoneResponseDto.java
package com.develop.capstoneproject.zone.model.dto;

import com.develop.capstoneproject.zone.model.ZoneEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ZoneResponseDto {
    private Long zoneId;
    private String zoneName;
    private String description;

    public static ZoneResponseDto from(ZoneEntity entity) {
        return ZoneResponseDto.builder()
                .zoneId(entity.getZoneId())
                .zoneName(entity.getZoneName())
                .description(entity.getDescription())
                .build();
    }
}