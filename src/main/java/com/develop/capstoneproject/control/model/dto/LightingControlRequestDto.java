package com.develop.capstoneproject.control.model.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LightingControlRequestDto {
    private String action;  // "ON" / "OFF"
}
