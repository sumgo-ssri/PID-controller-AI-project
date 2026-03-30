package com.develop.capstoneproject.feedback;

import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
public class FeedbackRequestDto {

    private String zoneId;

    private TemperatureStatus temperatureStatus;

    private String message;

}
