package com.develop.capstoneproject.control.model.repository;

import com.develop.capstoneproject.control.model.ControlLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlLogRepository extends JpaRepository<ControlLogEntity, Long> {
}
