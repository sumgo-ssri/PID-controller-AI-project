package com.develop.capstoneproject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    FEEDBACK_SUBMIT_SUCCESS("피드백 제출 성공");

    private final String message;
}
