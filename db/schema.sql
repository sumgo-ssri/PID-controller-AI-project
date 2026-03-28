CREATE DATABASE IF NOT EXISTS project_db;
USE capstoneproject_db;

CREATE TABLE feedback (
    feedback_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    zone_id VARCHAR(20) NOT NULL,
    temperature_status VARCHAR(10) NOT NULL, 
    message VARCHAR(100),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);