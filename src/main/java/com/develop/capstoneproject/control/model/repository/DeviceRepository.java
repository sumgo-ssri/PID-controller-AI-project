package com.develop.capstoneproject.control.model.repository;

import com.develop.capstoneproject.control.model.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
    List<DeviceEntity> findByZoneId(Long zoneId);
}
