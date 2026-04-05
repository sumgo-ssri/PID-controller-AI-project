package com.develop.capstoneproject.zone.controller;

import com.develop.capstoneproject.zone.model.ZoneService;
import com.develop.capstoneproject.zone.model.dto.ZoneRequestDto;
import com.develop.capstoneproject.zone.model.dto.ZoneResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
@RequiredArgsConstructor
public class ZoneController {

    private final ZoneService zoneService;

    @GetMapping
    public ResponseEntity<List<ZoneResponseDto>> getAllZones() {
        return ResponseEntity.ok(zoneService.getAllZones());
    }

    @GetMapping("/{zoneId}")
    public ResponseEntity<ZoneResponseDto> getZone(@PathVariable Long zoneId) {
        return ResponseEntity.ok(zoneService.getZone(zoneId));
    }

    @PostMapping
    public ResponseEntity<ZoneResponseDto> createZone(@RequestBody ZoneRequestDto dto) {
        return ResponseEntity.ok(zoneService.createZone(dto));
    }

    @PutMapping("/{zoneId}")
    public ResponseEntity<ZoneResponseDto> updateZone(@PathVariable Long zoneId,
                                                      @RequestBody ZoneRequestDto dto) {
        return ResponseEntity.ok(zoneService.updateZone(zoneId, dto));
    }

    @DeleteMapping("/{zoneId}")
    public ResponseEntity<Void> deleteZone(@PathVariable Long zoneId) {
        zoneService.deleteZone(zoneId);
        return ResponseEntity.noContent().build();
    }
}