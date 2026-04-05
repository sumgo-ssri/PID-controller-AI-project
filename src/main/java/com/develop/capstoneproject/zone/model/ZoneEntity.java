// zone/model/component/ZoneEntity.java
package com.develop.capstoneproject.zone.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "zones")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zone_id")
    private Long zoneId;

    @Column(name = "zone_name", nullable = false, length = 100)
    private String zoneName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}