package com.develop.capstoneproject.control.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HvacControlRequestDto {
    private String action;   // "ON" / "OFF" / "SET_TEMP"
    private Float temperature;  // action이 SET_TEMP일 때만 사용
}
