package com.develop.capstoneproject.log.model;

import com.develop.capstoneproject.control.model.ControlLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<ControlLogEntity, Long> {

    @Query("SELECT c FROM ControlLogEntity c " +
            "WHERE c.zoneId = :zoneId " +
            "AND c.createdAt >= :startOfDay " +
            "AND c.createdAt < :endOfDay " +
            "ORDER BY c.createdAt DESC")
    List<ControlLogEntity> findByZoneIdAndDate(
            @Param("zoneId") Long zoneId,
            @Param("startOfDay") LocalDateTime startOfDay,
            @Param("endOfDay") LocalDateTime endOfDay
    );
}
